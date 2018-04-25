package me.cathub.change.admin.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productReview")
public class ProductReviewController extends BaseControllerImpl<ProductReview, ProductReviewRpcServer> {
}
