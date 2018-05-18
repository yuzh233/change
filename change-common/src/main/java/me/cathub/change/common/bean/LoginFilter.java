package me.cathub.change.common.bean;

import me.cathub.change.common.constant.SessionConstant;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();
        if (session != null) {
            String userInfo = (String) session.getAttribute(SessionConstant.LOGIN_SESSION);
            System.out.println("INFO:" + userInfo);

            if (StringUtils.isBlank(userInfo)) {
                ((HttpServletResponse) servletResponse).sendRedirect("http://localhost:1000?backUrl=" + request.getRequestURL());
            }
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("http://localhost:1000?backUrl=" + request.getRequestURL());
        }
    }

    @Override
    public void destroy() {

    }
}
