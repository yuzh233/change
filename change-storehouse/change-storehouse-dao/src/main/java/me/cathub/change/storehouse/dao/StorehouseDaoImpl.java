package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.storehouse.bean.Storehouse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库Dao实现类
 *
 * @author cheng
 */
@Repository
public class StorehouseDaoImpl extends BaseDaoMyBatisImpl<Storehouse> implements StorehouseDao {

    @Override
    public boolean insert(Storehouse bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Storehouse bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Storehouse bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Storehouse bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Storehouse bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Storehouse select(Storehouse bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Storehouse> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Storehouse> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<Storehouse> listByStorehouseCountryId(long storehouseCountryId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("storehouseCountry_id", storehouseCountryId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_STOREHOUSE_COUNTRY_ID, page, count, map);
    }

    @Override
    public int countByStorehouseCountryId(long storehouseCountryId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("storehouseCountry_id", storehouseCountryId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_STOREHOUSE_COUNTRY_ID, map);
    }

    @Override
    public Storehouse selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }
}
