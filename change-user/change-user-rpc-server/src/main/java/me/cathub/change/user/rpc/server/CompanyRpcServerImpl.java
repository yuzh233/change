package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.CompanyDao;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.user.bean.Company;
import org.springframework.stereotype.Service;


@Service
public class CompanyRpcServerImpl extends BaseRpcServerImpl<Company, CompanyDao> implements CompanyRpcServer {

    @Override
    public Company selectByName(String name, int tableIndex, boolean flag) throws Exception {
        return dao.selectByName(name, tableIndex);
    }

    @Override
    public Company fill(Company bean) {
        return bean;
    }
}
