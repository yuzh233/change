package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 产品模块 - 产品操作
 *
 * @author zhang
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseControllerImpl<Product, ProductRpcServer> {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Product());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Product(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(Product product) throws Exception {
        //根据分类、品牌商的name查找对象并赋值
        if (product.getProductCategory() != null) {
            ProductCategory productCategory = productCategoryRpcServer.selectByName(product.getProductCategory().getName(), 0, true);
            if (productCategory == null) {
                return false;
            }
            product.setProductCategory(productCategory);
        }
        if (product.getBrandQuotient() != null) {
            BrandQuotient brandQuotient = brandQuotientRpcServer.selectByName(product.getBrandQuotient().getName(), 0, false);
            if (brandQuotient == null) {
                return false;
            }
            product.setBrandQuotient(brandQuotient);
            //获取企业
            product.setCompany(brandQuotient.getCompany());
        }
        return rpcService.insert(product) != -1;
    }


}
