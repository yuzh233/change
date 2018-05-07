package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.upms.Role;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下的品牌商crud
 */
@Controller
@RequestMapping("/brandQuotient")
public class BrandQuotientController extends BaseControllerImpl<BrandQuotient, BrandQuotientRpcServer> {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag)
            throws Exception {
        for (long id : ids) {
            BrandQuotient bean = new BrandQuotient();
            bean.setId(id);
            bean = rpcService.select(bean, true);
            rpcService.deleteL(bean);//逻辑删除
        }
        return 0;
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @ModelAttribute
    @Override
    public void update_modelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            BrandQuotient bean = new BrandQuotient();
            bean.setId(id);
            bean = select(bean);
            Company company = companyRpcServer.select(new Company(bean.getCompany_id()), true);
            bean.setCompany(company);
            map.put("brandQuotient", bean);
        }
    }

    @RequestMapping("/inserts")
    @ResponseBody
    public boolean insert(BrandQuotient brandQuotient) throws Exception {
        if (brandQuotient.getCompany() != null) {
            //根据名称查找是否有该企业
            Company company = companyRpcServer.selectByName(brandQuotient.getCompany().getName(), 0, true);
            brandQuotient.setCompany(company);
        }
        brandQuotient.setRole(new Role(19874028009291776l));//品牌商的角色都是“用户-品牌商”
        return rpcService.insert(brandQuotient) != -1;
    }
}