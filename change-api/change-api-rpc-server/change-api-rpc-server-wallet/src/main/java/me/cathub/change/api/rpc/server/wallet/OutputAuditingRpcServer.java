package me.cathub.change.api.rpc.server.wallet;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.wallet.bean.OutputAuditing;

import java.util.List;

/**
 * 提现审核 Rpc 服务接口
 * @author cheng
 * @date 2018/5/28
 * @time 17:50
 */
public interface OutputAuditingRpcServer extends BaseRpcServer<OutputAuditing> {

    /**
     * 根据管理员和类型获取提现审核记录列表
     * @param adminId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<OutputAuditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据管理员和类型获取提现审核记录数量
     * @param adminId
     * @param type 用户类型
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
    List<OutputAuditing> listByNotAuditing(int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据用户类型获取未审核的数量
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByNotAuditing(int type, int tableIndex) throws Exception;

    /**
     * 根据用户id和用户类型获取提现审核记录列表
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<OutputAuditing> listByUserIdAndUserType(long userId, int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据用户id和用户类型获取提现审核记录数量
     * @param userId
     * @param type
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByUserIdAndUserType(long userId, int type, int tableIndex) throws Exception;
}
