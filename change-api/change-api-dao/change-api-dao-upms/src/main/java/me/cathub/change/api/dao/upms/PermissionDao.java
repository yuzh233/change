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

    String LIST_BY_APPLY_ID = ".listByApplyId";
    String COUNT_BY_APPLY_ID = ".countByApplyId";
    String CHILD_LIST_BY_ID = ".childListById";
    String CHILD_COUNT_BY_ID = ".childCountById";

    /**
     * 根据应用查询权限列表
     * @param applyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Permission> listByApplyId(long applyId, int page, int count, int tableIndex) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<Permission> childListById(long id, int page, int count, int tableIndex) throws Exception;

    /**
     *根据当前id获取子权限数量
     * @param id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}
