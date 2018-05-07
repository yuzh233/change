package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.user.Company;

public interface CompanyRpcServer extends BaseRpcServer<Company>, ServerSelectByName<Company> {
}
