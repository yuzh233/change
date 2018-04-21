package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.upms.bean.Permission;

public interface PermissionRpcServer extends BaseRpcServer<Permission>, FillAssociationDate<Permission> {
}