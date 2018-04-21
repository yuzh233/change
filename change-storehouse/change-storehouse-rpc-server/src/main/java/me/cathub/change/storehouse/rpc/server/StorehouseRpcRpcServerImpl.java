package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseCrud;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StorehouseRpcRpcServerImpl implements StorehouseRpcRpcServer {

    @Autowired
    private StorehouseCrud storehouseDao;

    @Autowired
    private StorehouseCountryRpcRpcServer storehouseCountryRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Storehouse bean) throws Exception {
        bean.setId(sequence.nextId());
        return storehouseDao.insert(bean);
    }

    @Override
    public boolean deleteL(Storehouse bean) throws Exception {
        return storehouseDao.deleteL(bean);
    }

    @Override
    public boolean restore(Storehouse bean) throws Exception {
        return storehouseDao.restore(bean);
    }

    @Override
    public boolean deleteP(Storehouse bean) throws Exception {
        return storehouseDao.deleteP(bean);
    }

    @Override
    public boolean update(Storehouse bean) throws Exception {
        return storehouseDao.update(bean);
    }

    @Override
    public Storehouse select(Storehouse bean) throws Exception {
        return fill(storehouseDao.select(bean));
    }

    @Override
    public List<Storehouse> list(int page, int count, int tableIndex) throws Exception {
        return storehouseDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return storehouseDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return storehouseDao.count(tableIndex);
    }

    @Override
    public Storehouse fill(Storehouse bean) {
        try {
            StorehouseCountry storehouseCountry = storehouseCountryRpcServer.select(new StorehouseCountry(bean.getStorehouseCountry_id()));

            bean.setStorehouseCountry(storehouseCountry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
