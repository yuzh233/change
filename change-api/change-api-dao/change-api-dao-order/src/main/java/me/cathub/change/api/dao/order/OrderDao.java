package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.order.bean.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {
    String NAME_SPACE = "me.cathub.change.order.bean.Order";

    String LIST_BY_STOREHOUSE_ID = ".listByStorehouseId";
    String COUNT_BY_STOREHOUSE_ID = ".countByStorehouseId";
    String LIST_BY_SHOPKEEPER_ID = ".listByShopkeeperId";
    String COUNT_BY_SHOPKEEPER_ID = ".countByShopkeeperId";
    String LIST_BY_BRAND_QUOTIENT_ID = ".listByBrandQuotient";
    String COUNT_BY_BRAND_QUOTIENT_ID = ".countByBrandQuotient";

    /**
     * 根据仓库id获取订单列表
     * @param storehouse_id
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Order> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据仓库id获取订单数量
     * @param storehouse_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    long countByStorehouseId(long storehouse_id, int tableIndex) throws Exception;

    /**
     * 根据借卖方获取订单列表
     * @param shopkeeper_id
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Order> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据借卖方获取订单数量
     * @param shopkeeper_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    long countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception;

    /**
     * 根据品牌商获取订单列表
     * @param brandQuotient_id
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Order> listByBrandQuotient(long brandQuotient_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据品牌商获取订单数量
     * @param brandQuotient_id
     * @param tableIndex
     * @return
     */
    long countBrandQuotientId(long brandQuotient_id, int tableIndex);
}
