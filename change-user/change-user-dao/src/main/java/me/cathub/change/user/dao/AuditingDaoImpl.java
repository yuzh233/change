package me.cathub.change.user.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.common.base.BaseIbatis;
import me.cathub.change.user.bean.Auditing;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuditingDaoImpl extends BaseIbatis<Auditing> implements AuditingDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Auditing> listByAdminIdAndUserType(long admin_id, int type, int page, int count, int tableIndex) throws Exception {
        List<Auditing> results = null;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("admin_id", admin_id);
            map.put("type", type);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_ADMIN_AND_TYPE, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception {
        List<Auditing> results = null;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("type", type);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_NOT_AUDITING, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByAdminIdAndUserType(long admin_id, int type, int tableIndex) throws Exception {
        int count = 0;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("admin_id", admin_id);
            map.put("type", type);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_ADMIN_AND_TYPE, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int countByNotAuditing(int type, int tableIndex) throws Exception {
        int count = 0;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("type", type);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_NOT_AUDITING, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
