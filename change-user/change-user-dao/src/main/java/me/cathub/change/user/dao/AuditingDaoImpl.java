package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.user.bean.Auditing;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 入驻审核Dao实现类
 *
 * @author cheng
 */
@Repository
public class AuditingDaoImpl extends BaseDaoMyBatisImpl<Auditing> implements AuditingDao {

    @Override
    public boolean insert(Auditing bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Auditing bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Auditing bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Auditing bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Auditing bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Auditing select(Auditing bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Auditing> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Auditing> listByDel(int page, int count, int tableIndex) throws Exception {
        return listByDel(NAME_SPACE, page, count, tableIndex);
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
    public List<Auditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("admin_id", adminId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ADMIN_AND_TYPE, page, count, map);
    }

    @Override
    public int countByAdminIdAndUserType(long adminId, int type, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("admin_id", adminId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ADMIN_AND_TYPE, map);
    }

    @Override
    public List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception {
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
}
