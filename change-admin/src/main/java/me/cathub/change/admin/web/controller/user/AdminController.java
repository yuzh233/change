package me.cathub.change.admin.web.controller.user;

import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseControllerImpl<Admin, AdminRpcServer> {
}
