package me.cathub.change.api.rpc.server.wallet;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.wallet.bean.AliPay;

/**
 * 用户绑定的支付宝 Rpc 服务接口
 * @author cheng
 * @date 2018/5/28
 * @time 17:48
 */
public interface AliPayRpcServer extends BaseRpcServer<AliPay> {

    /**
     * 根据用户id查找绑定的支付宝
     * @param userId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    AliPay selectByUserId(long userId, int tableIndex, boolean flag) throws Exception;
}
