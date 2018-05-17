package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.upms.bean.UserRole;

import java.util.List;

/**
 * 用户角色Rpc服务接口
 *
 * @author cheng
 */
public interface UserRoleRpcServer extends BaseRpcServer<UserRole> {

    /**
     * 根据用户查询角色列表
     * @param userId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<UserRole> listByUserId(long userId, int page, int count, int tableIndex, boolean flag) throws Exception;

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
     * @param flag
     * @return
     * @throws Exception
     */
    List<UserRole> listByRoleId(long roleId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据角色查询用户数量
     * @param roleId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByRoleId(long roleId, int tableIndex) throws Exception;
}
