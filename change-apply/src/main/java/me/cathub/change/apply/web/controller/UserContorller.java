package me.cathub.change.apply.web.controller;

import me.cathub.change.api.rpc.server.upms.UserRoleRpcServer;
import me.cathub.change.api.rpc.server.user.*;
import me.cathub.change.apply.common.Messg;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.UserRole;
import me.cathub.change.user.bean.*;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    AuditingRpcServer aditingRpcServer;

    @Autowired
    UserRoleRpcServer userRoleRpcServer ;

    @Autowired
    CompanyRpcServer companyRpcServer;
    @Autowired
    UserSelectRpcServer userSelectRpcServer;

    /**
     * 页面跳转
     */
    // 登录页面跳转
    @RequestMapping("/loginview")
    public String loginview(Admin admin) {
        return "/user/login";
    }
    //注册
    @RequestMapping("/regview")
    public String regview(){
        return "/user/reg";
    }

    /**
     *  登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public User login(User user, HttpSession session) throws Exception{
        User loginUser = userSelectRpcServer.selectByName(user.getUsername(), 0, true, User.TYPE_SHOPKEEPER);
        loginUser.setPassword(null);
        session.setAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO,loginUser);
        return loginUser;
    }

    /**
     * 注册
     * @param brandQuotient 品牌商
     * @param shopkeeper    卖家
     * @param type          判断注册类型 0--品牌商   1--卖家
     * @return              是否注册成功
     * @throws Exception
     */
    @RequestMapping("/reg")
    @ResponseBody
    public Messg reg(BrandQuotient brandQuotient, Shopkeeper shopkeeper, Integer type) throws Exception{

        Auditing auditing = new Auditing();
        auditing.setStatus(Auditing.STATUS_IN_THE_AUDIT);
        //       判断注册类型 0--品牌商   1--卖家
        if(type==0){
            //用户名是否已经注册
            BrandQuotient dbbrandQuotient = brandQuotientRpcServer.selectByName(brandQuotient.getUsername(), 0, false);
            if(dbbrandQuotient!=null){
                return new Messg(-1,"用户名被使用");
            }
            //审核用户-品牌商
            long compId = companyRpcServer.insert(brandQuotient.getCompany());
            brandQuotient.getCompany().setId(compId);
            long userid = brandQuotientRpcServer.insert(brandQuotient);

            auditing.setType(Auditing.TYPE_BRAND_QUOTIENT);
            brandQuotient.setId(userid);
            auditing.setUser(brandQuotient);
            aditingRpcServer.insert(auditing);
            //分配角色
            UserRole userRole = new UserRole();
            userRole.setUser(brandQuotient);
            userRole.setRole(new Role(30317302238941184L));
            userRoleRpcServer.insert(userRole);
            return new Messg(1,"注册成功");
        }else{
            //用户名是否已经注册
            Shopkeeper dbshopkeeper = shopkeeperRpcServer.selectByName(shopkeeper.getUsername(),0,false);
            if(dbshopkeeper!=null){
                return new Messg(-1,"用户名被使用");
            }
            //审核用户-借卖方
            long userid = shopkeeperRpcServer.insert(shopkeeper);

            auditing.setType(Auditing.TYPE_SHOPKEEPER);
            shopkeeper.setId(userid);
            auditing.setUser(shopkeeper);
            aditingRpcServer.insert(auditing);

            //分配角色
            UserRole userRole = new UserRole();
            userRole.setUser(shopkeeper);
            userRole.setRole(new Role(30317369100341248L));
            userRoleRpcServer.insert(userRole);
            return new Messg(1,"注册成功");
        }
    }

}
