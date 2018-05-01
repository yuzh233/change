package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 产品模块 - 产品图片
 */
@Controller
@RequestMapping("/productImage")
public class ProductImageController extends BaseControllerImpl<ProductImage, ProductImageRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return true;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }

}
