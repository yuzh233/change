package me.cathub.change.apply.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * No blood ! No bone！ No ash！
 *
 * @Author: cchangee
 * @Date: 2018/5/12
 * @Time: 16:35
 * </p>
 */
@Controller
public class CmsController {

    @RequestMapping({"/","/index.html"})
    public String index() {
        return  "index";
    }
}
