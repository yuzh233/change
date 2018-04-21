package me.cathub.change.common.base;

import java.util.List;

public interface BaseRpcServer<T> {
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
     * 删除数据(物理)
     * @param bean
     * @return
     * @throws Exception
     */
    boolean deleteP(T bean) throws Exception;

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
    List<T> list(int page, int count, int tableIndex) throws Exception;

    /**
     * 全部数量
     * @return
     * @throws Exception
     */
    long count(int tableIndex) throws Exception;

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     * @return
     * @throws Exception
     */
    long clear(int tableIndex) throws Exception;
}
