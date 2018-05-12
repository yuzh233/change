package me.cathub.change.common.bean.wallet;

import me.cathub.change.common.bean.user.Admin;
import me.cathub.change.common.bean.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户提现审核
 */
public class OutputAuditing implements Serializable {

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

    /**
     * 提现方式为:银联
     */
    public static final int OUTPUT_TYPE_YL = 1;

    /**
     * 提现方式为:支付宝
     */
    public static final int OUTPUT_TYPE_ZFB = 2;

    /**
     * 提现方式为:微信
     */
    public static final int OUTPUT_TYPE_WX = 3;

    private long id;

    /**
     * 审核提交日期
     */
    private Date auditSubmitDate;

    /**
     * 审核通过日期
     */
    private Date auditAllowDate;

    /**
     * 用户类型
     */
    private int type;

    /**
     * 提现类型
     */
    private int outputType;

    /**
     * 本次提现的金额
     */
    private float price;

    /**
     * 审核状态
     */
    private int status;

    /**
     * 审核不通过的原因
     */
    private String notAllowMessage;
    private int tableIndex;

    private long user_id;
    private long admin_id;

    /**
     * 谁发起提现申请的?
     */
    private User user;

    /**
     * 谁处理的申请?
     */
    private Admin admin;

    public OutputAuditing() {
    }

    public OutputAuditing(long id) {
        this.id = id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOutputType() {
        return outputType;
    }

    public void setOutputType(int outputType) {
        this.outputType = outputType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNotAllowMessage() {
        return notAllowMessage;
    }

    public void setNotAllowMessage(String notAllowMessage) {
        this.notAllowMessage = notAllowMessage;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OutputAuditing{");
        sb.append("id=").append(id);
        sb.append(", auditSubmitDate=").append(auditSubmitDate);
        sb.append(", auditAllowDate=").append(auditAllowDate);
        sb.append(", type=").append(type);
        sb.append(", outputType=").append(outputType);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", notAllowMessage='").append(notAllowMessage).append('\'');
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", user_id=").append(user_id);
        sb.append(", admin_id=").append(admin_id);
        sb.append(", user=").append(user);
        sb.append(", admin=").append(admin);
        sb.append('}');
        return sb.toString();
    }
}
