package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseCountryDao;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.storehouse.bean.StorehouseCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorehouseCountryRpcServerImpl implements StorehouseCountryRpcServer {

    @Autowired
    private StorehouseCountryDao storehouseCountryDao;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(StorehouseCountry bean) throws Exception {
        bean.setId(sequence.nextId());
        return storehouseCountryDao.insert(bean) ? bean.getId() : -1;
    }

    @Override
    public boolean deleteL(StorehouseCountry bean) throws Exception {
        return storehouseCountryDao.deleteL(bean);
    }

    @Override
    public boolean restore(StorehouseCountry bean) throws Exception {
        return storehouseCountryDao.restore(bean);
    }

    @Override
    public boolean deleteP(StorehouseCountry bean) throws Exception {
        return storehouseCountryDao.deleteP(bean);
    }

    @Override
    public boolean update(StorehouseCountry bean) throws Exception {
        return storehouseCountryDao.update(bean);
    }

    @Override
    public StorehouseCountry select(StorehouseCountry bean) throws Exception {
        return storehouseCountryDao.select(bean);
    }

    @Override
    public List<StorehouseCountry> list(int page, int count, int tableIndex) throws Exception {
        return storehouseCountryDao.list(page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return storehouseCountryDao.count(tableIndex);
    }

    @Override
    public List<StorehouseCountry> listByDel(int page, int count, int tableIndex) throws Exception {
        return storehouseCountryDao.listByDel(page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return storehouseCountryDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return storehouseCountryDao.count(tableIndex);
    }

    @Override
    public StorehouseCountry selectByName(String name, int tableIndex) throws Exception {
        return storehouseCountryDao.selectByName(name, tableIndex);
    }
}
