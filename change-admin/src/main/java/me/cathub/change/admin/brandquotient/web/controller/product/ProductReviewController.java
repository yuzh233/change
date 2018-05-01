package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 产品模块 - 评论
 */
@Controller
@RequestMapping("/productReview")
public class ProductReviewController extends BaseControllerImpl<ProductReview, ProductReviewRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return false;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}
