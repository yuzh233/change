package me.cathub.change.wallet.pay.web.bean;

/**
 * 退款需要携带的参数
 * @author cheng
 * @date 2018/5/27
 * @time 10:49
 */
public class TradeReturnParam {

    private String outTradeNo;
    private String tradeNo;
    private String refundAmount;
    private String refundCurrency;
    private String refundReason;
    private String outRequestNo;
    private String operatorId;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TradeReturnParam{");
        sb.append("outTradeNo='").append(outTradeNo).append('\'');
        sb.append(", tradeNo='").append(tradeNo).append('\'');
        sb.append(", refundAmount='").append(refundAmount).append('\'');
        sb.append(", refundCurrency='").append(refundCurrency).append('\'');
        sb.append(", refundReason='").append(refundReason).append('\'');
        sb.append(", outRequestNo='").append(outRequestNo).append('\'');
        sb.append(", operatorId='").append(operatorId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
