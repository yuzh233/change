package me.cathub.change.api.dao.wallet;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.wallet.bean.Transaction;

import java.util.List;

/**
 * 交易记录 Dao
 * @author cheng
 * @date 2018/5/27
 * @time 19:38
 */
public interface TransactionDao extends BaseDao<Transaction> {
    String NAME_SPACE = "Transaction";

    String LIST_BY_SEND_USER_ID = ".listBySendUserId";
    String COUNT_BY_SEND_USER_ID = ".countBySendUserId";
    String LIST_BY_RECEIVE_USER_ID = ".listByReceiveUserId";
    String COUNT_BY_RECEIVE_USER_ID = ".countByReceiveUserId";

    /**
     * 根据付款方Id获取交易记录列表
     * @param sendUserId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Transaction> listBySendUserId(long sendUserId, int page, int count, int tableIndex) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<Transaction> listByReceiveUserId(long receiveUserId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据收款方Id获取交易记录数量
     * @param receiveUserId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByReceiveUserId(long receiveUserId, int tableIndex) throws Exception;
}
