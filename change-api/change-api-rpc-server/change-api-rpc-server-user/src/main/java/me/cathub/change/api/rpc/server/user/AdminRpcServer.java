package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.user.Admin;

public interface AdminRpcServer extends BaseRpcServer<Admin>, FillAssociationDate<Admin>, ServerSelectByName<Admin> {
}
