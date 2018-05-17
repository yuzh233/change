package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 品牌商Rpc服务实现类
 * 
 * @author cheng 
 */
@Service
public class BrandQuotientRpcServerImpl extends BaseRpcServerImpl<BrandQuotient, BrandQuotientDao> implements BrandQuotientRpcServer {

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Override
    public BrandQuotient selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByName(name, tableIndex);
        } else {
            return fill(dao.selectByName(name, tableIndex));
        }
    }

    @Override
    public List<BrandQuotient> listByCompanyId(long companyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByCompanyId(companyId, page, count, tableIndex);
        } else {
            return dao.listByCompanyId(companyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByCompanyId(long companyId, int tableIndex) throws Exception {
        return dao.countByCompanyId(companyId, tableIndex);
    }

    @Override
    public BrandQuotient fill(BrandQuotient bean) {
        try {
            Company company = companyRpcServer.select(new Company(bean.getCompanyId()), true);

            bean.setCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
