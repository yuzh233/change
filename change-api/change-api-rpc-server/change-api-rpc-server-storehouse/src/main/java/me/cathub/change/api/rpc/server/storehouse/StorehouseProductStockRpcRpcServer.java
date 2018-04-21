package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

public interface StorehouseProductStockRpcRpcServer extends BaseRpcServer<StorehouseProductStock>, FillAssociationDate<StorehouseProductStock> {
}
