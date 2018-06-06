package me.cathub.change.apply.order.controller;

import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.apply.common.OrderAndItems;
import me.cathub.change.apply.order.util.PaymentUtl;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用户订单Controller
 *
 * @Author: YouJie
 * @Date: 2018/5/11
 * @Time: 21:47
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRpcServer orderRpcServer;
    @Autowired
    OrderItemRpcServer orderItemRpcServer;
    @Autowired
    BrandQuotientRpcServer brandQuotientRpcServer;
    @Autowired
    ProductRpcServer productRpcServer;
    @Autowired
    ProductImageRpcServer productImageRpcServer;
    @Autowired
    StorehouseProductStockRpcServer sorehouseProductStockRpcServer;
    @Autowired
    StorehouseCountryRpcServer storehouseCountryRpcServer;
    @Autowired
    StorehouseRpcServer storehouseRpcServer;
    @Autowired
    CompanyRpcServer companyRpcServer;

    /**
     * 支付宝支付成功后的回调URL
     * 1.回调之前验签。
     * 2.验签通过返回支付成功页面，展示订单信息。
     * @author z.yu
     * @datetime 2018-6-3 18:44
     */
    @RequestMapping("/orderCallback")
    public ModelAndView orderCallback(HttpServletRequest request) throws Exception {
        String page = "";
        Order order = null;
        List<OrderItem> orderItemList = new ArrayList<>();
        //验签
        if (PaymentUtl.check(request)) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            /** 封装支付成功的显示信息对象 **/
            order = orderRpcServer.select(new Order(Long.parseLong(out_trade_no)), false);
            //把支付宝返回交易号更新到order表的订单号字段（暂时）
            order.setOrderCode(trade_no);
            orderRpcServer.update(order);

            orderItemList = orderItemRpcServer.listByOrderId(Long.parseLong(out_trade_no), 0, 100, 0, false);
            for (OrderItem orderItem : orderItemList) {
                Product product = orderItem.getProduct();
                if (product == null) {
                    product = productRpcServer.select(new Product(orderItem.getProductId()), false);
                }
                //每个订单的产品的所属卖家（品牌商）
                BrandQuotient brandQuotient = product.getBrandQuotient();
                if (brandQuotient == null) {
                    long brandQuotientId = product.getBrandQuotientId();
                    brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(brandQuotientId), true);
                    //如果从数据库中查出来品牌商还是空！
                    if (brandQuotient == null) {
                        brandQuotient = new BrandQuotient();
                        //订单成功页面需要卖家名字，为了jsp页面不报错，填充空的数据。
                        brandQuotient.setName("null");
                        brandQuotient.setUsername("null");
                    }
                }
                //当前订单项的卖家（品牌商）
                product.setBrandQuotient(brandQuotient);
                orderItem.setProduct(product);
            }
            page = "payment/success";
        } else {
            request.setAttribute("message", "支付宝验签未通过！");
            page = "payment/fail";
        }
        ModelAndView modelAndView = new ModelAndView(page);
        modelAndView.addObject("order", order);
        modelAndView.addObject("orderItemList", orderItemList);
        return modelAndView;
    }

    /**
     * 订单预览（跳到订单页面）
     *
     * @return
     */
    @RequestMapping("/preview")
    public String preview(OrderAndItems order, HttpServletRequest request) throws Exception {
        request.setAttribute("order", order);
        return "order/order";
    }

    /**
     * 真实订单预览（异步加载订单详情）
     * //传商品id，仓库id, 数量
     *
     * @param order
     * @return
     * @throws Exception
     */
    @RequestMapping("/previewdata")
    @ResponseBody
    public HashMap previewdata(OrderAndItems order) throws Exception {
        HashMap<String, Object> model = new HashMap<>();
        StorehouseProductStock storehouseProductStock = null;

        if (order.getOrderItems() == null && order.getOrderItems().size() <= 0) {
            return null;
        }
        //图片
        List<ProductImage> imgs = new ArrayList<>();
        //商品id 数量 价格
        Product tempp = new Product();
        for (OrderItem item : order.getOrderItems()) {
            //商品基本信息
            tempp.setId(item.getProductId()); //-----
            Product product = productRpcServer.select(tempp, true);
            if (product == null) { //没有这个商品
                return null;
            }
            item.setProduct(product);
            //商品图片
            ProductImage productImage = productImageRpcServer.listByProductIdAndImageType(product.getId(), 0, 1, 0, 0, false).get(0);
            imgs.add(productImage);
            //商品库存  -------
            storehouseProductStock = sorehouseProductStockRpcServer.selectByStorehouseIdAndProductId(order.getStorehouseId(), product.getId(), 0, true);
            if (storehouseProductStock.getStock() < item.getCount() || item.getCount() <= 0) { //库存不足
                return null;
            }
            //----单价------
            item.setUnitPrice(storehouseProductStock.getPrice());

        }

        //卖家
//        BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(order.getOrderItems().get(0).getProduct().getBrandQuotientId()), true);
        BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(21735953194287104L), true);
        // 所属企业
        Company company = companyRpcServer.select(new Company(order.getOrderItems().get(0).getProduct().getCompanyId()), true);

        //那个仓库
        Storehouse storehouse = storehouseRpcServer.select(new Storehouse(storehouseProductStock.getStorehouseId()), true);
        //仓库国家
        StorehouseCountry country = storehouseCountryRpcServer.select(new StorehouseCountry(storehouse.getStorehouseCountryId()), true);


        model.put("company", company);
        model.put("brandQuotient", brandQuotient);
        model.put("storehouseProductStock", storehouseProductStock);
        model.put("storehouse", storehouse);
        model.put("country", country);
        model.put("order", order);
        model.put("imgs", imgs);
        return model;
    }


    /**
     * 提交订单
     *
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(OrderAndItems order, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        if (order.getOrderItems() == null) {
            return "redirect:/wallet/payment";      //没有参数
        }

        StorehouseProductStock storehouseProductStock = null;
        Order dborder = new Order();
        dborder.setMessage(order.getMessage());
        //loginUser
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        //买家是谁
        dborder.setShopkeeper((Shopkeeper) loginUser);
         /*
            订单状态
                1： 未付款
                2： 已付款已评价
                3： 已付款待评价
                4： 已取消
        */
        dborder.setOrderCode("1");

        //传商品id，仓库id, 数量
        //商品id 数量 价格
        Product tempp = new Product();
        for (OrderItem item : order.getOrderItems()) {
            //商品基本信息
            tempp.setId(item.getProductId()); //-----
            Product product = productRpcServer.select(tempp, true);
            if (product == null) { //没有这个商品
                return "redirect:/wallet/payment";      //没有参数
            }
            item.setProduct(product);
            item.setProductId(product.getId());
            //商品库存  -------
            storehouseProductStock = sorehouseProductStockRpcServer.selectByStorehouseIdAndProductId(order.getStorehouseId(), product.getId(), 0, true);
            if (storehouseProductStock.getStock() < item.getCount() || item.getCount() <= 0) { //库存不足
                return "redirect:/wallet/payment";      //没有参数
            }
            // 库存减掉购买的数量
            storehouseProductStock.setStock(storehouseProductStock.getStock() - item.getCount());
            sorehouseProductStockRpcServer.update(storehouseProductStock);
            //----单价------
            item.setUnitPrice(storehouseProductStock.getPrice());
            // 订单总金额
            dborder.setTotalPrice(dborder.getTotalPrice() + item.getUnitPrice() * item.getCount());
        }

        //卖家是谁
//        BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(order.getOrderItems().get(0).getProduct().getBrandQuotientId()), true);
//        dborder.setBrandQuotient(brandQuotient);

        // 所属企业
        Company company = companyRpcServer.select(new Company(order.getOrderItems().get(0).getProduct().getCompanyId()), true);
        dborder.setCompany(company);
        //那个仓库
        dborder.setStorehouse(new Storehouse(order.getStorehouseId()));

        long orderId = orderRpcServer.insert(dborder);
        dborder.setId(orderId);

        //保存订单项
        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(dborder);
            item.setTotalPrice(item.getUnitPrice() * item.getCount());
            orderItemRpcServer.insert(item);
        }

        redirectAttributes.addAttribute("orderId", orderId);
        return "redirect:/wallet/payment";
    }

}
