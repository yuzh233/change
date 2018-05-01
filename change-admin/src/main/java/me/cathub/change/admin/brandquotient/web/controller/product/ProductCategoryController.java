package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 产品模块 - 分类
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseControllerImpl<ProductCategory, ProductCategoryRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return true;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}
