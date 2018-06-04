package me.cathub.change.apply.wallet.controller;

import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 钱包模块
 *
 * @Date: 2018/5/28
 * @Time: 16:31
 */

@Controller
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    OrderItemRpcServer orderItemRpcServer;
    @Autowired
    OrderRpcServer orderRpcServer;

    @Autowired
    ProductRpcServer productRpcServer;

    @Autowired
    BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    StorehouseProductStockRpcServer sorehouseProductStockRpcServer;

    @Autowired
    CompanyRpcServer companyRpcServer;

//    @Autowired
//    BalanceRpcServer balanceRpcServer;
    /**
     * 订单支付预览
     */
    @RequestMapping("/payment")
    public String payment(Long orderId, Model model, HttpSession session) throws Exception{
        if(orderId==null) { //订单错误
            model.addAttribute("messg","订单错误，请重新下单！");
            return "/payment/payment";
        }
        //loginUser
        User loginUser = (User)session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
//        //余额
//        Balance balance = balanceRpcServer.selectByUserId(loginUser.getId(), 0, true);

        Order order = orderRpcServer.select(new Order(orderId), true);  //订单
        /*
            订单状态
                1： 未付款
                2： 已付款已评价
                3： 已付款待评价
                4： 已取消
        */
        if(order==null || !order.getOrderCode().equals("1")) { //订单错误
            model.addAttribute("messg","订单错误，请重新下单！");
            return "/payment/payment";
        }
        List<OrderItem> orderItems = orderItemRpcServer.listByOrderId(orderId, 1, 10000, 0, true); //订单项
//        BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(order.getBrandQuotientId()), false); //
        // 所属企业
        Company company = companyRpcServer.select(new Company(order.getCompanyId()), true);


        StringBuilder sb = new StringBuilder(); //订单名称
        for(OrderItem item : orderItems) {
            Product product = productRpcServer.select(new Product(item.getProductId()), false);
            sb.append(product.getName() + " , ");

            // 更新订单价格
            StorehouseProductStock storehouseProductStock = sorehouseProductStockRpcServer.selectByStorehouseIdAndProductId(order.getStorehouseId(), product.getId(), 0, true);
            item.setUnitPrice(storehouseProductStock.getPrice());
            order.setTotalPrice(0f);
            order.setTotalPrice(order.getTotalPrice()+item.getUnitPrice()*item.getCount());
        }

        model.addAttribute("order",order);
        model.addAttribute("orderItems",orderItems);
        model.addAttribute("orderName",sb.toString());
        model.addAttribute("company",company);
        model.addAttribute("messg",null); //没有错误null
        model.addAttribute("balance",null);
        return "/payment/payment";
    }
}
