package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品模块 - 产品图片
 */
@Controller
@RequestMapping("/productImage")
public class ProductImageController extends BaseControllerImpl<ProductImage, ProductImageRpcServer> {
    @Autowired
    private ProductRpcServer productRpcServer;

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody ProductImage bean) throws Exception {
        ProductImage productImage = bean;
        bean = rpcService.select(bean, false);
        if (productImage.getUrl() != null) {
            bean.setUrl(productImage.getUrl());
        }
        if ((Integer)productImage.getType() != null) {
            bean.setType(productImage.getType());
        }
        if (productImage.getProduct() != null) {
            Product product = productRpcServer.select(new Product(productImage.getProduct().getId()), true);
            if (product == null) {
                return false;
            }
            bean.setProduct(product);
        }
        return rpcService.update(bean);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @param del_flag true 逻辑删除 false 物理删除
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new ProductImage(), !del_flag);
    }

}
