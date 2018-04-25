package me.cathub.change.admin.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseControllerImpl<Permission, PermissionRpcServer> {

}