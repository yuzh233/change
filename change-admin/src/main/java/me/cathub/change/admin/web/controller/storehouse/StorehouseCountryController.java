package me.cathub.change.admin.web.controller.storehouse;

import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storehouseCountry")
public class StorehouseCountryController extends BaseControllerImpl<StorehouseCountry, StorehouseCountryRpcServer> {
}
