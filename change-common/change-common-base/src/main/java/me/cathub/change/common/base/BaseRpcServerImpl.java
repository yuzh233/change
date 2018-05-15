package me.cathub.change.common.base;

import me.cathub.change.common.tool.Sequence;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 通用的RpcServer抽象类
 * @param <B>
 * @param <D>
 */
public abstract class BaseRpcServerImpl<B extends Serializable, D extends BaseDao<B>> implements BaseRpcServer<B>, FillAssociationDate<B> {

    private static final String SET_ID = "setId";

    @Autowired
    protected D dao;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(B bean) throws Exception {
        Long id = sequence.nextId();

        Class<? extends Serializable> clazz = bean.getClass();
        Method method = clazz.getMethod(SET_ID, long.class);
        method.invoke(bean, id);

        dao.insert(bean);

        return id;
    }

    @Override
    public boolean deleteL(B bean) throws Exception {
        return dao.deleteL(bean);
    }

    @Override
    public boolean restore(B bean) throws Exception {
        return dao.restore(bean);
    }

    @Override
    public boolean deleteP(B bean) throws Exception {
        return dao.deleteP(bean);
    }

    @Override
    public boolean update(B bean) throws Exception {
        return dao.update(bean);
    }

    @Override
    public B select(B bean, boolean flag) throws Exception {
        if (flag)
            return dao.select(bean);
        else
            return fill(dao.select(bean));
    }

    @Override
    public List<B> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.list(page, count, tableIndex);
        else
            return dao.list(page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return dao.count(tableIndex);
    }

    @Override
    public List<B> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByDel(page, count, tableIndex);
        else
            return dao.listByDel(page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return dao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return dao.clear(tableIndex);
    }

    @Override
    public int restores(long[] ids, B bean) throws Exception {
        Class<? extends Serializable> clazz = bean.getClass();
        for (long id:ids) {
            clazz.getMethod(SET_ID, long.class).invoke(bean, id);
            dao.restore(bean);
        }
        return ids.length;
    }

    @Override
    public int deletes(long[] ids, B bean, boolean del_flag) throws Exception {
        Class<? extends Serializable> clazz = bean.getClass();
        if (del_flag)
            for (long id:ids) {
                clazz.getMethod(SET_ID, long.class).invoke(bean, id);
                dao.deleteL(bean);
            }
        else
            for (long id:ids) {
                clazz.getMethod(SET_ID, long.class).invoke(bean, id);
                dao.deleteP(bean);
            }
        return ids.length;
    }
}
