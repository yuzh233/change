package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.*;
import me.cathub.change.common.bean.user.Shopkeeper;

public interface ShopkeeperRpcServer extends BaseRpcServer<Shopkeeper>, FillAssociationDate<Shopkeeper>, ServerSelectByName<Shopkeeper> {
}
