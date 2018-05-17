package me.cathub.change.api.dao.storehouse;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.storehouse.bean.StorehouseCountry;

/**
 * 仓库所属国家Dao接口
 *
 * @author cheng
 */
public interface StorehouseCountryDao extends BaseDao<StorehouseCountry>, DaoSelectByName<StorehouseCountry> {
    String NAME_SPACE = "StorehouseCountry";
}
