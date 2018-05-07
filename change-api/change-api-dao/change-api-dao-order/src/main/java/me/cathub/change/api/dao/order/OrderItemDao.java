package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.bean.order.OrderItem;

import java.util.List;

public interface OrderItemDao extends BaseDao<OrderItem> {
    String NAME_SPACE = "OrderItem";

    String LIST_BY_ORDER_ID = ".listByOrderId";
    String COUNT_BY_ORDER_ID = ".countByOrderId";

    /**
     * 根据订单获取订单项列表
     * @param order_id
     * @return
     * @throws Exception
     */
    List<OrderItem> listByOrderId(long order_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据订单获取订单项数量
     * @param order_id
     * @return
     * @throws Exception
     */
    int countByOrderId(long order_id, int tableIndex) throws Exception;
}
