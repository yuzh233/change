package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.Order;

public interface OrderRpcServer extends BaseService<Order>, FillAssociationDate<Order> {
}