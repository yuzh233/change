package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.RolePermissionDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.upms.bean.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色权限Dao实现类
 *
 * @author cheng
 *
 * test time 5.21 23：44 OK
 */
@Repository
public class RolePermissionDaoImpl extends BaseDaoMyBatisImpl<RolePermission> implements RolePermissionDao {

    @Override
    public boolean insert(RolePermission bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(RolePermission bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(RolePermission bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(RolePermission bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(RolePermission bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public RolePermission select(RolePermission bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<RolePermission> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<RolePermission> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<RolePermission> listByRoleIdAndApplyId(long roleId, long applyId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("role_id", roleId);
        map.put("apply_id", applyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ROLE_ID_AND_APPLY_ID, page, count, map);
    }

    @Override
    public int countByRoleIdAndApplyId(long roleId, long applyId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("role_id", roleId);
        map.put("apply_id", applyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ROLE_ID_AND_APPLY_ID, map);
    }

    @Override
    public List<RolePermission> listByRoleId(long roleId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("role_id", roleId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ROLE_ID, page, count, map);
    }

    @Override
    public int countByRoleId(long roleId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("role_id", roleId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ROLE_ID, map);
    }
}
