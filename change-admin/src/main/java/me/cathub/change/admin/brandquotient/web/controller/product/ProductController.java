package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 产品模块 - 产品操作
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseControllerImpl<Product, ProductRpcServer> {
}
