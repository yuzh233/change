package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseRpcServerImpl<B, S extends BaseRpcServer> implements BaseRpcServer<B> {

    @Autowired
    protected S service;

    @Override
    public boolean insert(B bean) throws Exception {
        return service.insert(bean);
    }

    @Override
    public boolean deleteL(B bean) throws Exception {
        return service.deleteL(bean);
    }

    @Override
    public boolean restore(B bean) throws Exception {
        return service.restore(bean);
    }

    @Override
    public boolean deleteP(B bean) throws Exception {
        return service.deleteP(bean);
    }

    @Override
    public boolean update(B bean) throws Exception {
        return service.update(bean);
    }

    @Override
    public B select(B bean) throws Exception {
        return (B) service.select(bean);
    }

    @Override
    public List<B> list(int page, int count, int tableIndex) throws Exception {
        return service.list(page, count, tableIndex);
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return service.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return service.clear(tableIndex);
    }
}
