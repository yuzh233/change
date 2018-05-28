package me.cathub.change.api.rpc.server.wallet;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.wallet.bean.Balance;

/**
 * 账户余额 Rpc 服务接口
 * @author cheng
 * @date 2018/5/28
 * @time 17:50
 */
public interface BalanceRpcServer extends BaseRpcServer<Balance> {

    /**
     * 根据用户id查找绑定的支付宝
     * @param userId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    Balance selectByUserId(long userId, int tableIndex, boolean flag) throws Exception;
}
