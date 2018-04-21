package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.storehouse.bean.Storehouse;

public interface StorehouseRpcServer extends BaseRpcServer<Storehouse>, FillAssociationDate<Storehouse> {
}
