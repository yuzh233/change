package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.bean.storehouse.StorehouseProductStock;

import java.util.List;

public interface StorehouseProductStockDao extends BaseDao<StorehouseProductStock> {
    String NAME_SPACE = "StorehouseProductStock";

    String SELECT_BY_STOREHOUSE_ID_AND_PRODUCT_ID = ".selectByStorehouseIdAndProductId";
    String LIST_BY_STOREHOUSE_ID = ".listByStorehouseId";
    String COUNT_BY_STOREHOUSE_ID = ".countByStorehouseId";

    /**
     * 根据仓库和产品查找库存
     * @param storehouse_id
     * @param product_id
     * @return
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouse_id, long product_id, int tableIndex) throws Exception;

    /**
     * 根据仓库得到产品库存列表
     * @param storehouse_id
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据仓库得到产品库存数量
     * @param storehouse_id
     * @return
     * @throws Exception
     */
    int countByStorehouseId(long storehouse_id, int tableIndex) throws Exception;
}
