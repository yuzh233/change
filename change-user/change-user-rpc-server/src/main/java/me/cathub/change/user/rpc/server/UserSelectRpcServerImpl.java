package me.cathub.change.user.rpc.server;

import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.common.bean.User;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户查询Rpc服务实现类:统一用户查询接口
 *
 * @author cheng
 */
@Service
public class UserSelectRpcServerImpl implements UserSelectRpcServer {

    @Autowired
    private AdminRpcServer adminRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public User select(long id, boolean flag, int tableIndex, int type) throws Exception {
        User result = null;
        switch (type) {
            case User.TYPE_ADMIN:
                Admin admin = new Admin(id);
                admin.setTableIndex(tableIndex);
                result = adminRpcServer.select(admin, flag);
                break;
            case User.TYPE_BRAND_QUOTIENT:
                BrandQuotient brandQuotient = new BrandQuotient(id);
                brandQuotient.setTableIndex(tableIndex);
                result = brandQuotientRpcServer.select(brandQuotient, flag);
                break;
            case User.TYPE_SHOPKEEPER:
                Shopkeeper shopkeeper = new Shopkeeper(id);
                shopkeeper.setTableIndex(tableIndex);
                result = shopkeeperRpcServer.select(shopkeeper, flag);
                break;
            default:
        }
        return result;
    }

    @Override
    public User selectByName(String name, int tableIndex, boolean flag, int type) throws Exception {
        User result = null;
        switch (type) {
            case User.TYPE_ADMIN:
                result = adminRpcServer.selectByName(name, tableIndex, flag);
                break;
            case User.TYPE_BRAND_QUOTIENT:
                result = brandQuotientRpcServer.selectByName(name, tableIndex, flag);
                break;
            case User.TYPE_SHOPKEEPER:
                result = shopkeeperRpcServer.selectByName(name, tableIndex, flag);
                break;
            default:
        }
        return result;
    }

    @Override
    public BrandQuotient selectBrandQuotient(long id, int tableIndex, boolean flag) throws Exception {
        BrandQuotient brandQuotient = new BrandQuotient(id);
        brandQuotient.setTableIndex(tableIndex);

        return brandQuotientRpcServer.select(brandQuotient, flag);
    }

    @Override
    public Admin selectAdmin(long id, int tableIndex, boolean flag) throws Exception {
        Admin admin = new Admin(id);
        admin.setTableIndex(tableIndex);

        return adminRpcServer.select(admin, flag);
    }

    @Override
    public Shopkeeper selectShopkeeper(long id, int tableIndex, boolean flag) throws Exception {
        Shopkeeper shopkeeper = new Shopkeeper(id);
        shopkeeper.setTableIndex(tableIndex);

        return shopkeeperRpcServer.select(shopkeeper, flag);
    }
}
