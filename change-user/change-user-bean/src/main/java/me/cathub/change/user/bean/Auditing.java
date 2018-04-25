package me.cathub.change.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核
 */
public class Auditing implements Serializable {
    public static final int TYPE_BRAND_QUOTIENT = 1;
    public static final int TYPE_SHOPKEEPER = 2;

    private long id;
    private Date auditSubmitDate;
    private Date auditAllowDate;
    private int type;
    private int tableIndex;

    private long user_id;
    private long admin_id;

    private User user;
    private Admin admin;

    public Auditing() {
    }

    public Auditing(long id) {
        this.id = id;
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
                ", tableIndex=" + tableIndex +
                ", user_id=" + user_id +
                ", admin_id=" + admin_id +
                ", user=" + user +
                ", admin=" + admin +
                '}';
    }
}
