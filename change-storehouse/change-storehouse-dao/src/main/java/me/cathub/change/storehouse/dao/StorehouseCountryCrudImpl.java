package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseCountryCrud;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StorehouseCountryCrudImpl extends BaseCrudMyBatisImpl<StorehouseCountry> implements StorehouseCountryCrud {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }
}
