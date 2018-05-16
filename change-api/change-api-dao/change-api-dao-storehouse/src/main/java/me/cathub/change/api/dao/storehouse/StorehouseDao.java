package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.storehouse.bean.Storehouse;

import java.util.List;

/**
 * 仓库Dao接口
 *
 * @author cheng
 */
public interface StorehouseDao extends BaseDao<Storehouse>, DaoSelectByName<Storehouse> {
    String NAME_SPACE = "Storehouse";

    String LIST_BY_STOREHOUSE_COUNTRY_ID = ".listByStorehouseCountryId";
    String COUNT_BY_STOREHOUSE_COUNTRY_ID = ".countByStorehouseCountryId";

    /**
     * 根据国家获取仓库列表
     * @param storehouseCountryId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Storehouse> listByStorehouseCountryId(long storehouseCountryId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据国家获取仓库数量
     * @param storehouseCountryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseCountryId(long storehouseCountryId, int tableIndex) throws Exception;
}
