package me.cathub.change.admin.brandquotient.web.controller.storehouse;

import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.storehouse.bean.Storehouse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 仓库模块 - 仓库实体
 */
@Controller
@RequestMapping("/storehouse")
public class StorehouseController extends BaseControllerImpl<Storehouse, StorehouseRpcServer> {
}
