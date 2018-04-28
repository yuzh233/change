package me.cathub.change.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 通用Dao接口
 * @param <T> 具体Bean
 */
public interface BaseDao<T extends Serializable> {
    String INSERT = ".insert";
    String DELETE_L = ".deleteL";
    String DELETE_P = ".deleteP";
    String UPDATE = ".update";
    String SELECT = ".select";
    String LIST = ".list";
    String COUNT = ".count";
    String RESTORE = ".restore";
    String LIST_BY_DEL = ".listByDel";
    String COUNT_BY_DEL = ".countByDel";
    String CLEAR = ".clear";

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
    int count(int tableIndex) throws Exception;

    /**
     * 返回已被逻辑删除的数据的列表
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<T> listByDel(int page, int count, int tableIndex) throws Exception;

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
}
