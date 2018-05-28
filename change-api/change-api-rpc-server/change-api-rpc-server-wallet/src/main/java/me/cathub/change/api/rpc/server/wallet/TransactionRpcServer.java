package me.cathub.change.api.rpc.server.wallet;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.wallet.bean.Transaction;

import java.util.List;

/**
 * 交易记录 Rpc 服务接口
 * @author cheng
 * @date 2018/5/28
 * @time 17:51
 */
public interface TransactionRpcServer extends BaseRpcServer<Transaction> {

    /**
     * 根据付款方Id获取交易记录列表
     * @param sendUserId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Transaction> listBySendUserId(long sendUserId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据付款方Id获取交易记录数量
     * @param sendUserId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countBySendUserId(long sendUserId, int tableIndex) throws Exception;

    /**
     * 根据收款方Id获取交易记录列表
     * @param receiveUserId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Transaction> listByReceiveUserId(long receiveUserId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据收款方Id获取交易记录数量
     * @param receiveUserId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByReceiveUserId(long receiveUserId, int tableIndex) throws Exception;
}
