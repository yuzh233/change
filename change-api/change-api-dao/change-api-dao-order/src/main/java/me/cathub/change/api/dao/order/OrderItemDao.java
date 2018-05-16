package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.order.bean.OrderItem;

import java.util.List;

/**
 * 订单项Dao接口
 *
 * @author cheng
 */
public interface OrderItemDao extends BaseDao<OrderItem> {
    String NAME_SPACE = "OrderItem";

    String LIST_BY_ORDER_ID = ".listByOrderId";
    String COUNT_BY_ORDER_ID = ".countByOrderId";

    /**
     * 根据订单获取订单项列表
     * @param orderId       订单id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              订单项列表
     * @throws Exception    Sql throw exception
     */
    List<OrderItem> listByOrderId(long orderId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据订单获取订单项数量
     * @param orderId       订单id
     * @param tableIndex    表索引
     * @return              订单项列表
     * @throws Exception    Sql throw exception
     */
    int countByOrderId(long orderId, int tableIndex) throws Exception;
}
