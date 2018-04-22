package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.user.bean.Admin;

public interface AdminDao extends BaseCrud<Admin>, LoginInterface<Admin>, SelectByName<Admin> {
    String NAME_SPACE = "me.cathub.change.user.bean.Admin";
}