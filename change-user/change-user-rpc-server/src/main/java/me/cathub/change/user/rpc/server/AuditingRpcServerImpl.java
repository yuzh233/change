package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AuditingRpcServerImpl extends BaseRpcServerImpl<Auditing, AuditingDao> implements AuditingRpcServer {

    @Autowired
    private AdminRpcServer adminRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public List<Auditing> listByAdminIdAndUserType(long admin_id, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByAdminIdAndUserType(admin_id, type, page, count, tableIndex);
        else
            return dao.listByAdminIdAndUserType(admin_id, type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByAdminIdAndUserType(long admin_id, int type, int tableIndex) throws Exception {
        return dao.countByAdminIdAndUserType(admin_id, type, tableIndex);
    }

    @Override
    public List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByNotAuditing(type, page, count, tableIndex);
        else
            return dao.listByNotAuditing(type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByNotAuditing(int type, int tableIndex) throws Exception {
        return dao.countByNotAuditing(type, tableIndex);
    }

    @Override
    public Auditing fill(Auditing bean) {
        try {
            Admin admin = adminRpcServer.select(new Admin(bean.getAdmin_id()), true);
            bean.setAdmin(admin);

            User user = null;
            if (bean.getType() == Auditing.TYPE_BRAND_QUOTIENT)
                user = brandQuotientRpcServer.select(new BrandQuotient(bean.getUser_id()), true);
            else if(bean.getType() == Auditing.TYPE_SHOPKEEPER)
                user = shopkeeperRpcServer.select(new Shopkeeper(bean.getUser_id()), true);
            bean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
