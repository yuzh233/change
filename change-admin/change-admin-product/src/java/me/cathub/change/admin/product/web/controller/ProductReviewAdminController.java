package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 产品模块 - 评论
 *
 * @author zhang
 */
@Controller
@RequestMapping("/productReview")
public class ProductReviewAdminController extends BaseAdminControllerImpl<ProductReview, ProductReviewRpcServer> {

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new ProductReview());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new ProductReview(), !del_flag);
    }

}
