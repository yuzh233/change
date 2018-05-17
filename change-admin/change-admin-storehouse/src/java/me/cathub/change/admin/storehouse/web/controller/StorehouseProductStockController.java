package me.cathub.change.admin.storehouse.web.controller;

import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 仓库模块 - 产品实体
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/storehouseProductStock")
public class StorehouseProductStockController extends BaseControllerImpl<StorehouseProductStock, StorehouseProductStockRpcServer> {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new StorehouseProductStock(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(StorehouseProductStock bean) throws Exception {
        //关联产品、仓库信息
        if (bean.getProduct() != null) {
            Product product = productRpcServer.select(new Product(bean.getProduct().getId()), false);
            if (product == null) {
                return false;
            }
            bean.setProduct(product);
            if ((Long) product.getCompanyId() != null) {
                bean.setCompany(companyRpcServer.select(new Company(product.getCompanyId()),true));
            }
            bean.setProductCategory(product.getProductCategory());
        }
        if (bean.getStorehouse() != null) {
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouse().getId()), true);
            if (storehouse == null) {
                return false;
            }
            bean.setStorehouse(storehouse);
        }
        return rpcService.insert(bean) != -1;
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception{
        if(id!=null) {
            StorehouseProductStock storehouseProductStock = rpcService.select(new StorehouseProductStock(id), false);
            map.put("storehouseCountry", storehouseProductStock);
        }
    }

}
