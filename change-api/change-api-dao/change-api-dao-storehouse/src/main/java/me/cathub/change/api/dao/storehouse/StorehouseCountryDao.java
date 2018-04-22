package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.storehouse.bean.StorehouseCountry;

public interface StorehouseCountryDao extends BaseCrud<StorehouseCountry>, SelectByName<StorehouseCountry> {
    String NAME_SPACE = "me.cathub.change.storehouse.bean.StorehouseCountry";
}
