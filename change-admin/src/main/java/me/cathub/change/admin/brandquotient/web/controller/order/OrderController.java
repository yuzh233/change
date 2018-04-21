package me.cathub.change.admin.brandquotient.web.controller.order;

import me.cathub.change.api.rpc.server.order.OrderRpcRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRpcRpcServer orderRpcServer;
}
