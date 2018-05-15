package me.cathub.change.common.base;

/**
 * Dao 层, 根据名称查找的接口
 * @param <T>
 */
public interface DaoSelectByName<T> {
    String SELECT_BY_NAME = ".selectByName";

    T selectByName(String name, int tableIndex) throws Exception;
}
