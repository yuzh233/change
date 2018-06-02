package me.cathub.change.apply.web.controller;

import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.AliPayRpcServer;
import me.cathub.change.api.rpc.server.wallet.BalanceRpcServer;
import me.cathub.change.apply.common.Messg;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.user.bean.OnlineStore;
import me.cathub.change.user.bean.Shopkeeper;
import me.cathub.change.wallet.bean.AliPay;
import me.cathub.change.wallet.bean.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 用户Controller
 *
 * @Author: cchangee
 * @Date: 2018/5/11
 * @Time: 21:47
 * </p>
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

//    @Autowired
//    BalanceRpcServer balanceRpcServer;
//    @Autowired
//    AliPayRpcServer aliPayRpcServer;

    /**
     * 用户中心
     */
    @RequestMapping({"/",""})
    public String index() {
        return "user/Shopkeeper/center";
    }

    /**
     * 网店申请
     */
    @RequestMapping("/onlineStorereg")
    @ResponseBody
    public Messg onlineStorereg(OnlineStore onlineStore, HttpSession session) throws Exception{
        Shopkeeper shopkeeper = (Shopkeeper)session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        onlineStore.setShopkeeper(shopkeeper);
        onlineStore.setShopkeeperId(shopkeeper.getId());
        try{
            long onlineStoreId = onlineStoreRpcServer.insert(onlineStore);
        }
        catch (Exception  e){
            return new Messg(-1,"申请失败");
        }
        return new Messg(1,"申请成功");
    }

    /**
     * 获取网店
     */
    @RequestMapping("/onlineStore")
    @ResponseBody
    public List<OnlineStore> onlineStore(HttpSession session) throws Exception{
        User shopkeeper = (User)session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        return onlineStoreRpcServer.listByShopkeeperId(shopkeeper.getId(),1,100000,0,true);
    }

    /**
     * 网店修改
     */
    @RequestMapping("/onlineStoreChange")
    @ResponseBody
    public Messg onlineStoreChange(OnlineStore onlineStore,HttpSession session) throws Exception{
        User shopkeeper = (User)session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        OnlineStore dbonlineStore = onlineStoreRpcServer.select(onlineStore, true);
        try {
            if (dbonlineStore!=null && dbonlineStore.getShopkeeperId() == shopkeeper.getId()) {
                onlineStoreRpcServer.update(onlineStore);
            }else {
                return new Messg(-2,"你没有这个网店");
            }
        }catch (Exception e){
            return new Messg(-1,"修改失败");
        }
        return new Messg(1,"修改成功");
    }

    /**
     * 网店删除
     */
    @RequestMapping("/onlineStoreDel")
    @ResponseBody
    public Messg onlineStoreDel(OnlineStore onlineStore,HttpSession session) throws Exception{
        User shopkeeper = (User)session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        OnlineStore dbonlineStore = onlineStoreRpcServer.select(onlineStore, true);
        try {
            if (dbonlineStore!=null && dbonlineStore.getShopkeeperId() == shopkeeper.getId()) {
//                应该还有判断网店是否有推送商品


//                应该还有判断网店是否有推送商品
                onlineStoreRpcServer.deleteL(onlineStore);
            }else {
                return new Messg(-1,"你没有这个网店");
            }
        }catch (Exception e){
            return new Messg(-2,"删除失败");
        }
        return new Messg(1,"删除成功");
    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public HashMap userInfo(HttpSession session) throws Exception{
        HashMap userInfo = new HashMap();
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        // 用户基本信息
        userInfo.put("user",loginUser);
        //订单数
        long orderCount = orderRpcServer.countByShopkeeperId(loginUser.getId(), 0);
        userInfo.put("orderCount",orderCount);
        // 网店数
        int onCount = onlineStoreRpcServer.countByShopkeeperId(loginUser.getId(), 0);
        userInfo.put("onCount",onCount);
//        // 余额
//        Balance balance = balanceRpcServer.selectByUserId(loginUser.getId(), 0, true);
//        userInfo.put("balance",balance);
//        // 绑定支付宝帐号
//        AliPay aliPay = aliPayRpcServer.selectByUserId(loginUser.getId(), 0, true);
//        userInfo.put("balance",balance);
        return userInfo;
    }

    /**
     * 修改用户信息
     * 只能修改电话，邮箱，密码
     */
    @RequestMapping("/userUpdate")
    @ResponseBody
    public Messg userUpdate(User user,String newPwd,HttpSession session) throws Exception{
        User loginUser = (User) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        Shopkeeper dbUser = shopkeeperRpcServer.select(new Shopkeeper(loginUser.getId()), false);
        if(user.getPassword()!=null && !user.getPassword().trim().equals("")) { //密码不为空，代表要修改密码
            if(!dbUser.getPassword().equals(user.getPassword())){   //旧密码错误
                return new Messg(-1,"旧密码不正确");
            }
            dbUser.setPassword(newPwd);
        }
        if(!dbUser.getEmail().equals(user.getPhone()))
            dbUser.setPhone(user.getPhone());
        if(!dbUser.getPhone().equals(user.getPhone()))
            dbUser.setEmail(user.getEmail());

        shopkeeperRpcServer.update(dbUser);
        return new Messg(1,"修改成功");
    }

}
