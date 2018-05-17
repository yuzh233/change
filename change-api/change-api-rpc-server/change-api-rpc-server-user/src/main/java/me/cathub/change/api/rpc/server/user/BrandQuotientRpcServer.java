package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.user.bean.BrandQuotient;

import java.util.List;

/**
 * 品牌商Rpc服务接口
 *
 * @author cheng
 */
public interface BrandQuotientRpcServer extends BaseRpcServer<BrandQuotient>, ServerSelectByName<BrandQuotient> {

    /**
     * 根据企业id查询品牌商账户列表
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<BrandQuotient> listByCompanyId(long companyId, int page, int count , int tableIndex, boolean flag) throws Exception;

    /**
     * 根据企业id查询品牌商账户数量
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByCompanyId(long companyId, int tableIndex) throws Exception;
}
