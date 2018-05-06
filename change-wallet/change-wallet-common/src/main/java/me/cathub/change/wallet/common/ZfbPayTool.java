package me.cathub.change.wallet.common;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class ZfbPayTool {
    AlipayClient client = new DefaultAlipayClient(
            ZfbPayConfig.GATEWAY_URL,
            ZfbPayConfig.APP_ID,
            ZfbPayConfig.MERCHANT_PRIVATE_KEY,
            "json",
            ZfbPayConfig.CHARSET,
            ZfbPayConfig.ALIPAY_PUBLIC_KEY,
            ZfbPayConfig.SIGN_TYPE
    );

    public static void main(String[] args) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        request.setBizContent("{}");
    }
}
