package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.user.bean.Auditing;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AuditingRpcServerImpl implements AuditingRpcServer {

    @Autowired
    private AuditingDao auditingDao;

    @Autowired
    private AdminRpcServer adminRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public boolean insert(Auditing bean) throws Exception {
        return auditingDao.insert(bean);
    }

    @Override
    public boolean deleteL(Auditing bean) throws Exception {
        return auditingDao.deleteL(bean);
    }

    @Override
    public boolean restore(Auditing bean) throws Exception {
        return auditingDao.restore(bean);
    }

    @Override
    public boolean deleteP(Auditing bean) throws Exception {
        return auditingDao.deleteP(bean);
    }

    @Override
    public boolean update(Auditing bean) throws Exception {
        return auditingDao.update(bean);
    }

    @Override
    public Auditing select(Auditing bean) throws Exception {
        return fill(auditingDao.select(bean));
    }

    @Override
    public List<Auditing> list(int page, int count, int tableIndex) throws Exception {
        return auditingDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return auditingDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return auditingDao.count(tableIndex);
    }

    @Override
    public Auditing fill(Auditing bean) {
        try {
            bean.setAdmin(adminRpcServer.select(new Admin(bean.getAdmin_id())));
            if (bean.getType() == Auditing.TYPE_BRANDQUOTIENT)
                bean.setUser(brandQuotientRpcServer.select(new BrandQuotient(bean.getUser_id())));
            else if(bean.getType() == Auditing.TYPE_SHOPKEEPER)
                bean.setUser(shopkeeperRpcServer.select(new Shopkeeper(bean.getUser_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
