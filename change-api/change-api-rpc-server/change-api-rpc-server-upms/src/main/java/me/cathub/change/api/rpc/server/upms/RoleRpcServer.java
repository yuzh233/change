package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.upms.Role;

public interface RoleRpcServer extends BaseRpcServer<Role>, ServerSelectByName<Role> {
}