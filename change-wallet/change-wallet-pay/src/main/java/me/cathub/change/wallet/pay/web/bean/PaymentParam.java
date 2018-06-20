package me.cathub.change.wallet.pay.web.bean;

/**
 * 付款所携带的参数类
 * @author cheng
 * @date 2018/5/26
 * @time 21:14
 */
public class PaymentParam {

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 支付宝返回的订单号
     */
    private String tradeNo;

    /**
     * 交易标题
     */
    private String title;

    /**
     * 交易内容
     */
    private String content;

    /**
     * 交易金额
     */
    private float totalAmount;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 异步通知地址
     */
    private String notifyUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentParam{");
        sb.append("outTradeNo='").append(outTradeNo).append('\'');
        sb.append(", tradeNo='").append(tradeNo).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", totalAmount=").append(totalAmount);
        sb.append('}');
        return sb.toString();
    }
}
