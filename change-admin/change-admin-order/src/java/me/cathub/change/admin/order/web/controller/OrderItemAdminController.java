package me.cathub.change.admin.order.web.controller;

import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.order.bean.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单模块 - 订单详情
 *
 * @author zhang
 */
@Controller
@RequestMapping("/orderItem")
public class OrderItemAdminController extends BaseAdminControllerImpl<OrderItem, OrderItemRpcServer> {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private OrderRpcServer orderRpcServer;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(OrderItem bean) throws Exception {
//        //根据订单项单价*数量得出订单项总价
//        //四舍五入单价
//        BigDecimal b = new BigDecimal(bean.getUnitPrice());
//        float unitPrice = b.setScale(1, RoundingMode.HALF_UP).floatValue();
//        bean.setUnitPrice(unitPrice);
//        //总价
//        bean.setTotalPrice(unitPrice * bean.getCount());
//        //关联产品、总订单信息
//        if (bean.getProduct() != null) {
//            Product product = productRpcServer.select(new Product(bean.getProduct().getId()), true);
//            if (product == null) {
//                return false;
//            }
//            bean.setProduct(product);
//        }
//        if (bean.getOrder() != null) {
//            Order order = orderRpcServer.select(new Order(bean.getOrder().getId()), true);
//            if (order == null) {
//                return false;
//            }
//            //更新总订单的订单总额
//            order.setTotalPrice(order.getTotalPrice() + bean.getTotalPrice());
//            orderRpcServer.update(order);//这个和插入订单项应该放在事务中
//            bean.setOrder(order);
//        }
        return false;
    }

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new OrderItem());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new OrderItem(), !del_flag);
    }

}

