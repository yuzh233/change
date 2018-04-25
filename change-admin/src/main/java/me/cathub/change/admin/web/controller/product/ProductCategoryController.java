package me.cathub.change.admin.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseControllerImpl<ProductCategory, ProductCategoryRpcServer> {
}
