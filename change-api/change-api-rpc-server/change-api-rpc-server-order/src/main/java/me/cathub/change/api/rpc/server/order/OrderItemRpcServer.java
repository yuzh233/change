package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.OrderItem;

import java.util.List;

public interface OrderItemRpcServer extends BaseService<OrderItem>,FillAssociationDate<OrderItem> {
}