package me.cathub.change.common.base;

public interface SelectByName<T> {
    String SELECT_BY_NAME = ".selectByName";

    T selectByName(String name, int tableIndex) throws Exception;
}
