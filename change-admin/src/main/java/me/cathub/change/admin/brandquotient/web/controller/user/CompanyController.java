package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户模块下的企业crud
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseControllerImpl<Company, CompanyRpcServer> {
}
