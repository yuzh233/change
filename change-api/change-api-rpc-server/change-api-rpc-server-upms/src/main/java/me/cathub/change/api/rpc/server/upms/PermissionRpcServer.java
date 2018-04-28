package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.upms.bean.Permission;

import java.util.List;

public interface PermissionRpcServer extends BaseRpcServer<Permission>, FillAssociationDate<Permission>, ServerSelectByName<Permission> {

    /**
     * 根据角色获取权限列表
     * @param role_id 角色id
     * @return
     */
    List<Permission> listByRoleId(long role_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据角色获取权限数量
     * @param role_id
     * @return
     * @throws Exception
     */
    int countByRoleId(long role_id, int tableIndex) throws Exception;
}