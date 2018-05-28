package me.cathub.change.api.dao.wallet;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.wallet.bean.Balance;

/**
 * 用户余额 Dao
 * @author cheng
 * @date 2018/5/27
 * @time 19:38
 */
public interface BalanceDao extends BaseDao<Balance> {
    String NAME_SPACE = "Balance";

    String SELECT_BY_USER_ID = ".selectByUserId";

    /**
     * 根据用户Id查询余额
     * @param userId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    Balance selectByUserId(long userId, int tableIndex) throws Exception;
}
