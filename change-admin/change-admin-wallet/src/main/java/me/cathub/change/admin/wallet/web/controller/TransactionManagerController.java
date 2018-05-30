package me.cathub.change.admin.wallet.web.controller;

import me.cathub.change.api.rpc.server.wallet.TransactionRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.wallet.bean.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: z.yu
 * @Date: 2018/05/28 22:18
 * @Description: 交易记录
 */
@Controller
@RequestMapping("/transaction")
public class TransactionManagerController extends BaseAdminControllerImpl<Transaction,TransactionRpcServer>{

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @Override
    public int deletes(long[] ids, boolean delFlag) throws Exception {
        return 0;
    }
}
