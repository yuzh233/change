package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.user.bean.Company;

public interface CompanyDao extends BaseCrud<Company>, SelectByName<Company> {
    String NAME_SPACE = "me.cathub.change.user.bean.Company";
}
