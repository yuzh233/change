package me.cathub.change.wallet.rpc.server;

import me.cathub.change.api.dao.wallet.BalanceDao;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.BalanceRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.wallet.bean.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户余额 Rpc 服务实现类
 * @author cheng
 * @date 2018/5/28
 * @time 18:10
 */

@Service
public class BalanceRpcServerImpl extends BaseRpcServerImpl<Balance, BalanceDao> implements BalanceRpcServer {

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Override
    public Balance selectByUserId(long userId, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByUserId(userId, tableIndex);
        } else {
            return fill(dao.selectByUserId(userId, tableIndex));
        }
    }

    @Override
    public Balance fill(Balance balance) {
        try {
            User user = userSelectRpcServer.select(balance.getUserId(), true, 0, balance.getType());

            balance.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
}
