package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.RoleDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.upms.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDaoImpl extends BaseCrudMyBatisImpl<Role> implements RoleDao {

    @Override
    public boolean insert(Role bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Role bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Role bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Role bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Role bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Role select(Role bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Role> list(int page, int count, int tableIndex) throws Exception {
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
    public Role selectByName(String name, int tableIndex) throws Exception {
        Role result = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            map.put("tableIndex", tableIndex);
            result = sqlSessionTemplate.selectOne(NAME_SPACE + SELECT_BY_NAME, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
