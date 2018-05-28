package me.cathub.change.api.dao.wallet;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.wallet.bean.OutputAuditing;

import java.util.List;

/**
 * 提现审核 Dao
 * @author cheng
 * @date 2018/5/27
 * @time 19:38
 */
public interface OutputAuditingDao extends BaseDao<OutputAuditing> {
    String NAME_SPACE = "OutputAuditing";

    String LIST_BY_ADMIN_AND_USER_TYPE = ".listByAdminIdAndUserType";
    String COUNT_BY_ADMIN_AND_USER_TYPE = ".countByAdminIdAndUserType";
    String LIST_BY_NOT_AUDITING = ".listByNotAuditing";
    String COUNT_BY_NOT_AUDITING = ".countByNotAuditing";
    String LIST_BY_USER_ID_AND_USER_TYPE = ".listByUserIdAndUserType";
    String COUNT_BY_USER_ID_AND_USER_TYPE = ".countByUserIdAndUserType";

    /**
     * 根据管理员和类型获取提现审核记录列表
     * @param adminId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<OutputAuditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<OutputAuditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<OutputAuditing> listByUserIdAndUserType(long userId, int type, int page, int count, int tableIndex) throws Exception;

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
