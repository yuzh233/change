package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块 - B2C店主
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController extends BaseControllerImpl<Shopkeeper, ShopkeeperRpcServer> {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Shopkeeper());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag)
            throws Exception {
        return rpcService.deletes(ids, new Shopkeeper(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Shopkeeper shopkeeper = new Shopkeeper();
            shopkeeper.setId(id);
            shopkeeper = select(shopkeeper);
            //关联角色对象
            shopkeeper.setRole(roleRpcServer.select(new Role(shopkeeper.getRoleId()),true));
            map.put("shopkeeper", shopkeeper);
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(Shopkeeper bean) throws Exception {
        // 店主的角色都是“借卖方”
        bean.setRole(new Role(19874064625565696L));
        return rpcService.insert(bean) != -1;
    }

}
