package me.cathub.change.common.base;

import java.util.List;

/**
 * 搜索列表
 *
 * @author cheng
 */
public interface DaoSearchList<Bean> {
    String LIST_BY_NAME = ".listByName";
    String COUNT_BY_NAME = ".countByName";


    /**
     * 根据名称搜索
     * @param name
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Bean> listByName(String name, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据名称搜索
     * @param name
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByName(String name, int tableIndex) throws Exception;
}
