package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductCategoryCrud;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryCrudImpl extends BaseCrudMyBatisImpl<ProductCategory> implements ProductCategoryCrud {

    @Override
    public boolean insert(ProductCategory bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(ProductCategory bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(ProductCategory bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(ProductCategory bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(ProductCategory bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public ProductCategory select(ProductCategory bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<ProductCategory> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }
}
