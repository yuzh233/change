package me.cathub.change.admin.order.web.controller;

import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.order.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单模块 - 订单
 *
 * @author zhang
 */
@Controller
@RequestMapping("/order")
public class OrderManagerController extends BaseAdminControllerImpl<Order, OrderRpcServer> {

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(Order bean) throws Exception {
//        //关联仓库、卖家、品牌商信息
//        if (bean.getStorehouse() != null) {
//            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouse().getId()), true);
//            if (storehouse == null) {
//                return false;
//            }
//            bean.setStorehouse(storehouse);
//        }
//        if (bean.getShopkeeper() != null) {
//            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper().getId()), true);
//            if (shopkeeper == null) {
//                return false;
//            }
//            bean.setShopkeeper(shopkeeper);
//        }
//        if (bean.getBrandQuotient() != null) {
//            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient().getId()), true);
//            if (brandQuotient == null) {
//                return false;
//            }
//            bean.setBrandQuotient(brandQuotient);
//        }
        return false;
    }

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Order());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Order(), !del_flag);
    }

    @Override
    @ModelAttribute
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Order order = rpcService.select(new Order(id), false);
            map.put("order", order);
        }
    }
}

