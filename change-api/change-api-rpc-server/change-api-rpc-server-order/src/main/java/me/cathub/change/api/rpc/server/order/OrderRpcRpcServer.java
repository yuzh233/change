package me.cathub.change.api.rpc.server.order;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.Order;

public interface OrderRpcRpcServer extends BaseRpcServer<Order>, FillAssociationDate<Order> {
}