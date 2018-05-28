package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.TransactionDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.wallet.bean.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易记录 Dao 实现类
 * @author cheng
 * @date 2018/5/27
 * @time 22:48
 */

@Repository
public class TransactionDaoImpl extends BaseDaoMyBatisImpl<Transaction> implements TransactionDao {

    @Override
    public boolean insert(Transaction transaction) throws Exception {
        return insert(NAME_SPACE, transaction);
    }

    @Override
    public boolean deleteL(Transaction transaction) throws Exception {
        return deleteL(NAME_SPACE, transaction);
    }

    @Override
    public boolean restore(Transaction transaction) throws Exception {
        return restore(NAME_SPACE, transaction);
    }

    @Override
    public boolean deleteP(Transaction transaction) throws Exception {
        return deleteP(NAME_SPACE, transaction);
    }

    @Override
    public boolean update(Transaction transaction) throws Exception {
        return update(NAME_SPACE, transaction);
    }

    @Override
    public Transaction select(Transaction transaction) throws Exception {
        return select(NAME_SPACE, transaction);
    }

    @Override
    public List<Transaction> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Transaction> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<Transaction> listBySendUserId(long sendUserId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("sendUser_id", sendUserId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_SEND_USER_ID, page, count, map);
    }

    @Override
    public int countBySendUserId(long sendUserId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("sendUser_id", sendUserId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_SEND_USER_ID, map);
    }

    @Override
    public List<Transaction> listByReceiveUserId(long receiveUserId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("receiveUser_id", receiveUserId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_RECEIVE_USER_ID, page, count, map);
    }

    @Override
    public int countByReceiveUserId(long receiveUserId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("receiveUser_id", receiveUserId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_RECEIVE_USER_ID, map);
    }
}
