package me.cathub.change.admin.wallet.web.controller;

import me.cathub.change.api.rpc.server.wallet.AliPayRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: z.yu
 * @Date: 2018/05/28 22:19
 * @Description:  绑定支付宝
 */
@Controller
@RequestMapping("/aliPay")
public class AliPayManagerController extends BaseAdminControllerImpl<me.cathub.change.wallet.bean.AliPay,AliPayRpcServer>{

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @Override
    public int deletes(long[] ids, boolean delFlag) throws Exception {
        return 0;
    }
}
