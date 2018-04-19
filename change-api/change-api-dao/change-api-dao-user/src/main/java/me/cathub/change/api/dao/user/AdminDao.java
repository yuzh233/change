package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.user.bean.Admin;

public interface AdminDao extends BaseDao<Admin>, LoginInterface<Admin> {
    String NAME_SPACE = "me.cathub.change.user.bean.Admin";
}