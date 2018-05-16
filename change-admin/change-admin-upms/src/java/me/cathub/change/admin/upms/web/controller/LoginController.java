package me.cathub.change.admin.upms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/")
    public String index(HttpServletResponse response) throws Exception {
//        response.sendRedirect("http://www.baidu.com");
        return  "index";
    }
}
