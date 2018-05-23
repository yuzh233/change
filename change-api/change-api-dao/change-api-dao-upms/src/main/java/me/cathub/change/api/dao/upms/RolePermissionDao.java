package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.upms.bean.RolePermission;

import java.util.List;

/**
 * 角色权限Dao接口
 *
 * @author cheng
 */
public interface RolePermissionDao extends BaseDao<RolePermission> {
    String NAME_SPACE = "RolePermission";

    String LIST_BY_ROLE_ID_AND_APPLY_ID = ".listByRoleIdAndApplyId";
    String COUNT_BY_ROLE_ID_AND_APPLY_ID = ".countByRoleIdAndApplyId";
    String LIST_BY_ROLE_ID = ".listByRoleId";
    String COUNT_BY_ROLE_ID = ".countByRoleId";
    String LIST_BY_APPLY_ID = ".listByApplyId";
    String COUNT_BY_APPLY_ID = ".countByApplyId";

    /**
     * 根据角色和应用查询权限列表
     * @param roleId
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<RolePermission> listByRoleIdAndApplyId(long roleId, long applyId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据角色和应用查询权限数量
     * @param roleId
     * @param applyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleIdAndApplyId(long roleId, long applyId, int tableIndex) throws Exception;

    /**
     * 根据角色查询权限列表
     * @param roleId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<RolePermission> listByRoleId(long roleId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据角色查询权限数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;

    /**
     * 根据应用查询权限列表
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<RolePermission> listByApplyId(long applyId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据应用查询权限数量
     * @param applyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByApplyId(long applyId, int tableIndex) throws Exception;
}
