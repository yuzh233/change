package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.Order;

import java.util.List;

/**
 * 订单Rpc服务接口
 *
 * @author cheng
 */
public interface OrderRpcServer extends BaseRpcServer<Order>, FillAssociationDate<Order> {

    /**
     * 根据仓库id获取订单列表
     * @param storehouseId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Order> listByStorehouseId(long storehouseId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库id获取订单数量
     * @param storehouseId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    long countByStorehouseId(long storehouseId, int tableIndex) throws Exception;

    /**
     * 根据借卖方获取订单列表
     * @param shopkeeperId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Order> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据借卖方获取订单数量
     * @param shopkeeperId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    long countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception;

    /**
     * 根据品牌商获取订单列表
     * @param brandQuotientId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Order> listByBrandQuotient(long brandQuotientId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据品牌商获取订单数量
     * @param brandQuotientId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    long countBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception;
}