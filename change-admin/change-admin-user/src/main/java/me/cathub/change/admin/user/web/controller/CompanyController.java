package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.user.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下的企业crud
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseControllerImpl<Company, CompanyRpcServer> {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]")long[] ids, @RequestParam(value = "del_flag",required = false)boolean del_flag)
            throws Exception {
        return rpcService.deletes(ids, new Company(), !del_flag);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @ModelAttribute
    @Override
    public void update_modelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception {
        if(id!=null) {
            Company bean = new Company();
            bean.setId(id);
            bean = select(bean);
            map.put("company", bean);
        }
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Company selectByName(@RequestParam("name")String name, @RequestParam(value = "indexTable", required = false)int tableIndex,
                                      @RequestParam(value = "flag", required = false) boolean flag) throws Exception {
        System.out.println("service -> "+companyRpcServer);
        Company bean = companyRpcServer.selectByName(name, tableIndex, false);//flag : 是否填充企业和角色信息
        System.out.println("selectByName:"+bean);
        if(bean==null){
            return null;
        }
        return bean;
    }
}
