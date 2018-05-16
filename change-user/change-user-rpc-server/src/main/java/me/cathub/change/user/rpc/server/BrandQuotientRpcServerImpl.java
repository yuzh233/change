package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 品牌商Rpc服务实现类
 * 
 * @author cheng 
 */
@Service
public class BrandQuotientRpcServerImpl extends BaseRpcServerImpl<BrandQuotient, BrandQuotientDao> implements BrandQuotientRpcServer {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Override
    public BrandQuotient selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByName(name, tableIndex);
        } else {
            return fill(dao.selectByName(name, tableIndex));
        }
    }

    @Override
    public BrandQuotient selectByCompanyId(long companyId, int tableIndex, boolean flag) {
        if (flag) {
            return dao.selectByCompanyId(companyId, tableIndex);
        } else {
            return fill(dao.selectByCompanyId(companyId, tableIndex));
        }
    }

    @Override
    public BrandQuotient fill(BrandQuotient bean) {
        try {
            Company company = companyRpcServer.select(new Company(bean.getCompanyId()), true);
            Role role = roleRpcServer.select(new Role(bean.getRoleId()), true);

            bean.setCompany(company);
            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
