package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.OnlineStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 用户模块下的网店crud
 */
@Controller
@RequestMapping("/onlineStore")
public class OnlineStoreController extends BaseControllerImpl<OnlineStore, OnlineStoreRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return false;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}
