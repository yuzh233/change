package me.cathub.change.common.base;

/**
 * Server 层, 根据名称查找的接口
 * @param <T>
 */
public interface ServerSelectByName<T> {
    T selectByName(String name, int tableIndex, boolean flag) throws Exception;
}
