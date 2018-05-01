package me.cathub.change.admin.brandquotient.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 权限模块 - 权限操作
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseControllerImpl<Permission, PermissionRpcServer> {

    @Override
    public boolean delete(long[] ids) throws Exception {

        return false;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}