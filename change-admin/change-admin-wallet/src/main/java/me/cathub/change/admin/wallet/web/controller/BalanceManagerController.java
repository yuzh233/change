package me.cathub.change.admin.wallet.web.controller;

import me.cathub.change.api.rpc.server.wallet.BalanceRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.wallet.bean.Balance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: z.yu
 * @Date: 2018/05/28 22:17
 * @Description: 账户余额控制器
 */
@Controller
@RequestMapping("/balance")
public class BalanceManagerController extends BaseAdminControllerImpl<Balance,BalanceRpcServer> {

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @Override
    public int deletes(long[] ids, boolean delFlag) throws Exception {
        return 0;
    }
}
