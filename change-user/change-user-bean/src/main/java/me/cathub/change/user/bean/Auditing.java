package me.cathub.change.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 入驻审核
 *
 * @author cheng
 */
public class Auditing implements Serializable {

    /**
     * 审核的用户类型为:品牌商
     */
    public static final int TYPE_BRAND_QUOTIENT = 1;

    /**
     * 审核的用户类型为:借卖方
     */
    public static final int TYPE_SHOPKEEPER = 2;

    /**
     * 状态为:没有管理员在处理审核
     */
    public static final int STATUS_NO_AUDIT = 0;

    /**
     * 状态为:管理员正在处理审核
     */
    public static final int STATUS_IN_THE_AUDIT = 1;

    /**
     * 状态为:审核通过
     */
    public static final int STATUS_ALLOW = 2;

    /**
     * 状态为:审核不通过
     */
    public static final int STATUS_NOT_ALLOW = 3;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditSubmitDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditAllowDate;
    private int type;
    private int status;

    /**
     * 审核不通过的原因
     */
    private String notAllowMessage;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long userId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long adminId;

    /**
     * 谁发起入驻申请的?
     */
    private User user;

    /**
     * 谁处理的这个申请?
     */
    private Admin admin;

    public Auditing() {
    }

    public Auditing(long id) {
        this.id = id;
    }

    public String getNotAllowMessage() {
        return notAllowMessage;
    }

    public void setNotAllowMessage(String notAllowMessage) {
        this.notAllowMessage = notAllowMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAuditSubmitDate() {
        return auditSubmitDate;
    }

    public void setAuditSubmitDate(Date auditSubmitDate) {
        this.auditSubmitDate = auditSubmitDate;
    }

    public Date getAuditAllowDate() {
        return auditAllowDate;
    }

    public void setAuditAllowDate(Date auditAllowDate) {
        this.auditAllowDate = auditAllowDate;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Auditing{" +
                "id=" + id +
                ", auditSubmitDate=" + auditSubmitDate +
                ", auditAllowDate=" + auditAllowDate +
                ", type=" + type +
                ", status=" + status +
                ", notAllowMessage='" + notAllowMessage + '\'' +
                ", tableIndex=" + tableIndex +
                ", userId=" + userId +
                ", adminId=" + adminId +
                ", user=" + user +
                ", admin=" + admin +
                '}';
    }
}
