package me.cathub.change.wallet.pay.web.bean;

/**
 * 转账所需的参数
 * @author cheng
 * @date 2018/5/27
 * @time 10:04
 */
public class TransParam {

    /**
     * id
     */
    private String outBizNo;

    /**
     * 收钱方账户
     */
    private String payeeAccount;

    /**
     * 收钱方真实姓名
     */
    private String payeeRealName;

    /**
     * 金额
     */
    private String amount;

    /**
     * 类似标题
     */
    private String payerShowName;

    /**
     * 备注
     */
    private String remark;

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getPayeeRealName() {
        return payeeRealName;
    }

    public void setPayeeRealName(String payeeRealName) {
        this.payeeRealName = payeeRealName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayerShowName() {
        return payerShowName;
    }

    public void setPayerShowName(String payerShowName) {
        this.payerShowName = payerShowName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransParam{");
        sb.append("outBizNo='").append(outBizNo).append('\'');
        sb.append(", payeeAccount='").append(payeeAccount).append('\'');
        sb.append(", payeeRealName='").append(payeeRealName).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", payerShowName='").append(payerShowName).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
