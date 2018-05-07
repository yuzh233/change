package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseDao;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.storehouse.StorehouseCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StorehouseRpcServerImpl extends BaseRpcServerImpl<Storehouse, StorehouseDao> implements StorehouseRpcServer {

    @Autowired
    private StorehouseCountryRpcServer storehouseCountryRpcServer;

    @Override
    public Storehouse selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public List<Storehouse> listByStorehouseCountryId(long storehouseCountry_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByStorehouseCountryId(storehouseCountry_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByStorehouseCountryId(long storehouseCountry_id, int tableIndex) throws Exception {
        return dao.countByStorehouseCountryId(storehouseCountry_id, tableIndex);
    }

    @Override
    public Storehouse fill(Storehouse bean) {
        try {
            StorehouseCountry storehouseCountry = storehouseCountryRpcServer.select(new StorehouseCountry(bean.getStorehouseCountry_id()), true);

            bean.setStorehouseCountry(storehouseCountry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
