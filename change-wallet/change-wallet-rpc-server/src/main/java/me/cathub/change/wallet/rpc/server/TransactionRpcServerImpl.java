package me.cathub.change.wallet.rpc.server;

import me.cathub.change.api.dao.wallet.TransactionDao;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.TransactionRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.wallet.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 交易记录 Rpc 服务接口
 * @author cheng
 * @date 2018/5/28
 * @time 18:38
 */

@Service
public class TransactionRpcServerImpl extends BaseRpcServerImpl<Transaction, TransactionDao> implements TransactionRpcServer {

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Override
    public List<Transaction> listBySendUserId(long sendUserId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listBySendUserId(sendUserId, page, count, tableIndex);
        } else {
            return dao.listBySendUserId(sendUserId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countBySendUserId(long sendUserId, int tableIndex) throws Exception {
        return dao.countBySendUserId(sendUserId, tableIndex) ;
    }

    @Override
    public List<Transaction> listByReceiveUserId(long receiveUserId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByReceiveUserId(receiveUserId, page, count, tableIndex);
        } else {
            return dao.listByReceiveUserId(receiveUserId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByReceiveUserId(long receiveUserId, int tableIndex) throws Exception {
        return dao.countByReceiveUserId(receiveUserId, tableIndex);
    }

    @Override
    public Transaction fill(Transaction transaction) {
        try {
            User sUser = userSelectRpcServer.select(transaction.getSendUserId(), true, 0, transaction.getSendUserType());
            User rUser = userSelectRpcServer.select(transaction.getReceiveUserId(), true, 0, transaction.getReceiveUserType());

            transaction.setSendUser(sUser);
            transaction.setReceiveUser(rUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
