package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

import java.util.List;

/**
 * 仓库产品库存Rpc服务接口
 *
 * @author cheng
 */
public interface StorehouseProductStockRpcServer extends BaseRpcServer<StorehouseProductStock>, FillAssociationDate<StorehouseProductStock> {

    /**
     * 根据仓库和产品查找库存
     * @param storehouseId
     * @param productId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存列表
     * @param storehouseId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存数量
     * @param storehouseId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseId(long storehouseId, int tableIndex) throws Exception;
}
