package me.cathub.change.admin.web.controller.user;

import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brandQuotient")
public class BrandQuotientController extends BaseControllerImpl<BrandQuotient, BrandQuotientRpcServer> {
}