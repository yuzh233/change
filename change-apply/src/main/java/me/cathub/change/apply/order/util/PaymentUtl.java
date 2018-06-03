package me.cathub.change.apply.order.util;

import com.alipay.api.internal.util.AlipaySignature;
import me.cathub.change.wallet.pay.common.AliPayClient;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: z.yu
 * @Date: 2018/06/03 14:10
 */
public class PaymentUtl {

    public static boolean check(HttpServletRequest request) throws Exception {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayClient.getAlipayPublicKey(), AliPayClient.getCHARSET(), AliPayClient.getSlgnType());

        return signVerified;
    }
}
