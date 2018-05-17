package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品模块 - 产品图片
 *
 * @author zhang
 */
@Controller
@RequestMapping("/productImage")
public class ProductImageController extends BaseControllerImpl<ProductImage, ProductImageRpcServer> {

    @Autowired
    private ProductRpcServer productRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new ProductImage());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new ProductImage(), !del_flag);
    }

}
