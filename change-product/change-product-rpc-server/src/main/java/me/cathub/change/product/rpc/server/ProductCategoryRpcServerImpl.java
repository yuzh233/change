package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductCategoryDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryRpcServerImpl implements ProductCategoryRpcServer {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(ProductCategory bean) throws Exception {
        bean.setId(sequence.nextId());
        return productCategoryDao.insert(bean);
    }

    @Override
    public boolean deleteL(ProductCategory bean) throws Exception {
        return productCategoryDao.deleteL(bean);
    }

    @Override
    public boolean restore(ProductCategory bean) throws Exception {
        return productCategoryDao.restore(bean);
    }

    @Override
    public boolean deleteP(ProductCategory bean) throws Exception {
        return productCategoryDao.deleteP(bean);
    }

    @Override
    public boolean update(ProductCategory bean) throws Exception {
        return productCategoryDao.update(bean);
    }

    @Override
    public ProductCategory select(ProductCategory bean) throws Exception {
        return productCategoryDao.select(bean);
    }

    @Override
    public List<ProductCategory> list(int page, int count, int tableIndex) throws Exception {
        return productCategoryDao.list(page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return productCategoryDao.count(tableIndex);
    }

    @Override
    public List<ProductCategory> listByDel(int page, int count, int tableIndex) throws Exception {
        return productCategoryDao.listByDel(page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return productCategoryDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return productCategoryDao.clear(tableIndex);
    }

    @Override
    public ProductCategory selectByName(String name, int tableIndex) throws Exception {
        return productCategoryDao.selectByName(name, tableIndex);
    }

    @Override
    public List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception {
        return productCategoryDao.childListById(id, page, count, tableIndex);
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        return productCategoryDao.childCountById(id, tableIndex);
    }
}
