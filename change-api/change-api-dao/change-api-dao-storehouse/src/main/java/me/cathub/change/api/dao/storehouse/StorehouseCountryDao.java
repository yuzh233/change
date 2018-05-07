package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.storehouse.StorehouseCountry;

public interface StorehouseCountryDao extends BaseDao<StorehouseCountry>, DaoSelectByName<StorehouseCountry> {
    String NAME_SPACE = "StorehouseCountry";
}
