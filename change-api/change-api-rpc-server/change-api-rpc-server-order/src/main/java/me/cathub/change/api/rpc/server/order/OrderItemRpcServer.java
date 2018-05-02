package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.OrderItem;

import java.util.List;

public interface OrderItemRpcServer extends BaseRpcServer<OrderItem>,FillAssociationDate<OrderItem> {

    /**
     * 根据订单获取订单项列表
     * @param order_id
     * @returnException
     * @throws
     */
    List<OrderItem> listByOrderId(long order_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据订单获取订单项数量
     * @param order_id
     * @return
     * @throws Exception
     */
    int countByOrderId(long order_id, int tableIndex) throws Exception;
}