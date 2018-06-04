package me.cathub.change.apply.home.controller;

import cn.hutool.json.JSONUtil;
import me.cathub.change.product.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 搜索页
 *  data:
 *      商品列表
 *  action:
 *      搜索商品
 */
@RequestMapping("/search")
@Controller
public class SearchPageController {

    /**
     * 搜索接口
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public ModelAndView index(Product product) throws Exception {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("product", JSONUtil.parse(product));

        return modelAndView;
    }

    /**
     * 真正的搜索
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/exec")
    @ResponseBody
    public List<Product> exec(Product product) throws Exception {
        return null;
    }
}
