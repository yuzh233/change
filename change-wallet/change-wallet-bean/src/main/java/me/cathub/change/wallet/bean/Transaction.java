package me.cathub.change.wallet.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易信息
 *
 * @author cheng
 */
public class Transaction implements Serializable {

    public static final int PAY_TYPE_YL = 1;
    public static final int PAY_TYPE_ZFB = 2;
    public static final int PAY_TYPE_WX = 3;

    /**
     * 交易类型:充值/转账/提现
     */
    public static final int TYPE_INPUT = 1;
    public static final int TYPE_TRANS = 2;
    public static final int TYPE_OUTPUT = 3;

    public static final int STATUS_FAILED = -1;
    public static final int STATUS_SUCCESS = 1;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private float amount;
    private String message;

    /**
     * 交易方向 : 入(充值)/出(提现)
     */
    private int type;

    /**
     * 交易类型 : 支付宝、微信、银联...
     */
    private int payType;
    private int status;

    /**
     * 第三方平台返回的ID标识
     */
    private String returnId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    private int sendUserType;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long sendUserId;

    private int receiveUserType;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long receiveUserId;

    private User sendUser;
    private User receiveUser;

    public Transaction(long id) {
        this.id = id;
    }

    public Transaction() {
    }

    public int getSendUserType() {
        return sendUserType;
    }

    public void setSendUserType(int sendUserType) {
        this.sendUserType = sendUserType;
    }

    public int getReceiveUserType() {
        return receiveUserType;
    }

    public void setReceiveUserType(int receiveUserType) {
        this.receiveUserType = receiveUserType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public User getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(User receiveUser) {
        this.receiveUser = receiveUser;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", message='").append(message).append('\'');
        sb.append(", type=").append(type);
        sb.append(", payType=").append(payType);
        sb.append(", status=").append(status);
        sb.append(", returnId='").append(returnId).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", sendUserType=").append(sendUserType);
        sb.append(", sendUserId=").append(sendUserId);
        sb.append(", receiveUserType=").append(receiveUserType);
        sb.append(", receiveUserId=").append(receiveUserId);
        sb.append(", sendUser=").append(sendUser);
        sb.append(", receiveUser=").append(receiveUser);
        sb.append('}');
        return sb.toString();
    }
}
