package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 产品模块 - 分类
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseControllerImpl<ProductCategory, ProductCategoryRpcServer> {

    @ModelAttribute
    @Override
    public void update_modelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            ProductCategory bean = new ProductCategory();
            bean.setId(id);
            bean = select(bean);
            map.put("productCategory", bean);
        }
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new ProductCategory(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(ProductCategory productCategory) throws Exception {
        //根据父级分类的名字获得父级分类
        if (productCategory.getParent() != null) {
            ProductCategory parent = rpcService.selectByName(productCategory.getParent().getName(), 0, true);
            productCategory.setParent(parent);
        }
        return rpcService.insert(productCategory) != -1;
    }

}
