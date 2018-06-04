package me.cathub.change.apply.product.controller;

import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 商品信息页
 *  data:
 *      商品相关信息
 *
 *  action:
 *      加入收藏
 *      加入进货单
 *      直接借卖
 */

@RequestMapping("/product")
@Controller
public class ProductPageController {

    /**
     * 获取商品首页 带参到页面
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public ModelAndView index(long productId) throws Exception {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("productId", productId);

        return modelAndView;
    }

    /**
     * 获取商品基本信息 (商品\属性\图片)
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping("/exec")
    @ResponseBody
    public Product exec(long productId) throws Exception {
        return null;
    }

    /**
     * 获取商品评论列表
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping("/productReviews")
    @ResponseBody
    public List<ProductReview> productReviews(long productId) throws Exception {
        return null;
    }
}