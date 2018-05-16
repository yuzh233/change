package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下 - 品牌商
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/brandQuotient")
public class BrandQuotientController extends BaseControllerImpl<BrandQuotient, BrandQuotientRpcServer> {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new BrandQuotient());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag)
            throws Exception {
        return rpcService.deletes(ids, new BrandQuotient(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        BrandQuotient bean = null;
        if (id != null) {
            bean = new BrandQuotient();
            bean.setId(id);
//            bean = count(bean);
            Company company = companyRpcServer.select(new Company(bean.getCompanyId()), true);
            bean.setCompany(company);
            map.put("brandQuotient", bean);
        }
    }

    @RequestMapping("/inserts")
    @ResponseBody
    @Override
    public boolean insert(BrandQuotient brandQuotient) throws Exception {
        if (brandQuotient.getCompany() != null) {
            //根据名称查找是否有该企业
            Company company = companyRpcServer.selectByName(brandQuotient.getCompany().getName(), 0, true);
            brandQuotient.setCompany(company);
        }

        // 品牌商的角色都是“用户-品牌商”
        brandQuotient.setRole(new Role(19874028009291776L));
        return rpcService.insert(brandQuotient) != -1;
    }
}