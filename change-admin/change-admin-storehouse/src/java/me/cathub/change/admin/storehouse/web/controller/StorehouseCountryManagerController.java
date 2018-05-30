package me.cathub.change.admin.storehouse.web.controller;

import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 仓库模块 - 国家实体
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/storehouseCountry")
public class StorehouseCountryManagerController extends BaseAdminControllerImpl<StorehouseCountry, StorehouseCountryRpcServer> {

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new StorehouseCountry());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new StorehouseCountry(), !del_flag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception{
        if(id!=null) {
            StorehouseCountry storehouseCountry = rpcService.select(new StorehouseCountry(id), false);
            map.put("storehouseCountry", storehouseCountry);
        }
    }
}
