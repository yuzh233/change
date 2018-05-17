package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.user.bean.Admin;

/**
 * 管理员Dao接口
 *
 * @author cheng
 */
public interface AdminDao extends BaseDao<Admin>, DaoSelectByName<Admin> {
    String NAME_SPACE = "Admin";
}