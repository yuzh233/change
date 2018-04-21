package me.cathub.change.admin.brandquotient.web.controller.order;

import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.order.bean.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController extends BaseControllerImpl<OrderItem, OrderItemRpcServer> {
}
