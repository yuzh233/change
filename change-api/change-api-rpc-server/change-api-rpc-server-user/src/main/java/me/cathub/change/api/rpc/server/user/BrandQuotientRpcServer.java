package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.user.bean.BrandQuotient;

/**
 * 品牌商Rpc服务接口
 *
 * @author cheng
 */
public interface BrandQuotientRpcServer extends BaseRpcServer<BrandQuotient>, FillAssociationDate<BrandQuotient>, ServerSelectByName<BrandQuotient> {

    /**
     * 根据企业id获取品牌商账号
     * @param companyId
     * @param tableIndex
     * @param flag
     * @return
     */
    BrandQuotient selectByCompanyId(long companyId, int tableIndex, boolean flag);
}
