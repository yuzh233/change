package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.storehouse.StorehouseCountry;

public interface StorehouseCountryRpcServer extends BaseRpcServer<StorehouseCountry>, ServerSelectByName<StorehouseCountry> {
}
