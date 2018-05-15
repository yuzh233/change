package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.user.Admin;

public interface AdminDao extends BaseDao<Admin>, DaoSelectByName<Admin> {
    String NAME_SPACE = "Admin";
}