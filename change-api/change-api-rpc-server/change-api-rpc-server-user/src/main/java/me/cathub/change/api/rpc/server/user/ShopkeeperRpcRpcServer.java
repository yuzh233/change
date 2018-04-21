package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Shopkeeper;

public interface ShopkeeperRpcRpcServer extends BaseRpcServer<Shopkeeper>, FillAssociationDate<Shopkeeper> {
}
