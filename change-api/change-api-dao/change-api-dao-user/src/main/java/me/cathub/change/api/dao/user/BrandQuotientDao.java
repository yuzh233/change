package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.user.bean.BrandQuotient;

import java.util.List;

/**
 * 品牌商Dao接口
 *
 * @author cheng
 */
public interface BrandQuotientDao extends BaseDao<BrandQuotient>, DaoSelectByName<BrandQuotient> {
    String NAME_SPACE = "BrandQuotient";

    String LIST_BY_COMPANY_ID = ".listByCompanyId";
    String COUNT_BY_COMPANY_ID = ".countByCompanyId";

    /**
     * 根据企业id查询品牌商账户列表
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<BrandQuotient> listByCompanyId(long companyId, int page, int count , int tableIndex) throws Exception;

    /**
     * 根据企业id查询品牌商账户数量
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByCompanyId(long companyId, int tableIndex) throws Exception;
}