package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块 - 企业
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/company")
public class CompanyAdminController extends BaseAdminControllerImpl<Company, CompanyRpcServer> {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Company());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag)
            throws Exception {
        return rpcService.deletes(ids, new Company(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Company bean = new Company();
            bean.setId(id);
            bean = select(bean);
            map.put("company", bean);
        }
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Company selectByName(@RequestParam("name") String name, @RequestParam(value = "indexTable", required = false) int tableIndex,
                                @RequestParam(value = "flag", required = false) boolean flag) throws Exception {
        System.out.println("service -> " + companyRpcServer);

        //flag : 是否填充企业和角色信息
        Company bean = companyRpcServer.selectByName(name, tableIndex, false);
        System.out.println("selectByName:" + bean);
        if (bean == null) {
            return null;
        }
        return bean;
    }
}
