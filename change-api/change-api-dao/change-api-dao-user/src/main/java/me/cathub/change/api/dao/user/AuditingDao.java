package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.user.bean.Auditing;

import java.util.List;

/**
 * 入驻审核Dao接口
 *
 * @author cheng
 */
public interface AuditingDao extends BaseDao<Auditing> {
    String NAME_SPACE = "Auditing";

    String LIST_BY_ADMIN_AND_TYPE = ".listByAdminIdAndUserType";
    String COUNT_BY_ADMIN_AND_TYPE = ".countByAdminIdAndUserType";
    String LIST_BY_NOT_AUDITING = ".listByNotAuditing";
    String COUNT_BY_NOT_AUDITING = ".countByNotAuditing";

    /**
     * 根据管理员和类型获取审核列表
     * @param adminId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Auditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据管理员和类型获取审核数量
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
    List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据用户类型获取未审核的数量
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByNotAuditing(int type, int tableIndex) throws Exception;
}
