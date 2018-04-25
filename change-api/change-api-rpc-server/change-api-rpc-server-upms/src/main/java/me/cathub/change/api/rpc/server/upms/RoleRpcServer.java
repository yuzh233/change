package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.upms.bean.Role;

public interface RoleRpcServer extends BaseRpcServer<Role>, SelectByName<Role> {
}