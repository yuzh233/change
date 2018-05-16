package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.upms.bean.Permission;

import java.util.List;

/**
 * 授权Dao接口
 *
 * @author cheng
 */
public interface PermissionDao extends BaseDao<Permission>, DaoSelectByName<Permission> {
    String NAME_SPACE = "Permission";

    String LIST_BY_ROLE_ID = ".listByRoleId";
    String COUNT_BY_ROLE_ID = ".countByRoleId";

    /**
     * 根据角色获取权限列表
     * @param roleId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Permission> listByRoleId(long roleId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据角色获取权限数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;
}
