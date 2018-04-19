package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BrandQuotientRpcServerImpl implements BrandQuotientRpcServer {

    @Autowired
    private BrandQuotientDao brandQuotientDao;

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Override
    public boolean insert(BrandQuotient bean) throws Exception {
        return brandQuotientDao.insert(bean);
    }

    @Override
    public boolean deleteL(BrandQuotient bean) throws Exception {
        return brandQuotientDao.deleteL(bean);
    }

    @Override
    public boolean restore(BrandQuotient bean) throws Exception {
        return brandQuotientDao.restore(bean);
    }

    @Override
    public boolean deleteP(BrandQuotient bean) throws Exception {
        return brandQuotientDao.deleteP(bean);
    }

    @Override
    public boolean update(BrandQuotient bean) throws Exception {
        return brandQuotientDao.update(bean);
    }

    @Override
    public BrandQuotient select(BrandQuotient bean) throws Exception {
        return fill(brandQuotientDao.select(bean));
    }

    @Override
    public List<BrandQuotient> list(int page, int count, int tableIndex) throws Exception {
        return brandQuotientDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return brandQuotientDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return brandQuotientDao.count(tableIndex);
    }

    @Override
    public BrandQuotient fill(BrandQuotient bean) {
        try {
            bean.setCompany(companyRpcServer.select(new Company(bean.getCompany_id())));
            bean.setRole(roleRpcServer.select(new Role(bean.getRole_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
