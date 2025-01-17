package com.bingo.interceptor;

import com.bingo.utils.IPUtil;
import com.bingo.utils.JWTUtil;
import com.bingo.utils.RequestHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 徐志斌
 * @Date: 2023/8/21 20:58
 * @Version 1.0
 * @Description: 登录状态-请求拦截器
 * ----------------------------------------------------------
 * 理解：前端会调用JWTUtil.resolveToken()，这里为何还要检验每个请求呢？
 * 因为有些请求根本就不会调用JWTUtil.resolveToken()，所以状态失效了，还可以继续正常使用
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 请求到达Controller前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 从请求头中获取token信息，校验是可用
        String token = request.getHeader("token");
        if (JWTUtil.checkToken(token)) {
            log.info("登录Token校验通过：SUCCESS....................");
            // 用户信息封装到ThreadLocal中
            Map<String, Object> map = new HashMap<>();
            map.put("uid", JWTUtil.resolveTokenToUid(token));
            map.put("ip", IPUtil.getIpAddress(request));
            RequestHolderUtil.set(map);
            return true;
        } else {
            log.error("登录Token已过期：FAIL....................");
            return false;
        }
    }

    /**
     * 调用Controller后，DispatcherServlet 渲染视图之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * DispatcherServlet 渲染视图后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolderUtil.remove();
    }
}
