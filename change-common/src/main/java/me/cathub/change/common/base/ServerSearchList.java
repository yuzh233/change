package me.cathub.change.common.base;

import java.util.List;

/**
 * 搜索列表
 *
 * @author cheng
 */
public interface ServerSearchList<Bean> {

    /**
     * 根据名称搜索
     * @param name
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Bean> listByName(String name, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据名称搜索
     * @param name
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByName(String name, int tableIndex) throws Exception;
}
