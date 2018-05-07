package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.bean.storehouse.StorehouseProductStock;

import java.util.List;

public interface StorehouseProductStockRpcServer extends BaseRpcServer<StorehouseProductStock>, FillAssociationDate<StorehouseProductStock> {

    /**
     * 根据仓库和产品查找库存
     * @param storehouse_id
     * @param product_id
     * @return
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouse_id, long product_id, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存列表
     * @param storehouse_id
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存数量
     * @param storehouse_id
     * @return
     * @throws Exception
     */
    int countByStorehouseId(long storehouse_id, int tableIndex) throws Exception;
}
