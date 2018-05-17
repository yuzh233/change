package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.upms.bean.Permission;

import java.util.List;

/**
 * 授权Rpc服务接口
 *
 * @author cheng
 */
public interface PermissionRpcServer extends BaseRpcServer<Permission>, ServerSelectByName<Permission> {

    /**
     * 根据应用查询权限列表
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Permission> listByApplyId(long applyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据应用id查询权限数量
     * @param applyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByApplyId(long applyId, int tableIndex) throws Exception;

    /**
     * 根据当前id获取子权限列表
     * @param id
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Permission> childListById(long id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     *根据当前id获取子权限数量
     * @param id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}