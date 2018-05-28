package me.cathub.change.api.dao.wallet;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.wallet.bean.AliPay;

/**
 * 绑定支付宝 Dao接口
 * @author cheng
 * @date 2018/5/27
 * @time 19:38
 */
public interface AliPayDao extends BaseDao<AliPay> {
    String NAME_SPACE = "AliPay";

    String SELECT_BY_USER_ID = ".selectByUserId";

    /**
     * 根据用户id查找绑定的支付宝
     * @param userId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    AliPay selectByUserId(long userId, int tableIndex) throws Exception;
}
