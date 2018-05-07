package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.storehouse.Storehouse;

import java.util.List;

public interface StorehouseRpcServer extends BaseRpcServer<Storehouse>, FillAssociationDate<Storehouse>, ServerSelectByName<Storehouse> {

    /**
     * 根据国家获取仓库列表
     * @param storehouseCountry_id
     * @return
     * @throws Exception
     */
    List<Storehouse> listByStorehouseCountryId(long storehouseCountry_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据国家获取仓库数量
     * @param storehouseCountry_id
     * @return
     * @throws Exception
     */
    int countByStorehouseCountryId(long storehouseCountry_id, int tableIndex) throws Exception;
}
