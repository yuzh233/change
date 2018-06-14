package me.cathub.change.apply.wallet.controller;

import me.cathub.change.api.rpc.server.wallet.BalanceRpcServer;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.wallet.bean.Balance;
import me.cathub.change.wallet.pay.web.bean.PaymentParam;
import me.cathub.change.wallet.pay.web.bean.TransParam;
import me.cathub.change.wallet.pay.web.controller.AliPayController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 资金处理类
 * <p>
 * 资金转账-账户转账
 * 请求地址：https://openapi.alipay.com/gateway.do
 * 公共参数：见 me.cathub.change.wallet.pay.common.AliPayClient
 * 请求参数：
 * out_biz_no：转账发起方定义的唯一ID
 * payee_type：收款方账户类型（支付宝唯一用户号，全数字 / 支付宝登录号，邮箱或手机）
 * payee_account：收款方账户，与账户类型保持对应。
 * amount：转账金额
 * payer_show_name：收款方名，可选，如未填显示的是收款方支付宝认证名
 * payee_real_name：收款方真实名，可选，如填写会校验改名字是否与收款方认证的真实名字的一致性。
 * remark：备注
 * 响应参数：
 * 公共响应参数：略
 * out_biz_no：商户转账唯一订单号，即请求参数中的out_biz_no，相应之后原样返回。
 * order_id：支付宝转账单据号，转账成功一定返回。
 * pay_date：支付时间
 *
 * @Author: z.yu
 * @Date: 2018/06/04 10:08
 */
@Controller
@RequestMapping("/trans")
public class FundController {

    @Autowired
    private BalanceRpcServer balanceRpcServer;

    /**
     * 充值
     *
     * @return
     */
    @RequestMapping("/recharge")
    @ResponseBody
    public Object recharge(HttpServletResponse response, PaymentParam paymentParam) throws Exception {
        paymentParam.setOutTradeNo(UUID.randomUUID().toString());
        paymentParam.setCallbackUrl("http://localhost:8080/apply/shopkeeper");
        paymentParam.setNotifyUrl("http://localhost:8080/trans/recharge_success");
        new AliPayController().pcPayment(paymentParam, response);
        return null;
    }

    /**
     * 充值成功异步回调地址
     */
    public void recharge_success(HttpServletRequest request){
        System.out.println("异步回调");
    }

    /**
     * 提现（异步请求）
     *
     * @return
     */
    @RequestMapping("/withdraw")
    @ResponseBody
    public boolean withdraw(TransParam transParam, HttpServletRequest request) throws Exception {
        transParam.setOutBizNo(UUID.randomUUID().toString());
        String result = new AliPayController().trans(transParam);
        if ("Request error~".equals(result)) {
            return false;
        }
        //账户余额减少
        User user = (User) request.getSession().getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        Balance balance = balanceRpcServer.selectByUserId(user.getId(), 0, true);
        balance.setBalance(balance.getBalance() - Float.parseFloat(transParam.getAmount()));
        balanceRpcServer.update(balance);
        return true;
    }

    /**
     * 充值记录查询
     *
     * @return
     */
    @RequestMapping("/rechargeQuery")
    @ResponseBody
    public Object rechargeQuery() {

        return null;
    }

}
