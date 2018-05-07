package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.user.OnlineStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下的网店crud
 */
@Controller
@RequestMapping("/onlineStore")
public class OnlineStoreController extends BaseControllerImpl<OnlineStore, OnlineStoreRpcServer> {

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false)boolean del_flag) throws Exception {
       return rpcService.deletes(ids, new OnlineStore(), del_flag);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new OnlineStore());
    }

    @ModelAttribute
    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            OnlineStore onlineStore = new OnlineStore();
            onlineStore.setId(id);
            onlineStore = select(onlineStore);
            map.put("onlineStore", onlineStore);
        }
    }
}
