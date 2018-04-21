package me.cathub.change.admin.brandquotient.web.controller.storehouse;

import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storehouseProductStock")
public class StorehouseProductStockController {

    @Autowired
    private StorehouseProductStockRpcRpcServer storehouseProductStockRpcServer;
}
