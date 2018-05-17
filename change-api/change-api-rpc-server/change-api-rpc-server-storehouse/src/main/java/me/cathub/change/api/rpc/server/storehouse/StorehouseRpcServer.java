package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.storehouse.bean.Storehouse;

import java.util.List;

/**
 * 仓库Rpc服务接口
 *
 * @author cheng
 */
public interface StorehouseRpcServer extends BaseRpcServer<Storehouse>, ServerSelectByName<Storehouse> {

    /**
     * 根据国家获取仓库列表
     * @param storehouseCountryId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Storehouse> listByStorehouseCountryId(long storehouseCountryId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据国家获取仓库数量
     * @param storehouseCountryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseCountryId(long storehouseCountryId, int tableIndex) throws Exception;
}
