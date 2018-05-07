package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.user.BrandQuotient;

public interface BrandQuotientDao extends BaseDao<BrandQuotient>, LoginInterface<BrandQuotient>, DaoSelectByName<BrandQuotient> {
    String NAME_SPACE = "BrandQuotient";
    String SELECT_BY_COMPANY_ID = "selectByCompanyId";

    /**
     * 根据企业id获取品牌商账号
     * @param company_id
     * @param tableIndex
     * @return
     */
    BrandQuotient selectByCompanyId(long company_id, int tableIndex);
}