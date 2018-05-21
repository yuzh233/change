package me.cathub.change.common.base;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用的Mybatis Dao抽象类
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public abstract class BaseDaoMyBatisImpl<Bean extends Serializable> implements BaseDao<Bean> {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    /**
     * 插入数据
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              执行结果
     */
    protected final boolean insert(String nameSpace, Bean bean) {
        return sqlSessionTemplate.insert(nameSpace + INSERT, bean) > 0;
    }

    /**
     * 删除数据(逻辑)
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              执行结果
     */
    protected final boolean deleteL(String nameSpace, Bean bean) {
        return sqlSessionTemplate.delete(nameSpace + DELETE_L, bean) > 0;
    }

    /**
     * 恢复数据
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              执行结果
     */
    protected final boolean restore(String nameSpace, Bean bean) {
        return sqlSessionTemplate.update(nameSpace + RESTORE, bean) > 0;
    }

    /**
     * 删除数据(物理)
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              执行结果
     */
    protected final boolean deleteP(String nameSpace, Bean bean) {
        return sqlSessionTemplate.delete(nameSpace + DELETE_P, bean) > 0;
    }

    /**
     * 更新数据
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              执行结果
     */
    protected final boolean update(String nameSpace, Bean bean) {
        return sqlSessionTemplate.update(nameSpace + UPDATE, bean) > 0;
    }

    /**
     * 查询数据
     * @param nameSpace     Mapper
     * @param bean          Java bean
     * @return              Java bean
     */
    protected final Bean select(String nameSpace, Bean bean) {
        return sqlSessionTemplate.selectOne(nameSpace + SELECT, bean);
    }

    /**
     * 分页查询全部数据
     * @param nameSpace     Mapper
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              Java bean $$list
     */
    protected final List<Bean> list(String nameSpace, int page, int count, int tableIndex) {
        PageHelper.startPage(page, count);
        return sqlSessionTemplate.selectList(nameSpace + LIST, tableIndex);
    }

    /**
     * 查询全部数据数量
     * @param nameSpace     Mapper
     * @param tableIndex    表索引
     * @return              Java bean $count
     */
    protected final int count(String nameSpace, int tableIndex) {
        return sqlSessionTemplate.selectOne(nameSpace + COUNT, tableIndex);
    }

    /**
     * 查询逻辑删除的数据列表
     * @param nameSpace     Mapper
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              Java bean $$list
     */
    protected final List<Bean> listByDel(String nameSpace, int page, int count, int tableIndex) {

        return sqlSessionTemplate.selectList(nameSpace + LIST_BY_DEL, tableIndex);
    }

    /**
     * 查询逻辑删除的数据数量
     * @param nameSpace     Mapper
     * @param tableIndex    表索引
     * @return              Java bean $count
     */
    protected final int countByDel(String nameSpace, int tableIndex) {
        return sqlSessionTemplate.selectOne(nameSpace + COUNT_BY_DEL, tableIndex);
    }

    /**
     * 清空垃圾(已被逻辑删除的)数据
     * @param nameSpace     Mapper
     * @param tableIndex    表索引
     * @return              影响行数
     */
    protected final int clear(String nameSpace, int tableIndex) {
        return sqlSessionTemplate.delete(nameSpace + CLEAR, tableIndex);
    }

    /**
     * 通用的列表查询
     * @param nameSpace     Mapper
     * @param page          当前页
     * @param count         页数量
     * @param params        参数Map
     * @return              Java bean list
     */
    protected final List<Bean> baseList(String nameSpace, int page, int count, Map<String, Object> params) {
        PageHelper.startPage(page, count);
        return sqlSessionTemplate.selectList(nameSpace, params);
    }

    /**
     * 通用的数量查询
     * @param nameSpace     Mapper
     * @param params        参数Map
     * @return              Java bean count
     */
    protected final int baseCount(String nameSpace, Map<String, Object> params) {
        return sqlSessionTemplate.selectOne(nameSpace, params);
    }

    /**
     * 搜索
     * @param nameSpace     Mapper
     * @param params        参数Map
     * @return              Java bean
     */
    protected final Bean searchOne(String nameSpace, Map<String, Object> params) {
        return sqlSessionTemplate.selectOne(nameSpace, params);
    }

    /**
     * 搜索
     * @param nameSpace     Mapper
     * @param params        参数Map
     * @return              Java bean
     */
    protected final List<Bean> searchList(String nameSpace, int page, int count, Map<String, Object> params) {
        PageHelper.startPage(page, count);
        return sqlSessionTemplate.selectList(nameSpace, params);
    }
}
