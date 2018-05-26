package me.cathub.change.apply.web.controller.temp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户进货单页
 *  data:
 *      预订商品列表
 *
 * # 先搁着 要加表
 */

@RequestMapping("/collect")
@Controller
public class UserCollectController {

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index(long userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView("collect");
        modelAndView.addObject("userId", userId);

        return modelAndView;
    }
}