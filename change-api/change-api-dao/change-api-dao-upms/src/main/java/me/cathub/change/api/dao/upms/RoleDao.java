package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.upms.bean.Role;

public interface RoleDao extends BaseDao<Role>, DaoSelectByName<Role> {
    String NAME_SPACE = "me.cathub.change.upms.bean.Role";
}
