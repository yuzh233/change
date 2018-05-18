package me.cathub.change.upms.server.common;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 重写authc过滤器
 * Created by shuzheng on 2017/3/11.
 */
public class UpmsAuthenticationFilter extends AuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }
}