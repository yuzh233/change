package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.upms.bean.Role;

/**
 * 角色Rpc服务接口
 *
 * @author cheng
 */
public interface RoleRpcServer extends BaseRpcServer<Role>, ServerSelectByName<Role> {
}