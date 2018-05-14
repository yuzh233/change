package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 产品模块 - 评论
 */
@Controller
@RequestMapping("/productReview")
public class ProductReviewController extends BaseControllerImpl<ProductReview, ProductReviewRpcServer> {

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new ProductReview(), !del_flag);
    }

}
