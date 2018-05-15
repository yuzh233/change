package me.cathub.change.admin.order.web.controller;

import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.order.Order;
import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单模块 - 订单
 */

@Controller
@RequestMapping("/order")
public class OrderController extends BaseControllerImpl<Order, OrderRpcServer> {

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @ModelAttribute
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Order order = rpcService.select(new Order(id), false);
            map.put("order", order);
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Order bean) throws Exception {
        //关联仓库、卖家、品牌商信息
        if (bean.getStorehouse() != null) {
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouse().getId()), true);
            if (storehouse == null) {
                return false;
            }
            bean.setStorehouse(storehouse);
        }
        if (bean.getShopkeeper() != null) {
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper().getId()), true);
            if (shopkeeper == null) {
                return false;
            }
            bean.setShopkeeper(shopkeeper);
        }
        if (bean.getBrandQuotient() != null) {
            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient().getId()), true);
            if (brandQuotient == null) {
                return false;
            }
            bean.setBrandQuotient(brandQuotient);
        }
        return rpcService.insert(bean) != -1;
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Order(), !del_flag);
    }
}

