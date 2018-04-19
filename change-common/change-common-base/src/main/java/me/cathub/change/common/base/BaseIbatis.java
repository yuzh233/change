package me.cathub.change.common.base;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseIbatis<T extends Serializable> implements BaseDao<T> {
    private static final String SET_ID = "setId";

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    protected boolean insert(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.insert(namespace + INSERT, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected boolean deleteL(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.delete(namespace + DELETE_L, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected boolean restore(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.update(namespace + RESTORE, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected boolean deleteP(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.delete(namespace + DELETE_P, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected boolean update(String namespace, T bean) throws Exception {
        boolean flag = true;
        try {
            flag = sqlSessionTemplate.update(namespace + UPDATE, bean) > 0 ? flag : false;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    protected T select(String namespace, T bean) throws Exception {
        T result = null;
        try {
            result = sqlSessionTemplate.selectOne(namespace + SELECT, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    protected List<T> list(String namespace, int page, int count, int tableIndex) throws Exception {
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

    protected long count(String namespace, int tableIndex) throws Exception {
        long count = 0;
        try {
            count = sqlSessionTemplate.selectOne(namespace + COUNT, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    protected long clear(String namespace, int tableIndex) throws Exception {
        long count = 0;
        try {
            count = sqlSessionTemplate.delete(namespace + CLEAR, tableIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
