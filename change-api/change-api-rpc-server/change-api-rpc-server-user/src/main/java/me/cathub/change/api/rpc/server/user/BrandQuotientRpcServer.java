package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.user.BrandQuotient;

public interface BrandQuotientRpcServer extends BaseRpcServer<BrandQuotient>, FillAssociationDate<BrandQuotient>, ServerSelectByName<BrandQuotient>, LoginInterface<BrandQuotient> {

    /**
     * 根据企业id获取品牌商账号
     * @param company_id
     * @param tableIndex
     * @return
     */
    BrandQuotient selectByCompanyId(long company_id, int tableIndex, boolean flag);
}
