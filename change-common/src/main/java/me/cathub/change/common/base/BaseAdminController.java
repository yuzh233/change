package me.cathub.change.common.base;

import me.cathub.change.common.bean.PageResult;

import java.util.Map;

/**
 * 通用的后台管理控制器接口
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public interface BaseAdminController<Bean> {

    /**
     * 逻辑删除标识
     */
    boolean DEL_FLAG_L = true;

    /**
     * 物理删除标识
     */
    boolean DEL_FLAG_P = false;

    /**
     * 插入数据
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Controller throw exception
     */
    boolean insert(Bean bean) throws Exception;

    /**
     * 删除数据(逻辑)
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Controller throw exception
     */
    boolean deleteL(Bean bean) throws Exception;

    /**
     * 恢复数据
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Controller throw exception
     */
    boolean restore(Bean bean) throws Exception;

    /**
     * 批量恢复数据
     * @param ids           Java bean ids
     * @return              影响行数
     * @throws Exception    Controller throw exception
     */
    int restores(long[] ids) throws Exception;

    /**
     * 删除数据(物理)
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Controller throw exception
     */
    boolean deleteP(Bean bean) throws Exception;

    /**
     * 批量删除
     * @param ids           Java bean ids
     * @param delFlag       DEL_FLAG_L(逻辑) / DEL_FLAG_P(物理)
     * @return              影响行数
     * @throws Exception    Controller throw exception
     */
    int deletes(long[] ids, boolean delFlag) throws Exception;

    /**
     * 更新数据
     * @param bean          Java bean
     * @return              执行结果
     * @throws Exception    Controller throw exception
     */
    boolean update(Bean bean) throws Exception;

    /**
     * 查询数据(ID)
     * @param bean          Java bean
     * @return              Java bean
     * @throws Exception    Controller throw exception
     */
    Bean select(Bean bean) throws Exception;

    /**
     * 全部数据(分页)
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              PageResult
     * @throws Exception    Controller throw exception
     */
    PageResult list(int page, int count, int tableIndex) throws Exception;

    /**
     * 全部数量
     * @param tableIndex    表索引
     * @return              Java bean $count
     * @throws Exception    Controller throw exception
     */
    int count(int tableIndex) throws Exception;

    /**
     * 返回已被逻辑删除的数据的列表
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              PageResult
     * @throws Exception    Controller throw exception
     */
    PageResult listByDel(int page, int count, int tableIndex) throws Exception;

    /**
     * 返回以被逻辑删除的数据的数量
     * @param tableIndex    表索引
     * @return              Java bean $count
     * @throws Exception    Controller throw exception
     */
    int countByDel(int tableIndex) throws Exception;

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     * @param tableIndex    表索引
     * @return              影响行数
     * @throws Exception    Controller throw exception
     */
    int clear(int tableIndex) throws Exception;

    /**
     * 数据回显
     * @param id            Java bean id
     * @param map           回显容器
     * @throws Exception    Controller throw exception
     */
    void updateModelAttribute(Long id, Map<String, Object> map) throws Exception;
}
