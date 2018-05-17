package me.cathub.change.api.dao.upms;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.upms.bean.Apply;

/**
 * 应用Dao接口
 *
 * @author cheng
 */
public interface ApplyDao extends BaseDao<Apply>, DaoSelectByName<Apply> {
    String NAME_SPACE = "Apply";
}
