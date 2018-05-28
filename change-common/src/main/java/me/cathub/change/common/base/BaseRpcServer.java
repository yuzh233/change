package me.cathub.change.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的RpcServer接口
 *
 * @author cheng
 * <p/>
 * @param <Bean>
 */
public interface BaseRpcServer<Bean extends Serializable> extends FillAssociationDate<Bean> {

    /**
     * 插入数据
     * @param bean
     * @return long success id error -1
     * @throws Exception
     */
    long insert(Bean bean) throws Exception;

    /**
     * 删除数据(逻辑)
     * @param bean
     * @return
     * @throws Exception
     */
    boolean deleteL(Bean bean) throws Exception;

    /**
     * 恢复数据
     * @param bean
     * @return
     * @throws Exception
     */
    boolean restore(Bean bean) throws Exception;

    /**
     * 批量恢复数据
     * @param ids
     * @param bean
     * @return
     * @throws Exception
     */
    int restores(long[] ids, Bean bean) throws Exception;

    /**
     * 批量删除数据
     * @param ids
     * @param bean
     * @param delFlag
     * @return
     * @throws Exception
     */
    int deletes(long[] ids, Bean bean, boolean delFlag) throws Exception;

    /**
     * 删除数据(物理)
     * @param bean
     * @return
     * @throws Exception
     */
    boolean deleteP(Bean bean) throws Exception;

    /**
     * 更新数据
     * @param bean
     * @return
     * @throws Exception
     */
    boolean update(Bean bean) throws Exception;

    /**
     * 查询数据(ID)
     * @param bean
     * @param flag
     * @return
     * @throws Exception
     */
    Bean select(Bean bean, boolean flag) throws Exception;

    /**
     * 全部数据(分页)
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Bean> list(int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 全部数量
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int count(int tableIndex) throws Exception;

    /**
     * 返回已被逻辑删除的数据的列表
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Bean> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 返回以被逻辑删除的数据的数量
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByDel(int tableIndex) throws Exception;

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int clear(int tableIndex) throws Exception;
}
