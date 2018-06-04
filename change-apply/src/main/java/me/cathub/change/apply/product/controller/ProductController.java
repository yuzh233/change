package me.cathub.change.apply.product.controller;

import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.bean.PageResult;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import me.cathub.change.product.bean.ProductReview;
import me.cathub.change.product.bean.PropertyKeyValue;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * OSS:https://change-data.oss-cn-shenzhen.aliyuncs.com/
 *
 * 商品控制器
 *
 * @Author: YouJie
 * @Date: 2018/5/14
 * @Time: 11:50
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRpcServer productRpcServer;
    @Autowired
    ProductImageRpcServer productImageRpcServer;
    @Autowired
    PropertyValueRpcServer propertyValueRpcServer;
    @Autowired
    ProductReviewRpcServer productReviewRpcServer;

    @Autowired
    StorehouseProductStockRpcServer sorehouseProductStockRpcServer;
    @Autowired
    StorehouseCountryRpcServer storehouseCountryRpcServer;
    @Autowired
    StorehouseRpcServer storehouseRpcServer;

    @Autowired
    BrandQuotientRpcServer brandQuotientRpcServer;
    @Autowired
    CompanyRpcServer companyRpcServer;

    @Autowired
    ShopkeeperRpcServer shopkeeperRpcServer;

    /**
     * 商品详细页面
     * @return
     */
    @RequestMapping("/{storehouse}/{id}")
    public String detailView(@ModelAttribute @PathVariable  Long id,@ModelAttribute @PathVariable  Long storehouse) throws Exception{
        return "/product/detail";
    }

    /**
     * 根据id查看商品详细
     */
    @RequestMapping("/data/{storehouseId}/{id}")
    @ResponseBody
    public HashMap detail(@PathVariable  Long id,@PathVariable  Long storehouseId) throws Exception{

        HashMap<String,Object> data = new HashMap<>();
        Product product = new Product();
        product.setId(id);
        //封面
//        ProductImage productCover = productImageRpcServer.selectByProductIdCover(product.getId(), 0, false);
        //图片
        List<ProductImage> productImages = productImageRpcServer.listByProductIdAndImageType(product.getId(), 0, 1, 100, 0, false);
        // 商品属性
        List<PropertyKeyValue> propertyKeyValues = propertyValueRpcServer.keyValueList(product.getId(), 0);
        // 商品信息
        Product selectProduct = productRpcServer.select(product, true);
        //评论数量
        Integer reviewCount = productReviewRpcServer.countByProductId(selectProduct.getId(), 0);

        //商品库存
        StorehouseProductStock storehouseProductStock = sorehouseProductStockRpcServer.selectByStorehouseIdAndProductId(storehouseId, product.getId(), 0, true);
        //那个仓库
        Storehouse storehouse = storehouseRpcServer.select(new Storehouse(storehouseProductStock.getStorehouseId()), true);
        //仓库国家
        StorehouseCountry country = storehouseCountryRpcServer.select(new StorehouseCountry(storehouse.getStorehouseCountryId()), true);

        // 所属企业
        Company company = companyRpcServer.select(new Company(selectProduct.getCompanyId()), true);
        // 品牌商
        BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(21735953194287104L), true);

        data.put("productCover",productImages.get(0));
        data.put("productImages",productImages);
        data.put("propertyKeyValues",propertyKeyValues);
        data.put("selectProduct",selectProduct);
        data.put("storehouseProductStock",storehouseProductStock);
        data.put("storehouse",storehouse);
        data.put("country",country);
        data.put("reviewCount",reviewCount);
        data.put("brandQuotient",brandQuotient);
        data.put("company",company);
        return data;
    }

    /**
     * 获取评论
     */
    @RequestMapping("/review/{pid}/{page}/{sizePage}")
    @ResponseBody
    public PageResult productreview(@PathVariable Long pid, @PathVariable Integer page, @PathVariable Integer sizePage) throws Exception{
        List<ProductReview> productReviews = productReviewRpcServer.listByProductId(pid, page, sizePage, 0, false);
        for(ProductReview pr : productReviews) {
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(pr.getShopkeeperId()), true);
            if(shopkeeper!=null)
                shopkeeper.setPassword(null);
            pr.setShopkeeper(shopkeeper);
        }
        PageResult pageResult =new PageResult(productReviews,productReviewRpcServer.countByProductId(pid,0));
        return pageResult;
    }
}
