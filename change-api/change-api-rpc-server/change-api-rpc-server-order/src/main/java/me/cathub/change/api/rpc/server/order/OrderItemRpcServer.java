package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.OrderItem;

import java.util.List;

/**
 * 订单项Rpc服务接口
 *
 * @author cheng
 */
public interface OrderItemRpcServer extends BaseRpcServer<OrderItem>,FillAssociationDate<OrderItem> {

    /**
     * 根据订单获取订单项列表
     * @param orderId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<OrderItem> listByOrderId(long orderId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据订单获取订单项数量
     * @param orderId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByOrderId(long orderId, int tableIndex) throws Exception;
}