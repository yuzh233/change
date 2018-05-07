package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.user.Company;

public interface CompanyDao extends BaseDao<Company>, DaoSelectByName<Company> {
    String NAME_SPACE = "Company";
}
