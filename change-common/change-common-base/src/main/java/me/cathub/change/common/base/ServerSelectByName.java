package me.cathub.change.common.base;

public interface ServerSelectByName<T> {
    T selectByName(String name, int tableIndex, boolean flag) throws Exception;
}
