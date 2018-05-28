package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.BalanceDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.wallet.bean.Balance;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户余额 Dao 实现类
 * @author cheng
 * @date 2018/5/27
 * @time 22:35
 */

@Repository
public class BalanceDaoImpl extends BaseDaoMyBatisImpl<Balance> implements BalanceDao {

    @Override
    public boolean insert(Balance balance) throws Exception {
        return insert(NAME_SPACE, balance);
    }

    @Override
    public boolean deleteL(Balance balance) throws Exception {
        return deleteL(NAME_SPACE, balance);
    }

    @Override
    public boolean restore(Balance balance) throws Exception {
        return restore(NAME_SPACE, balance);
    }

    @Override
    public boolean deleteP(Balance balance) throws Exception {
        return deleteP(NAME_SPACE, balance);
    }

    @Override
    public boolean update(Balance balance) throws Exception {
        return update(NAME_SPACE, balance);
    }

    @Override
    public Balance select(Balance balance) throws Exception {
        return select(NAME_SPACE, balance);
    }

    @Override
    public List<Balance> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Balance> listByDel(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return countByDel(NAME_SPACE, tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public Balance selectByUserId(long userId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("user_id", userId);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_USER_ID, map);
    }
}
