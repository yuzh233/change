package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseCountryDao;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.stereotype.Service;

/**
 * 仓库所属国家Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class StorehouseCountryRpcServerImpl extends BaseRpcServerImpl<StorehouseCountry, StorehouseCountryDao> implements StorehouseCountryRpcServer {

    @Override
    public StorehouseCountry selectByName(String name, int tableIndex, boolean flag) throws Exception {
        return dao.selectByName(name, tableIndex);
    }

    @Override
    public StorehouseCountry fill(StorehouseCountry bean) {
        return bean;
    }
}
