package me.cathub.change.admin.brandquotient.web.controller.storehouse;

import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 仓库模块 - 产品实体
 */
@Controller
@RequestMapping("/storehouseProductStock")
public class StorehouseProductStockController extends BaseControllerImpl<StorehouseProductStock, StorehouseProductStockRpcServer> {
}
