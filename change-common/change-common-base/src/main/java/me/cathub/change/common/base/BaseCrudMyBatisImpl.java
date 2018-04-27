package me.cathub.change.common.base;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseCrudMyBatisImpl<T extends Serializable> implements BaseCrud<T> {
    private static final String SET_ID = "setId";

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    protected final boolean insert(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.insert(namespace + INSERT, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected final boolean deleteL(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.delete(namespace + DELETE_L, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected final boolean restore(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.update(namespace + RESTORE, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected final boolean deleteP(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.delete(namespace + DELETE_P, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected final boolean update(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.update(namespace + UPDATE, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected final T select(String namespace, T bean) throws Exception {
        T result = null;
        try {
            result = sqlSessionTemplate.selectOne(namespace + SELECT, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    protected final List<T> list(String namespace, int page, int count, int tableIndex) throws Exception {
        List<T> results = null;
        try {
            // 分页
            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(namespace + LIST, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    protected final int count(String namespace, int tableIndex) throws Exception {
        int count = 0;
        try {
            count = sqlSessionTemplate.selectOne(namespace + COUNT, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    protected final List<T> listByDel(String namespace, int page, int count, int tableIndex) throws Exception {
        List<T> results = null;
        try {
            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(namespace + LIST_BY_DEL, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    protected final int countByDel(String namespace, int tableIndex) throws Exception {
        int count = 0;
        try {
            count = sqlSessionTemplate.selectOne(namespace + COUNT_BY_DEL, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    protected final int clear(String namespace, int tableIndex) throws Exception {
        int count = 0;
        try {
            count = sqlSessionTemplate.delete(namespace + CLEAR, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
