package com.zyr.demo.interceptor;

import com.zyr.demo.exception.AuthorizationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * LoginInterceptor 登录拦截器
 *
 * @author zhanyr
 * @date 2015/11/1
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
     * 不需要做登录验证的URL
     */
    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 排除不需要做登录验证的url
         */
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        /**
         * 包含静态资源的链接不拦截
         */
        if(requestUri.contains("/front/")){
            return true;
        }
        // 从session中获取用户信息，如果为空抛出自定义异常：AuthorizationException；否则登录校验通过
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            throw new AuthorizationException();
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}