package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 品牌商账户Dao实现类
 *
 * @author cheng
 */
@Repository
public class BrandQuotientDaoImpl extends BaseDaoMyBatisImpl<BrandQuotient> implements BrandQuotientDao {

    @Override
    public boolean insert(BrandQuotient bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(BrandQuotient bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(BrandQuotient bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(BrandQuotient bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(BrandQuotient bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public BrandQuotient select(BrandQuotient bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<BrandQuotient> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<BrandQuotient> listByDel(int page, int count, int tableIndex) throws Exception {
        return listByDel(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return countByDel(NAME_SPACE, tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public BrandQuotient selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }

    @Override
    public List<BrandQuotient> listByCompanyId(long companyId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_COMPANY_ID, page, count, map);
    }

    @Override
    public int countByCompanyId(long companyId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_COMPANY_ID, map);
    }
}
