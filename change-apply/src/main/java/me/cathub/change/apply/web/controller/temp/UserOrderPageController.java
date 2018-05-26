package me.cathub.change.apply.web.controller.temp;

import me.cathub.change.order.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单页
 *  data:
 *      订单列表
 */

@RequestMapping("/order")
@Controller
public class UserOrderPageController {

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index(long userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("userId", userId);

        return modelAndView;
    }

    @RequestMapping("/exec")
    @ResponseBody
    public List<Order> exec(long userId) throws Exception {
        return null;
    }
}