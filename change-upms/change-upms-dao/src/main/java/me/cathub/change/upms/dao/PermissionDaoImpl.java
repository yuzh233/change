package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.upms.bean.Permission;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 授权Dao实现类
 *
 * @author cheng
 */
@Repository
public class PermissionDaoImpl extends BaseDaoMyBatisImpl<Permission> implements PermissionDao {

    @Override
    public boolean insert(Permission bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Permission bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Permission bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Permission bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Permission bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Permission select(Permission bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Permission> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Permission> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public Permission selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }

    @Override
    public List<Permission> listByApplyId(long applyId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("apply_id", applyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_APPLY_ID, page, count, map);
    }

    @Override
    public int countByApplyId(long applyId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("apply_id", applyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_APPLY_ID, map);
    }

    @Override
    public List<Permission> childListById(long id, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + CHILD_LIST_BY_ID, page, count, map);
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + CHILD_COUNT_BY_ID, map);
    }
}
