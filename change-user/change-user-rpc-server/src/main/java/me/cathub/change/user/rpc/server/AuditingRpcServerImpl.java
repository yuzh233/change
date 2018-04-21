package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.AuditingCrud;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.user.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AuditingRpcServerImpl implements AuditingRpcServer {

    @Autowired
    private AuditingCrud auditingDao;

    @Autowired
    private AdminRpcServer adminRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Auditing bean) throws Exception {
        bean.setId(sequence.nextId());
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
            Admin admin = adminRpcServer.select(new Admin(bean.getAdmin_id()));
            bean.setAdmin(admin);

            User user = null;
            if (bean.getType() == Auditing.TYPE_BRANDQUOTIENT)
                user = brandQuotientRpcServer.select(new BrandQuotient(bean.getUser_id()));
            else if(bean.getType() == Auditing.TYPE_SHOPKEEPER)
                user = shopkeeperRpcServer.select(new Shopkeeper(bean.getUser_id()));
            bean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
