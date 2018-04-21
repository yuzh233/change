package me.cathub.change.admin.brandquotient.web.controller.order;

import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.order.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseControllerImpl<Order, OrderRpcServer> {

    @Autowired
    private OrderRpcServer orderRpcServer;
}
