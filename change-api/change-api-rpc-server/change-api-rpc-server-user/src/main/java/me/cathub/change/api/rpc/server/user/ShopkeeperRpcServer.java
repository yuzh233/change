package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Shopkeeper;

public interface ShopkeeperRpcServer extends BaseService<Shopkeeper>, FillAssociationDate<Shopkeeper> {
}
