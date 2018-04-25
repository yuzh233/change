package me.cathub.change.admin.web.controller.user;

import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.Auditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auditing")
public class AuditingController extends BaseControllerImpl<Auditing, AuditingRpcServer> {
}
