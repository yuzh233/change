package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.OutputAuditingDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.wallet.bean.OutputAuditing;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提现审核 Dao 实现类
 * @author cheng
 * @date 2018/5/27
 * @time 22:38
 */

@Repository
public class OutputAuditingDaoImpl extends BaseDaoMyBatisImpl<OutputAuditing> implements OutputAuditingDao {

    @Override
    public boolean insert(OutputAuditing outputAuditing) throws Exception {
        return insert(NAME_SPACE, outputAuditing);
    }

    @Override
    public boolean deleteL(OutputAuditing outputAuditing) throws Exception {
        return deleteL(NAME_SPACE, outputAuditing);
    }

    @Override
    public boolean restore(OutputAuditing outputAuditing) throws Exception {
        return restore(NAME_SPACE, outputAuditing);
    }

    @Override
    public boolean deleteP(OutputAuditing outputAuditing) throws Exception {
        return deleteP(NAME_SPACE, outputAuditing);
    }

    @Override
    public boolean update(OutputAuditing outputAuditing) throws Exception {
        return update(NAME_SPACE, outputAuditing);
    }

    @Override
    public OutputAuditing select(OutputAuditing outputAuditing) throws Exception {
        return select(NAME_SPACE, outputAuditing);
    }

    @Override
    public List<OutputAuditing> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OutputAuditing> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<OutputAuditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("admin_id", adminId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ADMIN_AND_USER_TYPE, page, count, map);
    }

    @Override
    public int countByAdminIdAndUserType(long adminId, int type, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("admin_id", adminId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ADMIN_AND_USER_TYPE, map);
    }

    @Override
    public List<OutputAuditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_NOT_AUDITING, page, count, map);
    }

    @Override
    public int countByNotAuditing(int type, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_NOT_AUDITING, map);
    }

    @Override
    public List<OutputAuditing> listByUserIdAndUserType(long userId, int type, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("user_id", userId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_USER_ID_AND_USER_TYPE, page, count, map);
    }

    @Override
    public int countByUserIdAndUserType(long userId, int type, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("user_id", userId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_USER_ID_AND_USER_TYPE, map);
    }
}