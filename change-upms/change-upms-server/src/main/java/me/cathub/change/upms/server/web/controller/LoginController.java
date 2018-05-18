package me.cathub.change.upms.server.web.controller;

import me.cathub.change.common.bean.ResponseData;
import me.cathub.change.common.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping("/noLogin")
    public String noLogin() throws Exception {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(User user, boolean rememberMe, String back_url) throws Exception {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(rememberMe);

        Subject subject = SecurityUtils.getSubject();

        int code = 1;
        String data = "http://localhost:9991/";
        try {
            subject.login(token);
        }catch(UnknownAccountException e){
            code = 10101;
            data = "用户名不存在";
        }catch(IncorrectCredentialsException e){
            code = 10102;
            data = "密码错误";
        }catch(LockedAccountException e){
            code = 10103;
            data = "账户以冻结";
        }catch(ExcessiveAttemptsException e){
            code = 10104;
            data = "用户名或密码错误次数过多, 请稍后再试";
        }catch(AuthenticationException e){
        }

        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setData(data);

        return responseData;
    }

    @RequestMapping("/logout")
    public String logout() throws Exception {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
