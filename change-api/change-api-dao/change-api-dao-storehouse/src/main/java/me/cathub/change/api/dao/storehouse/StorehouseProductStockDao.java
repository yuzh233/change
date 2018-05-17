package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

import java.util.List;

/**
 * 仓库产品库存Dao接口
 *
 * @author cheng
 */
public interface StorehouseProductStockDao extends BaseDao<StorehouseProductStock> {
    String NAME_SPACE = "StorehouseProductStock";

    String SELECT_BY_STOREHOUSE_ID_AND_PRODUCT_ID = ".selectByStorehouseIdAndProductId";
    String LIST_BY_STOREHOUSE_ID = ".listByStorehouseId";
    String COUNT_BY_STOREHOUSE_ID = ".countByStorehouseId";

    /**
     * 根据仓库和产品查找库存
     * @param storehouseId
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex) throws Exception;

    /**
     * 根据仓库得到产品库存列表
     * @param storehouseId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据仓库得到产品库存数量
     * @param storehouseId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseId(long storehouseId, int tableIndex) throws Exception;
}
