package me.cathub.change.common.base;

import me.cathub.change.common.util.key.Sequence;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 通用的RpcServer抽象类
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 * @param <Dao> Dao
 */
public abstract class BaseRpcServerImpl<Bean extends Serializable, Dao extends BaseDao<Bean>> implements BaseRpcServer<Bean> {

    private static final String SET_ID = "setId";

    @Autowired
    protected Dao dao;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(Bean bean) throws Exception {
        long id = sequence.nextId();

        Class<? extends Serializable> clazz = bean.getClass();
        Method method = clazz.getMethod(SET_ID, long.class);
        method.invoke(bean, id);

        dao.insert(bean);

        return id;
    }

    @Override
    public boolean deleteL(Bean bean) throws Exception {
        return dao.deleteL(bean);
    }

    @Override
    public boolean restore(Bean bean) throws Exception {
        return dao.restore(bean);
    }

    @Override
    public boolean deleteP(Bean bean) throws Exception {
        return dao.deleteP(bean);
    }

    @Override
    public boolean update(Bean bean) throws Exception {
        return dao.update(bean);
    }

    @Override
    public Bean select(Bean bean, boolean flag) throws Exception {
        if (flag) {
            return dao.select(bean);
        } else {
            return fill(dao.select(bean));
        }
    }

    @Override
    public List<Bean> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.list(page, count, tableIndex);
        } else {
            return dao.list(page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return dao.count(tableIndex);
    }

    @Override
    public List<Bean> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByDel(page, count, tableIndex);
        } else {
            return dao.listByDel(page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
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
    public int restores(long[] ids, Bean bean) throws Exception {
        Class<? extends Serializable> clazz = bean.getClass();
        for (long id : ids) {
            clazz.getMethod(SET_ID, long.class).invoke(bean, id);
            dao.restore(bean);
        }
        return ids.length;
    }

    @Override
    public int deletes(long[] ids, Bean bean, boolean delFlag) throws Exception {
        Class<? extends Serializable> clazz = bean.getClass();
        if (delFlag) {
            for (long id : ids) {
                clazz.getMethod(SET_ID, long.class).invoke(bean, id);
                dao.deleteL(bean);
            }
        } else {
            for (long id : ids) {
                clazz.getMethod(SET_ID, long.class).invoke(bean, id);
                dao.deleteP(bean);
            }
        }
        return ids.length;
    }
}
