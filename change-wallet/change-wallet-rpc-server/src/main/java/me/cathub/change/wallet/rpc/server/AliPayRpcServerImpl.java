package me.cathub.change.wallet.rpc.server;

import me.cathub.change.api.dao.wallet.AliPayDao;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.AliPayRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.wallet.bean.AliPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 绑定支付宝 Rpc 服务实现类
 * @author cheng
 * @date 2018/5/28
 * @time 17:56
 */

@Service
public class AliPayRpcServerImpl extends BaseRpcServerImpl<AliPay, AliPayDao> implements AliPayRpcServer {

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Override
    public AliPay selectByUserId(long userId, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByUserId(userId, tableIndex);
        } else {
            return fill(dao.selectByUserId(userId, tableIndex));
        }
    }

    @Override
    public AliPay fill(AliPay aliPay) {
        try {
            User user = userSelectRpcServer.select(aliPay.getUserId(), true, 0, aliPay.getType());

            aliPay.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aliPay;
    }
}
