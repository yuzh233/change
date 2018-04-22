package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.RoleDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleRpcServerImpl implements RoleRpcServer {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Role bean) throws Exception {
        bean.setId(sequence.nextId());
        return roleDao.insert(bean);
    }

    @Override
    public boolean deleteL(Role bean) throws Exception {
        return roleDao.deleteL(bean);
    }

    @Override
    public boolean restore(Role bean) throws Exception {
        return roleDao.restore(bean);
    }

    @Override
    public boolean deleteP(Role bean) throws Exception {
        return roleDao.deleteP(bean);
    }

    @Override
    public boolean update(Role bean) throws Exception {
        return roleDao.update(bean);
    }

    @Override
    public Role select(Role bean) throws Exception {
        return roleDao.select(bean);
    }

    @Override
    public List<Role> list(int page, int count, int tableIndex) throws Exception {
        return roleDao.list(page, count, tableIndex);
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return roleDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return roleDao.count(tableIndex);
    }
}
