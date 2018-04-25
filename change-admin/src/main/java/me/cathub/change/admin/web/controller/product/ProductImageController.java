package me.cathub.change.admin.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productImage")
public class ProductImageController extends BaseControllerImpl<ProductImage, ProductImageRpcServer> {
}
