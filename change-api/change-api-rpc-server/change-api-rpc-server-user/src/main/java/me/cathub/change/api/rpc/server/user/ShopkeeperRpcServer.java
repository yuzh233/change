package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.user.bean.Shopkeeper;

/**
 * B2C店主Rpc服务接口
 *
 * @author cheng
 */
public interface ShopkeeperRpcServer extends BaseRpcServer<Shopkeeper>, FillAssociationDate<Shopkeeper>, ServerSelectByName<Shopkeeper> {
}
