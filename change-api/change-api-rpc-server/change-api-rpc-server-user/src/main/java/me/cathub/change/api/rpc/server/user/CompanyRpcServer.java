package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.user.bean.Company;

/**
 * 企业Rpc服务接口
 *
 * @author cheng
 */
public interface CompanyRpcServer extends BaseRpcServer<Company>, ServerSelectByName<Company> {
}
