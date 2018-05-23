package me.cathub.change.upms.sso.filter;

import me.cathub.change.common.constant.SessionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 授权拦截器
 *
 * @author cheng
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    /**
     * 当前系统 用户的权限
     */
    private Map<String, List<String>> rolePrmission;

    /**
     * 处理器执行之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURL = httpServletRequest.getRequestURL().toString();
        logger.info("getRequestURL : " + requestURL);

        String rolesStr = (String) httpServletRequest.getSession().getAttribute(SessionConstant.CHANGE_LOCAL_USER_ROLES);

        logger.info("用户角色 : " + rolesStr);
        String[] roles = rolesStr.split(",");
        logger.info("权限集合 : " + rolePrmission);

        if (requestURL.charAt(requestURL.length() - 1) == '/') {
            return true;
        }

        for (String role:roles) {
            logger.info(String.valueOf(role));
            List<String> permissions = rolePrmission.get(role);
            if(permissions != null) {
                for (String permission:permissions) {
                    if (requestURL.contains(permission)) {
                        return true;
                    }
                }
            }
        }
        logger.info("无权访问 : " + requestURL);
        return false;
    }

    /**
     * 处理器执行完毕之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception { }

    /**
     * 整个请求处理完成之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception { }

    public void setRolePrmission(Map<String, List<String>> rolePrmission) {
        this.rolePrmission = rolePrmission;
    }
}