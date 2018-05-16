package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.AuditingRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.user.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 入驻审核Rpc服务实现类
 * 
 * @author cheng 
 */
@Service
public class AuditingRpcServerImpl extends BaseRpcServerImpl<Auditing, AuditingDao> implements AuditingRpcServer {

    @Autowired
    private AdminRpcServer adminRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public List<Auditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByAdminIdAndUserType(adminId, type, page, count, tableIndex);
        } else {
            return dao.listByAdminIdAndUserType(adminId, type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByAdminIdAndUserType(long adminId, int type, int tableIndex) throws Exception {
        return dao.countByAdminIdAndUserType(adminId, type, tableIndex);
    }

    @Override
    public List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByNotAuditing(type, page, count, tableIndex);
        } else {
            return dao.listByNotAuditing(type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByNotAuditing(int type, int tableIndex) throws Exception {
        return dao.countByNotAuditing(type, tableIndex);
    }

    @Override
    public Auditing fill(Auditing bean) {
        try {
            Admin admin = adminRpcServer.select(new Admin(bean.getAdminId()), true);
            bean.setAdmin(admin);

            User user = null;
            if (bean.getType() == Auditing.TYPE_BRAND_QUOTIENT) {
                user = brandQuotientRpcServer.select(new BrandQuotient(bean.getUserId()), true);
            } else if(bean.getType() == Auditing.TYPE_SHOPKEEPER) {
                user = shopkeeperRpcServer.select(new Shopkeeper(bean.getUserId()), true);
            }
            bean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
