package me.cathub.change.admin.brandquotient.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseControllerImpl<Role, RoleRpcServer> {
}
