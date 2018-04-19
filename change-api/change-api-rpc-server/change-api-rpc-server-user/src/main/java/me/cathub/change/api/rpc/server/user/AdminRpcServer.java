package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Admin;

public interface AdminRpcServer extends BaseService<Admin>, FillAssociationDate<Admin> {
}
