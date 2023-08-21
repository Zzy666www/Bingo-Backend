package com.bingo.interceptor;

import com.bingo.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 跨域请求先发一个option请求（放行）
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 从请求头中获取token信息，校验是可用
        String token = request.getHeader("token");
        if (JWTUtil.checkToken(token)) {
            log.info("登录Token校验通过：SUCCESS");
            return true;
        } else {
            log.error("登录Token已过期：FAIL");
            return false;
        }
    }
}
