package me.cathub.change.wallet.pay.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import me.cathub.change.wallet.pay.common.AliPayClient;
import me.cathub.change.wallet.pay.web.bean.PaymentParam;
import me.cathub.change.wallet.pay.web.bean.TransParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 支付宝支付
 *
 * @author cheng
 * @date 2018/5/26
 * @time 21:11
 */

@RequestMapping("/ali")
@Controller
public class AliPayController {

    private static final String APPLY_CODE = "1998";

    //商户系统订单号
    private static final String PARAM_OUT_TRADE_NO = "OUT_TRADE_NO";
    //订单名称 ，必填
    private static final String PARAM_SUBJECT = "SUBJECT";
    //商品描述，可空
    private static final String PARAM_BODY = "BODY";
    //交易总额
    private static final String PARAM_TOTAL_AMOUNT = "TOTAL_AMOUNT";
    //异步通知页面
    private static final String NOTIFY_URL = "";
    //同步通知页面
//    private static final String RETURN_URL = "http://localhost:8080/view/payment/success.jsp";
    private static final String RETURN_URL = "http://localhost:8080/order/orderRollback";

    /**
     * 手机网站支付模板
     */
    private static final String TEMPLET_M_PAYMENT = "{\"out_trade_no\":\"%s\",\"total_amount\":\"%s\",\"subject\":\"%s\",\"product_code\":\"QUICK_WAP_PAY\"}";

    /**
     * 电脑网站支付模板
     */
    private static final String TEMPLET_PC_PAYMENT = "{\"out_trade_no\":\"OUT_TRADE_NO\",\"product_code\":\"FAST_INSTANT_TRADE_PAY\",\"total_amount\":\"TOTAL_AMOUNT\",\"subject\":\"SUBJECT\",\"body\":\"BODY\",\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\",\"extend_params\":{\"sys_service_provider_id\":\"APPLY_CODE\"}}";

    /**
     * 支付历史查询模板
     */
    private static final String TEMPLET_PAYMENT_QUERY = "{\"out_trade_no\":\"%s\"}";

    /**
     * 转账模板
     */
    private static final String TEMPLET_TRANS = "{\"out_biz_no\":\"%s\",\"payee_type\":\"ALIPAY_LOGONID\",\"payee_account\":\"%s\",\"amount\":\"%s\",\"payer_show_name\":\"%s\",\"remark\":\"%s\"}";

    /**
     * 转账历史查询模板
     */
    private static final String TEMPLET_QUERY = "{\"out_biz_no\":\"%s\",\"order_id\":\"%s\"}";

    /**
     * 手机网站支付接口
     *
     * @param paymentParam
     * @param httpResponse
     * @throws Exception
     */
    @RequestMapping("/mPayment")
    public void mPayment(PaymentParam paymentParam, HttpServletResponse httpResponse) throws Exception {

        /**
         * Wap 手机网站支付 API
         */
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

        /**
         * 通知、回调页面,需要外网可访问到
         */
        alipayRequest.setReturnUrl(RETURN_URL);
        alipayRequest.setNotifyUrl(NOTIFY_URL);

        alipayRequest.setBizContent(String.format(
                TEMPLET_M_PAYMENT,
                paymentParam.getOutTradeNo(),
                paymentParam.getTotalAmount(),
                paymentParam.getTitle()
        ));

        String form = "";
        try {
            form = AliPayClient.getAlipayClient().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        httpResponse.setContentType("text/html;charset=" + AliPayClient.CHARSET);
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 电脑网站支付接口
     *
     * @param paymentParam
     * @param httpResponse
     */
    @RequestMapping("/pcPayment")
    public void pcPayment(PaymentParam paymentParam, HttpServletResponse httpResponse) throws Exception {
        /**
         * 电脑支付 API
         */
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        //公共参数
        alipayRequest.setReturnUrl(RETURN_URL);
        alipayRequest.setNotifyUrl(NOTIFY_URL);

        //业务请求参数，除公共参数外所有请求参数都必须放在这个参数中传递
        alipayRequest.setBizContent(getPcJson(paymentParam));

        String form = "";
        try {
            //发出请求，返回请求页面（支付宝收银台），把页面展示给用户。
            form = AliPayClient.getAlipayClient().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AliPayClient.CHARSET);

        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 根据商户订单号查询 (查询充值记录)
     * @param outTradeNo
     * @return
     * @throws Exception
     */
    @RequestMapping("/paymentQuery")
    @ResponseBody
    public String paymentQuery(String outTradeNo) throws Exception {

        /**
         * 查询 API
         */
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(String.format(
                TEMPLET_PAYMENT_QUERY,
                outTradeNo
        ));

        AlipayTradeQueryResponse response = AliPayClient.getAlipayClient().execute(request);
        if(response.isSuccess()){
            return response.getBody();
        } else {
            return "Request error~";
        }
    }

    /**
     * 转账接口
     * @throws Exception
     */
    @RequestMapping("/trans")
    @ResponseBody
    public String trans(TransParam transParam) throws Exception {
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        request.setBizContent(String.format(
                TEMPLET_TRANS,
                transParam.getOutBizNo(),
                transParam.getPayeeAccount(),
                transParam.getAmount(),
                transParam.getPayerShowName(),
                transParam.getRemark()
        ));

        AlipayFundTransToaccountTransferResponse response = AliPayClient.getAlipayClient().execute(request);
        if(response.isSuccess()){
            return response.getBody();
        } else {
            return "Request error~";
        }
    }

    /**
     *
     * @param outBizNo
     * @return
     * @throws Exception
     */
    @RequestMapping("/transQuery")
    @ResponseBody
    public String transQuery(String outBizNo, String orderId) throws Exception {
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        request.setBizContent(String.format(
                TEMPLET_QUERY,
                outBizNo,
                orderId
        ));

        AlipayFundTransOrderQueryResponse response = AliPayClient.getAlipayClient().execute(request);
        if(response.isSuccess()){
            return response.getBody();
        } else {
            return "Request error~";
        }
    }

    /**
     * 退款接口 (暂不支持)
     * @return
     * @throws Exception
     */
    /*public static String tradeReturn() throws Exception {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        request.setBizContent("{" +
                "\"out_trade_no\":\"20150320010101001\"," +
                "\"trade_no\":\"2014112611001004680073956707\"," +
                "\"refund_amount\":200.12," +
                "\"refund_currency\":\"USD\"," +
                "\"refund_reason\":\"正常退款\"," +
                "\"out_request_no\":\"HZ01RF001\"," +
                "\"operator_id\":\"OP001\"," +
                "\"store_id\":\"NJ_S_001\"," +
                "\"terminal_id\":\"NJ_T_001\"," +
                "      \"goods_detail\":[{" +
                "        \"goods_id\":\"apple-01\"," +
                "\"alipay_goods_id\":\"20010001\"," +
                "\"goods_name\":\"ipad\"," +
                "\"quantity\":1," +
                "\"price\":2000," +
                "\"goods_category\":\"34543238\"," +
                "\"body\":\"特价手机\"," +
                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
                "        }]" +
                "  }");

        AlipayTradeRefundResponse response = AliPayClient.getAlipayClient().execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }*/

    private final static String getPcJson(PaymentParam paymentParam) {
        return TEMPLET_PC_PAYMENT
                .replace(PARAM_OUT_TRADE_NO, paymentParam.getOutTradeNo())
                .replace(PARAM_SUBJECT, paymentParam.getTitle())
                .replace(PARAM_BODY, paymentParam.getContent())
                .replace(PARAM_TOTAL_AMOUNT, String.valueOf(paymentParam.getTotalAmount()));
    }

    public static void main(String[] args) throws Exception {
        TransParam transParam = new TransParam();
        transParam.setOutBizNo("10000002");
        transParam.setAmount("999");
        transParam.setPayeeAccount("pbduln3011@sandbox.com");
        transParam.setPayeeRealName("沙箱环境");
        transParam.setPayerShowName("退款");
        transParam.setRemark("备注信息");
    }
}
