package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品模块 - 产品操作
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


    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Product product) throws Exception {
        Product p1 = product; //暂存表单数据
        product = rpcService.select(product, false); //关联查询
        if (p1.getName() != null) {
            product.setName(p1.getName());
        }
        if (p1.getSubTitle() != null) {
            product.setSubTitle(p1.getSubTitle());
        }
        if (p1.getPrice() != 0) {
            product.setPrice(p1.getPrice());
        }
        if (p1.getDescription() != null) {
            product.setDescription(p1.getDescription());
        }
        if (p1.getStatus() != 0) {
            product.setStatus(p1.getStatus());
        }
        if (p1.getProductCategory() != null) {
            ProductCategory pc = productCategoryRpcServer.selectByName(p1.getProductCategory().getName(), 0, true);
            product.setProductCategory(pc);
        }
        return rpcService.update(product);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Product(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
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
