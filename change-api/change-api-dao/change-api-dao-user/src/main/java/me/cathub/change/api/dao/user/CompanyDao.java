package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.user.bean.Company;

public interface CompanyDao extends BaseDao<Company> {
    String NAME_SPACE = "me.cathub.change.user.bean.Company";
}
