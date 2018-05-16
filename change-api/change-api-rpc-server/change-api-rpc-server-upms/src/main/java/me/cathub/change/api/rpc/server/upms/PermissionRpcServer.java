package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.upms.bean.Permission;

import java.util.List;

/**
 * 授权Rpc服务接口
 *
 * @author cheng
 */
public interface PermissionRpcServer extends BaseRpcServer<Permission>, FillAssociationDate<Permission>, ServerSelectByName<Permission> {

    /**
     * 根据角色获取权限列表
     * @param roleId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Permission> listByRoleId(long roleId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据角色获取权限数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;
}