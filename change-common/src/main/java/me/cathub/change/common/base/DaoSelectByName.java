package me.cathub.change.common.base;

import java.util.List;

/**
 * Dao 层, 根据名称查找的接口
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public interface DaoSelectByName<Bean> {
    String SELECT_BY_NAME = ".selectByName";

    /**
     * 根据名称查找
     * @param name
     * @param tableIndex
     * @return
     * @throws Exception
     */
    Bean selectByName(String name, int tableIndex) throws Exception;
}
