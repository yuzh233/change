package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.user.Shopkeeper;

public interface ShopkeeperRpcServer extends BaseRpcServer<Shopkeeper>, FillAssociationDate<Shopkeeper>, DaoSelectByName<Shopkeeper> {
}
