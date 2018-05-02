package me.cathub.change.common.base;

import java.util.Map;

public interface BaseController<T> {
    boolean DEL_FLAG_L = true;
    boolean DEL_FLAG_P = false;

    /**
     * 插入数据
     * @param bean
     * @return
     * @throws Exception
     */
    boolean insert(T bean) throws Exception;

    /**
     * 删除数据(逻辑)
     * @param bean
     * @return
     * @throws Exception
     */
    boolean deleteL(T bean) throws Exception;

    /**
     * 恢复数据
     * @param bean
     * @return
     * @throws Exception
     */
    boolean restore(T bean) throws Exception;

    /**
     * 批量恢复数据
     * @param ids
     * @return
     * @throws Exception
     */
    int restores(long[] ids) throws Exception;

    /**
     * 删除数据(物理)
     * @param bean
     * @return
     * @throws Exception
     */
    boolean deleteP(T bean) throws Exception;

    /**
     * 批量删除
     * @param ids
     * @param del_flag true 逻辑删除 false 物理删除
     * @return
     * @throws Exception
     */
    int deletes(long[] ids, boolean del_flag) throws Exception;

    /**
     * 更新数据
     * @param bean
     * @return
     * @throws Exception
     */
    boolean update(T bean) throws Exception;

    /**
     * 查询数据(ID)
     * @param bean
     * @return
     * @throws Exception
     */
    T select(T bean) throws Exception;

    /**
     * 全部数据(分页)
     * @return
     * @throws Exception
     */
    PageResult list(int page, int count, int tableIndex) throws Exception;

    /**
     * 全部数量
     * @return
     * @throws Exception
     */
    int count(int tableIndex) throws Exception;

    /**
     * 返回已被逻辑删除的数据的列表
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    PageResult listByDel(int page, int count, int tableIndex) throws Exception;

    /**
     * 返回以被逻辑删除的数据的数量
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByDel(int tableIndex) throws Exception;

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     * @return
     * @throws Exception
     */
    int clear(int tableIndex) throws Exception;

    /**
     * 数据回显
     * @param id
     * @param map
     * @throws Exception
     */
    void update_modelAttribute(Long id, Map<String, Object> map) throws Exception;
}
