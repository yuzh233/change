package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Auditing;

import java.util.List;

/**
 * 入驻申请Rpc服务接口
 *
 * @author cheng
 */
public interface AuditingRpcServer extends BaseRpcServer<Auditing> {

    /**
     * 根据管理员和类型获取审核列表
     * @param adminId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Auditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据管理员和类型获取审核数量
     * @param adminId
     * @param type
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByAdminIdAndUserType(long adminId, int type, int tableIndex) throws Exception;

    /**
     * 根据用户类型获取未审核的列表
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据用户类型获取未审核的数量
     * @param type
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByNotAuditing(int type, int tableIndex) throws Exception;
}
