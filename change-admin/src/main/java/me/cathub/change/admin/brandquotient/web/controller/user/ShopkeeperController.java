package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 用户模块下的店主crud
 */
@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController extends BaseControllerImpl<Shopkeeper, ShopkeeperRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return false;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}
