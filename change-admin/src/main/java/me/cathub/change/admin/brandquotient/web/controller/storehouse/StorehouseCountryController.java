package me.cathub.change.admin.brandquotient.web.controller.storehouse;

import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storehouseCountry")
public class StorehouseCountryController {

    @Autowired
    private StorehouseCountryRpcServer storehouseCountryRpcServer;
}