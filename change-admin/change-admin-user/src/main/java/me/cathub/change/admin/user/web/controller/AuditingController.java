package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.user.Auditing;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Shopkeeper;
import me.cathub.change.common.bean.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下的审核crud
 */
@Controller
@RequestMapping("/auditing")
public class AuditingController extends BaseControllerImpl<Auditing, AuditingRpcServer> {

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;
    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @ModelAttribute
    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Auditing auditing = new Auditing();
            auditing.setId(id);
            auditing = select(auditing);
            //关联品牌商/借卖方实体对象
            User user = null;
            if(auditing.getType() == 1){ //品牌商
                user = brandQuotientRpcServer.select(new BrandQuotient(auditing.getUser_id()),true);
            }else if(auditing.getType() == 0){ //借卖方
                user = shopkeeperRpcServer.select(new Shopkeeper(auditing.getUser_id()),true);
            }
            auditing.setUser(user);
            // 关联经手人实体对象（当前用户）

            map.put("shopkeeper", auditing);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Auditing(), del_flag);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Auditing());
    }
}
