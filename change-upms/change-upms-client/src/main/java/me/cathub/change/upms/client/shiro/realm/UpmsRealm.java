package me.cathub.change.upms.client.shiro.realm;

import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户认证和授权
 * Created by shuzheng on 2017/1/20.
 */
public class UpmsRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRealm.class);

    /*@Autowired
    private RolePermissionRpcServer rolePermissionRpcServer;

    @Autowired
    private PermissionRpcServer permissionRpcServer;

    @Autowired
    private UserRoleRpcServer userRoleRpcServer;*/

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    /**
     * 授权：验证权限时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         * 当前用户所有角色
         */
        Set<String> roles = new HashSet<>();
        roles.add("admin");

        /**
         * 当前用户所有权限
         */
        Set<String> permissions = new HashSet<>();
        permissions.add("/view/index.html");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        System.out.println("CHANGE : Roles " + roles);
        System.out.println("CHANGE : Permissions " + permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        if (! "root".equals(username)) {
            System.out.println("CHANGE : Username error~ ");
        }
        return new SimpleAuthenticationInfo(username, "admin", getName());
    }

    public void setUserSelectRpcServer(UserSelectRpcServer userSelectRpcServer) {
        this.userSelectRpcServer = userSelectRpcServer;
    }
}
