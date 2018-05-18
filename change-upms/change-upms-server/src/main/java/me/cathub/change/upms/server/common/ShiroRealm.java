package me.cathub.change.upms.server.common;

import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.common.bean.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 认证授权
 *
 * @author cheng
 */
public class ShiroRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("授权:" + username);

        /**
         * Roles And Permissions
         */

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(null);
        simpleAuthorizationInfo.setRoles(null);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证用户
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        User user = null;
        try {
            user = userSelectRpcServer.selectByName(username, 0, true, UserSelectRpcServer.TYPE_ADMIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return info;
    }

    public void setUserSelectRpcServer(UserSelectRpcServer userSelectRpcServer) {
        this.userSelectRpcServer = userSelectRpcServer;
    }
}
