package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseCountryDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库所属国家Dao实现类
 *
 * @author cheng
 */
@Repository
public class StorehouseCountryDaoImpl extends BaseDaoMyBatisImpl<StorehouseCountry> implements StorehouseCountryDao {

    @Override
    public boolean insert(StorehouseCountry bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(StorehouseCountry bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(StorehouseCountry bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(StorehouseCountry bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(StorehouseCountry bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public StorehouseCountry select(StorehouseCountry bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<StorehouseCountry> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<StorehouseCountry> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public StorehouseCountry selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return search(NAME_SPACE + SELECT_BY_NAME, map);
    }
}
