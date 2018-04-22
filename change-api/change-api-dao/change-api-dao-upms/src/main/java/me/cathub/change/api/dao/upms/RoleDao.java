package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.upms.bean.Role;

public interface RoleDao extends BaseCrud<Role>, SelectByName<Role> {
    String NAME_SPACE = "me.cathub.change.upms.bean.Role";
}
