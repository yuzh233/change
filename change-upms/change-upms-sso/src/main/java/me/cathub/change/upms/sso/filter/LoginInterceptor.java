package me.cathub.change.upms.sso.filter;

import me.cathub.change.common.constant.SessionConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 *
 * @author cheng
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private String loginPage;

    /**
     * 未登陆 跳转到统一登陆中心
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /**
         * 校验用户是否登陆了(局部Session)
         *
         */
        HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            String userInfo = (String) session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO);

            if (! StringUtils.isBlank(userInfo)) {
                logger.info(session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_INFO).toString());
                logger.info(session.getAttribute(SessionConstant.CHANGE_LOCAL_USER_ROLES).toString());
                return true;
            }
            logger.info("检测到用户未登录,重定向到登陆页面");
            httpServletResponse.sendRedirect(loginPage);
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
