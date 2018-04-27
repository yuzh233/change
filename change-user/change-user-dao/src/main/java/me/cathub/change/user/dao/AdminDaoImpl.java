package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.AdminDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.user.bean.Admin;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminDaoImpl extends BaseCrudMyBatisImpl<Admin> implements AdminDao {

    @Override
    public boolean insert(Admin bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Admin bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Admin bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Admin bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Admin bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Admin select(Admin bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Admin> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Admin> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public Admin login(Admin admin) throws Exception {
        Admin result = null;
        try {
            result = sqlSessionTemplate.selectOne(NAME_SPACE + LOGIN, admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Admin selectByName(String name, int tableIndex) throws Exception {
        Admin result = null;
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
