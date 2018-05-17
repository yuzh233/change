package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.*;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.user.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块 - 入驻审核
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/auditing")
public class AuditingController extends BaseControllerImpl<Auditing, AuditingRpcServer> {

    @Autowired
    private AuditingRpcServer auditingRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private AdminRpcServer adminRpcServer;

    @ModelAttribute
    @Override
    public void updateModelAttribute(Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Auditing auditing = new Auditing();
            auditing.setId(id);
            auditing = auditingRpcServer.select(auditing,true);
            //关联品牌商/借卖方实体对象
            User user = null;
            //品牌商
            if(auditing.getType() == Auditing.TYPE_BRAND_QUOTIENT){
                user = brandQuotientRpcServer.select(new BrandQuotient(auditing.getUserId()),true);
            }else if(auditing.getType() == Auditing.TYPE_SHOPKEEPER){
                user = shopkeeperRpcServer.select(new Shopkeeper(auditing.getUserId()),true);
            }
            auditing.setUser(user);
            // 关联经手人实体对象（当前用户）
            // 模拟数据
            auditing.setAdmin(adminRpcServer.select(new Admin(20152507774799872L),true));
            map.put("auditing", auditing);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag) throws Exception {
        return rpcService.deletes(ids, new Auditing(), !delFlag);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Auditing());
    }
}
