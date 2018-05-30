package me.cathub.change.wallet.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户绑定支付宝 Dao
 *
 * @author cheng
 * @date 2018/5/27
 * @time 13:11
 */
public class AliPay implements Serializable {

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;

    /**
     * 支付宝账户
     */
    private String account;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户类型
     */
    private int type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long userId;

    private User user;

    public AliPay(long id) {
        this.id = id;
    }

    public AliPay() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AliPay{");
        sb.append("id=").append(id);
        sb.append(", account='").append(account).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", type=").append(type);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", userId=").append(userId);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
