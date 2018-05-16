package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.user.bean.BrandQuotient;

/**
 * 品牌商Dao接口
 *
 * @author cheng
 */
public interface BrandQuotientDao extends BaseDao<BrandQuotient>, DaoSelectByName<BrandQuotient> {
    String NAME_SPACE = "BrandQuotient";
    String SELECT_BY_COMPANY_ID = "selectByCompanyId";

    /**
     * 根据企业id获取品牌商账号
     * @param companyId
     * @param tableIndex
     * @return
     */
    BrandQuotient selectByCompanyId(long companyId, int tableIndex);
}