package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.upms.bean.UserRole;

import java.util.List;

/**
 * 用户角色Dao接口
 *
 * @author cheng
 */
public interface UserRoleDao extends BaseDao<UserRole> {
    String NAME_SPACE = "UserRole";

    String LIST_BY_USER_ID = ".listByUserId";
    String COUNT_BY_USER_ID = ".countByUserId";
    String LIST_BY_ROLE_ID = ".listByRoleId";
    String COUNT_BY_ROLE_ID = ".countByRoleId";

    /**
     * 根据用户查询角色列表
     * @param userId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<UserRole> listByUserId(long userId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据用户查询角色数量
     * @param userId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByUserId(long userId, int tableIndex) throws Exception;

    /**
     * 根据角色查询用户列表
     * @param roleId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<UserRole> listByRoleId(long roleId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据角色查询用户数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;
}
