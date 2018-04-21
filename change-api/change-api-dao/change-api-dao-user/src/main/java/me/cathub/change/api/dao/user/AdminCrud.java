package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.user.bean.Admin;

public interface AdminCrud extends BaseCrud<Admin>, LoginInterface<Admin> {
    String NAME_SPACE = "me.cathub.change.user.bean.Admin";
}