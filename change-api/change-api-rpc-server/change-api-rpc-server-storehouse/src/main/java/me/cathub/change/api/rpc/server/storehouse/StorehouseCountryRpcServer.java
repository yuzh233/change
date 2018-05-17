package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.storehouse.bean.StorehouseCountry;

/**
 * 仓库所属国家Rpc服务接口
 *
 * @author cheng
 */
public interface StorehouseCountryRpcServer extends BaseRpcServer<StorehouseCountry>, ServerSelectByName<StorehouseCountry> {
}
