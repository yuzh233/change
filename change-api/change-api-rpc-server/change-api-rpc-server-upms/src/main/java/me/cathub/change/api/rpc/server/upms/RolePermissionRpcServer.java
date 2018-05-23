package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.upms.bean.RolePermission;

import java.util.List;

/**
 * 角色权限Rpc服务接口
 *
 * @author cheng
 */
public interface RolePermissionRpcServer extends BaseRpcServer<RolePermission> {

    /**
     * 根据角色和应用查询权限列表
     * @param roleId
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<RolePermission> listByRoleIdAndApplyId(long roleId, long applyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据角色和应用查询权限数量
     * @param roleId
     * @param applyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleIdAndApplyId(long roleId, long applyId, int tableIndex) throws Exception;

    /**
     * 根据角色查询权限列表
     * @param roleId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<RolePermission> listByRoleId(long roleId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据角色查询权限数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;

    /**
     * 根据应用查询权限列表
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<RolePermission> listByApplyId(long applyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据应用查询权限数量
     * @param applyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByApplyId(long applyId, int tableIndex) throws Exception;
}
