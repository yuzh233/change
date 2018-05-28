package me.cathub.change.wallet.rpc.server;

import me.cathub.change.api.dao.wallet.OutputAuditingDao;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.api.rpc.server.wallet.OutputAuditingRpcServer;
import me.cathub.change.api.rpc.server.wallet.TransactionRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.wallet.bean.OutputAuditing;
import me.cathub.change.wallet.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 提现申请 Rpc 服务实现类
 * @author cheng
 * @date 2018/5/28
 * @time 18:13
 */

@Service
public class OutputAuditingRpcServerImpl extends BaseRpcServerImpl<OutputAuditing, OutputAuditingDao> implements OutputAuditingRpcServer {

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Autowired
    private TransactionRpcServer transactionRpcServer;

    @Override
    public List<OutputAuditing> listByAdminIdAndUserType(long adminId, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByAdminIdAndUserType(adminId, type, page, count, tableIndex);
        } else {
            return dao.listByAdminIdAndUserType(adminId, type, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByAdminIdAndUserType(long adminId, int type, int tableIndex) throws Exception {
        return dao.countByAdminIdAndUserType(adminId, type, tableIndex);
    }

    @Override
    public List<OutputAuditing> listByNotAuditing(int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByNotAuditing(type, page, count, tableIndex);
        } else {
            return dao.listByNotAuditing(type, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByNotAuditing(int type, int tableIndex) throws Exception {
        return dao.countByNotAuditing(type, tableIndex);
    }

    @Override
    public List<OutputAuditing> listByUserIdAndUserType(long userId, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByUserIdAndUserType(userId, type, page, count, tableIndex);
        } else {
            return dao.listByUserIdAndUserType(userId, type, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByUserIdAndUserType(long userId, int type, int tableIndex) throws Exception {
        return dao.countByUserIdAndUserType(userId, type, tableIndex);
    }

    @Override
    public OutputAuditing fill(OutputAuditing outputAuditing) {
        try {
            User user = userSelectRpcServer.select(outputAuditing.getUserId(), true, 0, outputAuditing.getType());
            Admin admin = userSelectRpcServer.selectAdmin(outputAuditing.getAdminId(), 0, true);
            Transaction transaction = transactionRpcServer.select(new Transaction(outputAuditing.getTransactionId()), true);

            outputAuditing.setUser(user);
            outputAuditing.setAdmin(admin);
            outputAuditing.setTransaction(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputAuditing;
    }
}
