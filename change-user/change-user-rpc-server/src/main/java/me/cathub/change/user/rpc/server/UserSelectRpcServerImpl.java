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
    public User select(long id, boolean flag, int type) throws Exception {
        User result = null;
        switch (type) {
            case TYPE_ADMIN:
                result = adminRpcServer.select(new Admin(id), flag);
                break;
            case TYPE_BRAND_QUOTIENT:
                result = brandQuotientRpcServer.select(new BrandQuotient(id), flag);
                break;
            case TYPE_SHOPKEEPER:
                result = shopkeeperRpcServer.select(new Shopkeeper(id), flag);
                break;
            default:
        }
        return result;
    }

    @Override
    public User selectByName(String name, int tableIndex, boolean flag, int type) throws Exception {
        User result = null;
        switch (type) {
            case TYPE_ADMIN:
                result = adminRpcServer.selectByName(name, tableIndex, flag);
                break;
            case TYPE_BRAND_QUOTIENT:
                result = brandQuotientRpcServer.selectByName(name, tableIndex, flag);
                break;
            case TYPE_SHOPKEEPER:
                result = shopkeeperRpcServer.selectByName(name, tableIndex, flag);
                break;
            default:
        }
        return result;
    }
}
