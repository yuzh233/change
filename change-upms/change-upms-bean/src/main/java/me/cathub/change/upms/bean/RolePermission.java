package me.cathub.change.upms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限
 *
 * @author cheng
 */
public class RolePermission implements Serializable {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long roleId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long applyId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long permissionId;

    /**
     * 角色
     */
    private Role role;

    /**
     * 应用
     */
    private Apply apply;

    /**
     * 具体权限
     */
    private Permission permission;

    public RolePermission() {
    }

    public RolePermission(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RolePermission{");
        sb.append("id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", roleId=").append(roleId);
        sb.append(", applyId=").append(applyId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", role=").append(role);
        sb.append(", apply=").append(apply);
        sb.append(", permission=").append(permission);
        sb.append('}');
        return sb.toString();
    }
}
