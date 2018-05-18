package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.user.bean.OnlineStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块 - 网店
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/onlineStore")
public class OnlineStoreAdminController extends BaseAdminControllerImpl<OnlineStore, OnlineStoreRpcServer> {

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new OnlineStore());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false)boolean delFlag) throws Exception {
        return rpcService.deletes(ids, new OnlineStore(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            OnlineStore onlineStore = new OnlineStore();
            onlineStore.setId(id);
            onlineStore = select(onlineStore);
            map.put("onlineStore", onlineStore);
        }
    }
}
