package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

public interface StorehouseProductStockRpcServer extends BaseService<StorehouseProductStock>, FillAssociationDate<StorehouseProductStock> {
}
