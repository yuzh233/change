package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.ApplyDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.upms.bean.Apply;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 应用Dao实现类
 *
 * @author cheng
 */
@Repository
public class ApplyDaoImpl extends BaseDaoMyBatisImpl<Apply> implements ApplyDao {

    @Override
    public boolean insert(Apply bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Apply bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Apply bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Apply bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Apply bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Apply select(Apply bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Apply> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Apply> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public Apply selectByName(String name, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return search(NAME_SPACE + SELECT_BY_NAME, map);
    }
}
