package me.cathub.change.wallet.pay.common;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * 支付宝支付服务
 *
 * @author cheng
 */
public class AliPayClient {

    private static final String URL = "https://openapi.alipaydev.com/gateway.do";
    private static final String APP_ID = "2016091500516013";
    private static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCduXgPyPGMN1HReILNZIDrk25yFUkAmCsRC/vNAdWfwZmYD7hew51fFQp0ydeuj0HQbGUQ/4ECAP3X9pV3dOZI0cx9FRWm0KuOvPwPMNmZ0hefqro5kFETG0j0a44AxXKMHj6ur7/MrHRf/rgAAMIAnciac0R62jWFbhMlpWgjvM00+4PS1BbkkHwjMOgDtC5IGjBGVkUaTFBA3Zi0R6G+8qNcNnBWadIjkIzL0w5fbBl2WmGyRY4R51BOXctAbtuOnF3xncOCpJ4x+s3k3PsXv4BCUwYpqhn4NvyQsg31ht0iKQG88so+IUcZTU6zXBcHrvscTiZCkA40WY7eXP+JAgMBAAECggEAEBpWcq4eUyV2uf8mw5eGPgbwWL9pk6D1jKj/jT+pssTOTKMWPL6V+5YnWiMdXRoNKx1V+DVN04mMYRcwzWBm/npE+WREsKJPUaRjy50+KiEz/j4tAyGD1YKMoT+14MhH2Jxh4+3XlCrrOr3DxWROakexqmsoS66pljTVyZsolbVQ5cZrxpQCWC/f2/LIlBS0X16KWLWzH78xughGb0yAK5mXekQ/d81rBmeJiTrwzkW8PPjQAOUoyWKkm3JJNQrQ22LSdm+7AcilVWQvQHnTu5iF8eguLi+kubEZNy+z0O13c90EaFXacGMEKhs759gUJxrhNs03K12kPpOj5x3UPQKBgQDO33QAEcHDVwJVKvSLVWTinslkOQpBmrCbmzBmG6B6epOZKQ7YgY6Z+ABApCg+S17K3Eqa9/UcB5Qc8Hh/gpHNQ5//Jt6tDMw5J8o+2+IVCAct7xhTTEuZzkn0/X6nnBTK7ygiVQ0K8Bbse1sa06TGvAtANFawbHCWZt1XvEbH5wKBgQDDLhvnzhadT7far3Ckzo1puy/AQhgtYGAniMo4KQzLDke8f5v9wU9FCE3rBVRX0WG6ZHT50QjfXhlGVyp73FFfA7gU0ygE10T5Gx6DdIbio9qyayzr72WBc6kLY+A4wdjmfkgkLzlRB4JbCHxmB7yrk9+1yprBrzgpK1eewGFPDwKBgQC+x9Y7piSSWDCfiKDDynnigNtroSrzO4x5xJHK6NmDen2Z9wJo6novRkY9VuaCJJID9UqcReX29opCcgY+WZTKvv3Tme4rmyzP3QEoHTIPgTrVwrUlRKxH6LXNyOW//zIxwIK7vsHrf2U0q8JmKB7C5HJfwKTdyPO/0Jd6LPj9qwKBgFCYW6GOsjvnTS4aP9NuD2rXhtJG+KDUKSBqFca2/LdkgC7QKuPPzSHeWf5wRvG0XjyPetYlgRprStiG6d4XjepEKOFAiEfndG3AywrRNVmk+4utQfFy+2FHF0jCxzXopd4Xy0ZV0b8p8KQSjvu6uifHehshPGI6LmChqx68pfH1AoGAItUsyZdmln9nKVohsKGt86A+ehAPVOACfOHUFUejCY151EjLoqHS6DQMd2CcgmQVXcgFwYuDgJ2QvZhepzBDYax9CGV6g+VzA3av1G20gFMIS4ekAHUmzxe4jBF60eSPRtGFmLRkK5BvH5cT4w78UfRqH4BEGsXh2VjTZx3qLng=";
    private static final String FORMAT = "json";
    public static final String CHARSET = "utf-8";
    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv9OGrS17SjSiha3OelK4O8OgGXYgw6KCl/KeudYvlr5TOc6jKKOJcxtuagExHAIgWCtLCgFd4CYoLIHwJ7DgepUXw/WHuu+ogM/t434hD3zuZanZmLaxozBjbBblSlD4Nr03xJ1J+8sgujD06PILq+91noPCQeTO5H4JE2l2d4cbVJTwa/3kWFyIe6QFFY/TV9bSdhB5vpzUzKHxzvufhmhcyC4Aymx9AwJs7scS1Nb+WzTcKa35MrKMVWUN4uTKUbcfrJlU/JYdCzBbI2G0PS7oYL8y9PCdAPMGNEx5kUsjgF4lHEekCjFFEVxAlPjwSUc4clSHRdGdAva0p+9g/QIDAQAB";
    private static final String SLGN_TYPE = "RSA2";

    /**
     * 1. 支付宝网关
     * 2. 应用ID
     * 3. 开发者密匙 (开发者生成)
     * 4. 参数返回格式
     * 5. 编码集
     * 6. 支付宝公匙 (支付宝生成)
     * 7. 商户生成签名字符串所使用的签名算法类型 (RSA2/RSA) '推荐RSA2'
     */
    private static final AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SLGN_TYPE);

    public static AlipayClient getAlipayClient() {
        return alipayClient;
    }

    /**
     *  添加了get方法 用于支付宝回调时验签
     *  z.yu
     */
    public static String getURL() {
        return URL;
    }

    public static String getAppId() {
        return APP_ID;
    }

    public static String getAppPrivateKey() {
        return APP_PRIVATE_KEY;
    }

    public static String getFORMAT() {
        return FORMAT;
    }

    public static String getCHARSET() {
        return CHARSET;
    }

    public static String getAlipayPublicKey() {
        return ALIPAY_PUBLIC_KEY;
    }

    public static String getSlgnType() {
        return SLGN_TYPE;
    }
}
