package me.cathub.change.admin.storehouse.web.controller;


import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 仓库模块 - 仓库实体
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/storehouse")
public class StorehouseAdminController extends BaseAdminControllerImpl<Storehouse, StorehouseRpcServer> {

    @Autowired
    private StorehouseCountryRpcServer storehouseCountryRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Storehouse());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Storehouse(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(Storehouse storehouse) throws Exception {
        if(storehouse.getStorehouseCountry()!=null){
            StorehouseCountry storehouseCountry = storehouseCountryRpcServer.selectByName(storehouse.getStorehouseCountry().getName(), 0, true);
            storehouse.setStorehouseCountry(storehouseCountry);
        }
        return rpcService.insert(storehouse) != -1;
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception{
        if(id!=null) {
            Storehouse storehouse = rpcService.select(new Storehouse(id), false);
            map.put("storehouse", storehouse);
        }
    }

}

