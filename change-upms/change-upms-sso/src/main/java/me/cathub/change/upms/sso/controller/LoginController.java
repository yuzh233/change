package me.cathub.change.upms.sso.controller;

import me.cathub.change.api.rpc.server.upms.UserRoleRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.common.bean.ResponseData;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.constant.SessionConstant;
import me.cathub.change.upms.bean.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * 登陆控制器
 *
 * @author cheng
 */
@Controller
public class LoginController {

    private UserSelectRpcServer userSelectRpcServer;
    private UserRoleRpcServer userRoleRpcServer;

    private String indexPage;
    private String loginPage;
    private String loginSuccessPage;

    @RequestMapping("/")
    public String index() throws Exception {
        return indexPage;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(User user, boolean rememberMe, String backUrl, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int code = 1;
        String data = loginSuccessPage;
        User dbUser = userSelectRpcServer.selectByName(user.getUsername(), user.getTableIndex(), true, User.TYPE_ADMIN);
        if  (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            List<UserRole> userRoles = userRoleRpcServer.listByUserId(dbUser.getId(), 0, Integer.MAX_VALUE, dbUser.getTableIndex(), false);
            String roles = userRoles.stream()
                    .map(bean -> bean.getRole().getName())
                    .collect(joining(","));

            HttpSession session = request.getSession(true);
            session.setAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO, dbUser.getUsername() + "," + User.TYPE_ADMIN);
            session.setAttribute(SessionConstant.CHANGE_LOCAL_USER_ROLES, roles);
        } else {
            code = 10101;
            data = "用户名或密码错误~";
        }

        ResponseData responseData = new ResponseData(code, data);
        return responseData;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);
        session.removeAttribute(SessionConstant.CHANGE_LOCAL_USER_ROLES);

        response.sendRedirect(loginPage);
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage;
    }

    public void setLoginSuccessPage(String loginSuccessPage) {
        this.loginSuccessPage = loginSuccessPage;
    }

    public void setUserSelectRpcServer(UserSelectRpcServer userSelectRpcServer) {
        this.userSelectRpcServer = userSelectRpcServer;
    }

    public void setUserRoleRpcServer(UserRoleRpcServer userRoleRpcServer) {
        this.userRoleRpcServer = userRoleRpcServer;
    }
}