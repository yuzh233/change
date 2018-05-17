package me.cathub.change.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 通用Dao接口
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public interface BaseDao<Bean extends Serializable> {

    /**
     * Mybatis base mappers
     */
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
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    boolean insert(Bean bean) throws Exception;

    /**
     * 删除数据(逻辑)
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    boolean deleteL(Bean bean) throws Exception;

    /**
     * 恢复数据
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    boolean restore(Bean bean) throws Exception;
    
    /**
     * 删除数据(物理)
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    boolean deleteP(Bean bean) throws Exception;

    /**
     * 更新数据
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    boolean update(Bean bean) throws Exception;

    /**
     * 查询数据(ID)
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Sql throw Exception
     */
    Bean select(Bean bean) throws Exception;

    /**
     * 全部数据(分页)
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              Java bean $$list
     * @throws Exception    Sql throw Exception
     */
    List<Bean> list(int page, int count, int tableIndex) throws Exception;

    /**
     * 全部数量
     * @param tableIndex    表索引
     * @return              Java bean $count
     * @throws Exception    Sql throw Exception
     */
    int count(int tableIndex) throws Exception;

    /**
     * 返回已被逻辑删除的数据的列表
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              Java bean $$list
     * @throws Exception    Sql throw Exception
     */
    List<Bean> listByDel(int page, int count, int tableIndex) throws Exception;

    /**
     * 返回以被逻辑删除的数据的数量
     * @param tableIndex    表索引
     * @return              Java bean $count
     * @throws Exception    Sql throw Exception
     */
    int countByDel(int tableIndex) throws Exception;

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     * @param tableIndex    表索引
     * @return              影响行数
     * @throws Exception    Sql throw Exception
     */
    int clear(int tableIndex) throws Exception;
}
