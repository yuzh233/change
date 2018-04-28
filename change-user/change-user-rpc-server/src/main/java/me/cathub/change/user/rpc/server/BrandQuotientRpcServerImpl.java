package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.tool.Sequence;
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

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(BrandQuotient bean) throws Exception {
        bean.setId(sequence.nextId());
        return brandQuotientDao.insert(bean) ? bean.getId() : -1;
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
    public BrandQuotient select(BrandQuotient bean, boolean flag) throws Exception {
        if (flag)
            return brandQuotientDao.select(bean);
        else
            return fill(brandQuotientDao.select(bean));
    }

    @Override
    public List<BrandQuotient> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return brandQuotientDao.list(page, count, tableIndex);
        else
            return brandQuotientDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return brandQuotientDao.count(tableIndex);
    }

    @Override
    public List<BrandQuotient> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return brandQuotientDao.listByDel(page, count, tableIndex);
        else
            return brandQuotientDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return brandQuotientDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return brandQuotientDao.count(tableIndex);
    }

    @Override
    public BrandQuotient selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return brandQuotientDao.selectByName(name, tableIndex);
        else
            return fill(brandQuotientDao.selectByName(name, tableIndex));
    }

    @Override
    public BrandQuotient fill(BrandQuotient bean) {
        try {
            Company company = companyRpcServer.select(new Company(bean.getCompany_id()), true);
            Role role = roleRpcServer.select(new Role(bean.getRole_id()), true);

            bean.setCompany(company);
            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
