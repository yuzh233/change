package me.cathub.change.admin.product.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
}