package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.UserRoleDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.upms.bean.UserRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 用户角色Dao实现类
 *
 * @author cheng
 */
@Repository
public class UserRoleDaoImpl extends BaseDaoMyBatisImpl<UserRole> implements UserRoleDao {

    @Override
    public boolean insert(UserRole bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(UserRole bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(UserRole bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(UserRole bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(UserRole bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public UserRole select(UserRole bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<UserRole> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<UserRole> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<UserRole> listByUserId(long userId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("user_id", userId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_USER_ID, page, count, map);
    }

    @Override
    public int countByUserId(long userId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("user_id", userId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_USER_ID, map);
    }

    @Override
    public List<UserRole> listByRoleId(long roleId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("role_id", roleId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ROLE_ID, page, count, map);
    }

    @Override
    public int countByRoleId(long roleId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("role_id", roleId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ROLE_ID, map);
    }
}
