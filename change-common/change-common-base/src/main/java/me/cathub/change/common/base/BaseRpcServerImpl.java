package me.cathub.change.common.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: z.yu
 * DateTime: 2018-04-28 19:45
 * Description:
 */
public class BaseRpcServerImpl<T,E> implements BaseRpcServer<T> {
    /**
     * 插入数据
     *
     * @param bean
     * @return long success id error -1
     * @throws Exception
     */
    @Override
    public long insert(T bean) throws Exception {
        return 0;
    }

    /**
     * 删除数据(逻辑)
     *
     * @param bean
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteL(T bean) throws Exception {
        return false;
    }

    /**
     * 恢复数据
     *
     * @param bean
     * @return
     * @throws Exception
     */
    @Override
    public boolean restore(T bean) throws Exception {
        return false;
    }

    /**
     * 删除数据(物理)
     *
     * @param bean
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteP(T bean) throws Exception {
        return false;
    }

    /**
     * 更新数据
     *
     * @param bean
     * @return
     * @throws Exception
     */
    @Override
    public boolean update(T bean) throws Exception {
        return false;
    }

    /**
     * 查询数据(ID)
     *
     * @param bean
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public T select(T bean, boolean flag) throws Exception {
        return null;
    }

    /**
     * 全部数据(分页)
     *
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public List<T> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        return null;
    }

    /**
     * 全部数量
     *
     * @param tableIndex
     * @return
     * @throws Exception
     */
    @Override
    public int count(int tableIndex) throws Exception {
        return 0;
    }

    /**
     * 返回已被逻辑删除的数据的列表
     *
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public List<T> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        return null;
    }


    /**
     * 返回以被逻辑删除的数据的数量
     *
     * @param tableIndex
     * @return
     * @throws Exception
     */
    @Override
    public int countByDel(int tableIndex) throws Exception {
        return 0;
    }

    /**
     * 清空垃圾数据(已被逻辑删除的数据)
     *
     * @param tableIndex
     * @return
     * @throws Exception
     */
    @Override
    public int clear(int tableIndex) throws Exception {
        return 0;
    }
}
