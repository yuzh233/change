package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.order.bean.Order;

import java.util.List;

/**
 * 订单Dao接口
 * @author cheng
 */
public interface OrderDao extends BaseDao<Order> {
    String NAME_SPACE = "Order";

    String LIST_BY_STOREHOUSE_ID = ".listByStorehouseId";
    String COUNT_BY_STOREHOUSE_ID = ".countByStorehouseId";
    String LIST_BY_SHOPKEEPER_ID = ".listByShopkeeperId";
    String COUNT_BY_SHOPKEEPER_ID = ".countByShopkeeperId";
    String LIST_BY_COMPANY_ID = ".listByCompanyId";
    String COUNT_BY_COMPANY_ID = ".countByCompanyId";

    /**
     * 根据仓库id获取订单列表
     * @param storehouseId  仓库id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              订单列表
     * @throws Exception    Sql throw exception
     */
    List<Order> listByStorehouseId(long storehouseId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据仓库id获取订单数量
     * @param storehouseId  仓库id
     * @param tableIndex    表索引
     * @return              订单数量
     * @throws Exception    Sql throw exception
     */
    int countByStorehouseId(long storehouseId, int tableIndex) throws Exception;

    /**
     * 根据借卖方获取订单列表
     * @param shopkeeperId  借卖方id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              订单列表
     * @throws Exception    Sql throw exception
     */
    List<Order> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据借卖方获取订单数量
     * @param shopkeeperId  借卖方id
     * @param tableIndex    表索引
     * @return              订单数量
     * @throws Exception    Sql throw exception
     */
    int countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception;

    /**
     * 根据企业获取订单列表
     * @param companyId     企业id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              订单列表
     * @throws Exception    Sql throw exception
     */
    List<Order> listByCompanyId(long companyId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据企业获取订单数量
     * @param companyId     企业id
     * @param tableIndex    表索引
     * @return              订单数量
     * @throws Exception    Sql throw exception
     *
     */
    int countByCompanyId(long companyId, int tableIndex) throws Exception;
}
