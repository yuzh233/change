package me.cathub.change.apply.shopkeeper.controller;

import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.AliPayRpcServer;
import me.cathub.change.api.rpc.server.wallet.BalanceRpcServer;
import me.cathub.change.apply.common.Messg;
import me.cathub.change.apply.common.OrderAndItems;
import me.cathub.change.apply.common.OrderItemP;
import me.cathub.change.apply.common.ProductPacking;
import me.cathub.change.apply.order.util.PaymentUtl;
import me.cathub.change.common.bean.PageResult;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import me.cathub.change.user.bean.OnlineStore;
import me.cathub.change.user.bean.Shopkeeper;
import me.cathub.change.wallet.bean.AliPay;
import me.cathub.change.wallet.bean.Balance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 用户Controller
 *
 * @Author: YouJie
 * @Date: 2018/5/11
 * @Time: 21:47
 */
@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperContorller {

    @Autowired
    BrandQuotientRpcServer brandQuotientRpcServer;
    @Autowired
    ShopkeeperRpcServer shopkeeperRpcServer;
    @Autowired
    UserSelectRpcServer userSelectRpcServer;
    @Autowired
    OnlineStoreRpcServer onlineStoreRpcServer;
    @Autowired
    OrderRpcServer orderRpcServer;
    @Autowired
    OrderItemRpcServer orderItemRpcServer;
    @Autowired
    ProductImageRpcServer productImageRpcServer;
    @Autowired
    ProductRpcServer productRpcServer;
    @Autowired
    BalanceRpcServer balanceRpcServer;
    @Autowired
    AliPayRpcServer aliPayRpcServer;

    /**
     * 用户中心
     */
    @RequestMapping({"/", ""})
    public String index() {
        return "user/Shopkeeper/center";
    }

    /**
     * 充值之后回调地址
     */
    @RequestMapping("/rechargeCallBack")
    public Object rechargeCallBack(HttpServletRequest request) throws Exception {
        if (PaymentUtl.check(request)) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //充值金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            //更新账户余额
            Shopkeeper shopkeeper = (Shopkeeper) request.getSession().getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
            Balance balance = balanceRpcServer.selectByUserId(shopkeeper.getId(), 0, true);
            balance.setBalance(balance.getBalance() + Float.parseFloat(total_amount));
            balanceRpcServer.update(balance);
        }
        //重定向到用户中心页，避免重复回调。
        return new ModelAndView("redirect:/shopkeeper");
    }

    /**
     * 网店申请
     */
    @RequestMapping("/onlineStorereg")
    @ResponseBody
    public Messg onlineStorereg(OnlineStore onlineStore, HttpSession session) throws Exception {
        Shopkeeper shopkeeper = (Shopkeeper) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        onlineStore.setShopkeeper(shopkeeper);
        onlineStore.setShopkeeperId(shopkeeper.getId());
        try {
            long onlineStoreId = onlineStoreRpcServer.insert(onlineStore);
        } catch (Exception e) {
            return new Messg(-1, "申请失败");
        }
        return new Messg(1, "申请成功");
    }

    /**
     * 获取网店
     */
    @RequestMapping("/onlineStore")
    @ResponseBody
    public List<OnlineStore> onlineStore(HttpSession session) throws Exception {
        User shopkeeper = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        return onlineStoreRpcServer.listByShopkeeperId(shopkeeper.getId(), 1, 100000, 0, true);
    }

    /**
     * 网店修改
     */
    @RequestMapping("/onlineStoreChange")
    @ResponseBody
    public Messg onlineStoreChange(OnlineStore onlineStore, HttpSession session) throws Exception {
        User shopkeeper = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        OnlineStore dbonlineStore = onlineStoreRpcServer.select(onlineStore, true);
        try {
            if (dbonlineStore != null && dbonlineStore.getShopkeeperId() == shopkeeper.getId()) {
                onlineStoreRpcServer.update(onlineStore);
            } else {
                return new Messg(-2, "你没有这个网店");
            }
        } catch (Exception e) {
            return new Messg(-1, "修改失败");
        }
        return new Messg(1, "修改成功");
    }

    /**
     * 网店删除
     */
    @RequestMapping("/onlineStoreDel")
    @ResponseBody
    public Messg onlineStoreDel(OnlineStore onlineStore, HttpSession session) throws Exception {
        User shopkeeper = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        OnlineStore dbonlineStore = onlineStoreRpcServer.select(onlineStore, true);
        try {
            if (dbonlineStore != null && dbonlineStore.getShopkeeperId() == shopkeeper.getId()) {
//                应该还有判断网店是否有推送商品


//                应该还有判断网店是否有推送商品
                onlineStoreRpcServer.deleteL(onlineStore);
            } else {
                return new Messg(-1, "你没有这个网店");
            }
        } catch (Exception e) {
            return new Messg(-2, "删除失败");
        }
        return new Messg(1, "删除成功");
    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public HashMap userInfo(HttpSession session) throws Exception {
        HashMap userInfo = new HashMap();
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        // 用户基本信息
        userInfo.put("user", loginUser);
        //订单数
        long orderCount = orderRpcServer.countByShopkeeperId(loginUser.getId(), 0);
        userInfo.put("orderCount", orderCount);
        // 网店数
        int onCount = onlineStoreRpcServer.countByShopkeeperId(loginUser.getId(), 0);
        userInfo.put("onCount", onCount);
        // 余额
        Balance balance = balanceRpcServer.selectByUserId(loginUser.getId(), 0, true);
//        Balance balance = new Balance();
//        balance.setBalance(9999F);
        userInfo.put("balance", balance);
        // 绑定支付宝帐号
        AliPay aliPay = aliPayRpcServer.selectByUserId(loginUser.getId(), 0, true);
//        AliPay aliPay = new AliPay();
//        aliPay.setAccount("youjie2015@126.com");
//        aliPay.setRealName("youjie");
        userInfo.put("aliPay", aliPay);
        return userInfo;
    }

    /**
     * 修改用户信息
     * 只能修改电话，邮箱，密码
     */
    @RequestMapping("/userUpdate")
    @ResponseBody
    public Messg userUpdate(User user, String newPwd, HttpSession session) throws Exception {
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        Shopkeeper dbUser = shopkeeperRpcServer.select(new Shopkeeper(loginUser.getId()), false);
        if (user.getPassword() != null && !user.getPassword().trim().equals("")) { //密码不为空，代表要修改密码
            if (!dbUser.getPassword().equals(user.getPassword())) {   //旧密码错误
                return new Messg(-1, "旧密码不正确");
            }
            dbUser.setPassword(newPwd);
        }
        if (!dbUser.getEmail().equals(user.getPhone()))
            dbUser.setPhone(user.getPhone());
        if (!dbUser.getPhone().equals(user.getPhone()))
            dbUser.setEmail(user.getEmail());

        shopkeeperRpcServer.update(dbUser);
        return new Messg(1, "修改成功");
    }

    /**
     * 订单列表查看
     */
    @RequestMapping("/orderList")
    @ResponseBody
    public PageResult orderList(@RequestParam(defaultValue = "0") String status, String oid, String companyName, String date, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, HttpSession session) throws Exception {
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);

        List<OrderAndItems> orderAndItems = new ArrayList<>();
        //获取订单
        List<Order> orders = orderRpcServer.listByShopkeeperId(loginUser.getId(), 1, 9999999, 0, true);

        OrderAndItems tempOrder = null;
        OrderItemP orderItemP = null;
        Product pd = new Product();

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (status.equals("0")) { // 所有订单

            } else if (status.equals("1")) { // 待付款
                // 判断当前订单的状态，如果和status相同这添加，不相同这跳过这次添加
                if (!order.getOrderCode().equals(status))
                    continue;
            } else if (status.equals("2")) { // 已评价
                if (!order.getOrderCode().equals(status))
                    continue;
            } else if (status.equals("3")) { // 待评价
                if (!order.getOrderCode().equals(status))
                    continue;
            } else if (status.equals("4") || status.equals("5")) { // 4退货中  5退款
                if (!order.getOrderCode().equals(status) || !order.getOrderCode().equals(status))
                    continue;
            } else if (status.equals("6")) { // 已取消
                if (!order.getOrderCode().equals(status))
                    continue;
            }
            // 将订单属性拷到包装订单类上
            tempOrder = new OrderAndItems();
            BeanUtils.copyProperties(order, tempOrder);
            // 添加到订单list里
            orderAndItems.add(tempOrder);


            List<OrderItem> orderItems = orderItemRpcServer.listByOrderId(order.getId(), 1, 10000, 0, true);
            for (OrderItem orderItem : orderItems) {
                // 将订单项属性拷到包装订单项类上
                orderItemP = new OrderItemP();
                BeanUtils.copyProperties(orderItem, orderItemP);
                // 将订单项添加到订单中
                tempOrder.getOrderItemsP().add(orderItemP);

                // 将查询的商品添加到包装商品中
                pd.setId(orderItem.getProductId());
                Product dbProdcut = productRpcServer.select(pd, false);
                ProductPacking productPacking = new ProductPacking();
                BeanUtils.copyProperties(dbProdcut, productPacking);
                orderItemP.setProductPacking(productPacking);

                ProductImage productImage = productImageRpcServer.listByProductIdAndImageType(orderItemP.getProductId(), 0, 1, 1, 0, false).get(0);
                productPacking.setImg(productImage);
            }
        }
        int toIndex = (page - 1) * pageSize + pageSize > orderAndItems.size() ? orderAndItems.size() : (page - 1) * pageSize + pageSize;
        List<OrderAndItems> resultOrder = orderAndItems.subList((page - 1) * pageSize, toIndex);
        PageResult pageResult = new PageResult(resultOrder, orderAndItems.size());
        return pageResult;
    }


}
