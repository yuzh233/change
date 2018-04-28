package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.storehouse.bean.StorehouseCountry;

public interface StorehouseCountryDao extends BaseDao<StorehouseCountry>, DaoSelectByName<StorehouseCountry> {
    String NAME_SPACE = "me.cathub.change.storehouse.bean.StorehouseCountry";
}
