package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.AliPayDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.wallet.bean.AliPay;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户绑定支付宝 Dao 实现类
 * @author cheng
 * @date 2018/5/27
 * @time 22:26
 */

@Repository
public class AliPayDaoImpl extends BaseDaoMyBatisImpl<AliPay> implements AliPayDao {

    @Override
    public boolean insert(AliPay aliPay) throws Exception {
        return insert(NAME_SPACE, aliPay);
    }

    @Override
    public boolean deleteL(AliPay aliPay) throws Exception {
        return deleteL(NAME_SPACE, aliPay);
    }

    @Override
    public boolean restore(AliPay aliPay) throws Exception {
        return restore(NAME_SPACE, aliPay);
    }

    @Override
    public boolean deleteP(AliPay aliPay) throws Exception {
        return deleteP(NAME_SPACE, aliPay);
    }

    @Override
    public boolean update(AliPay aliPay) throws Exception {
        return update(NAME_SPACE, aliPay);
    }

    @Override
    public AliPay select(AliPay aliPay) throws Exception {
        return select(NAME_SPACE, aliPay);
    }

    @Override
    public List<AliPay> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<AliPay> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public AliPay selectByUserId(long userId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("user_id", userId);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_USER_ID, map);
    }
}
