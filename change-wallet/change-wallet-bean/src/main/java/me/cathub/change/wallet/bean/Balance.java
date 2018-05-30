package me.cathub.change.wallet.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户余额
 *
 * @author cheng
 */
public class Balance implements Serializable {

    /**
     * 账户类型为品牌商
     */
    public static final int TYPE_BRAND_QUOTIENT= 1;

    /**
     * 账户类型为借卖方
     */
    public static final int TYPE_SHOPKEEPER = 2;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private float balance;
    private int type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long userId;

    /**
     * 这钱是哪个账户的?
     */
    private User user;

    public Balance() {
    }

    public Balance(long id) {
        this.id = id;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Balance{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", type=").append(type);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", userId=").append(userId);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
