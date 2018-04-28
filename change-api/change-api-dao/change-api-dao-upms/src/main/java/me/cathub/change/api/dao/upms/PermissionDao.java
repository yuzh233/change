package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.upms.bean.Permission;

import java.util.List;

public interface PermissionDao extends BaseDao<Permission>, DaoSelectByName<Permission> {
    String NAME_SPACE = "me.cathub.change.upms.bean.Permission";

    String LIST_BY_ROLE_ID = ".listByRoleId";
    String COUNT_BY_ROLE_ID = ".countByRoleId";

    /**
     * 根据角色获取权限列表
     * @param role_id 角色id
     * @return
     */
    List<Permission> listByRoleId(long role_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据角色获取权限数量
     * @param role_id
     * @return
     * @throws Exception
     */
    int countByRoleId(long role_id, int tableIndex) throws Exception;
}
