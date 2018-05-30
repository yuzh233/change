package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.upms.bean.Apply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: z.yu
 * @Date: 2018/05/19 22:55
 * @Description: 应用权限控制器
 */
@Controller
@RequestMapping("/apply")
public class ApplyManagerController extends BaseAdminControllerImpl<Apply, ApplyRpcServer> {

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag) throws Exception {
        return rpcService.deletes(ids, new Apply(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Apply apply = rpcService.select(new Apply(id), false);
            map.put("apply", apply);
        }
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }
}
