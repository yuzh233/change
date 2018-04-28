package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.AdminDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AdminRpcServerImpl implements AdminRpcServer {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(Admin bean) throws Exception {
        bean.setId(sequence.nextId());
        return adminDao.insert(bean) ? bean.getId() : -1;
    }

    @Override
    public boolean deleteL(Admin bean) throws Exception {
        return adminDao.deleteL(bean);
    }

    @Override
    public boolean restore(Admin bean) throws Exception {
        return adminDao.restore(bean);
    }

    @Override
    public boolean deleteP(Admin bean) throws Exception {
        return adminDao.deleteP(bean);
    }

    @Override
    public boolean update(Admin bean) throws Exception {
        return adminDao.update(bean);
    }

    @Override
    public Admin select(Admin bean, boolean flag) throws Exception {
        if (flag)
            return adminDao.select(bean);
        else
            return fill(adminDao.select(bean));
    }

    @Override
    public List<Admin> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return adminDao.list(page, count, tableIndex);
        else
            return adminDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return adminDao.count(tableIndex);
    }

    @Override
    public List<Admin> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return adminDao.listByDel(page, count, tableIndex);
        else
            return adminDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return adminDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return adminDao.count(tableIndex);
    }

    @Override
    public Admin selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return adminDao.selectByName(name, tableIndex);
        else
            return adminDao.selectByName(name, tableIndex);
    }

    @Override
    public Admin fill(Admin bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRole_id()), true);

            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
