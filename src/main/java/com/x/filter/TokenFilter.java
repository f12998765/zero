package com.x.filter;

import com.x.util.TokenUtil;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xi on 16-10-23.
 */
@Component
public class TokenFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;


        System.out.println("URL:\t"+request.getRequestURL()+"\t"+request.getMethod());

        if(request.getRequestURI().endsWith("/signin")&&request.getMethod().equals("POST")){
            //登陆接口不校验token，直接放行
            request.getRequestDispatcher("/user/signin").forward(request, response);
            return;
        }

        if(request.getRequestURI().endsWith("/signup")&&request.getMethod().equals("POST")){
            //登陆接口不校验token，直接放行
            request.getRequestDispatcher("/user/signup").forward(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            request.getRequestDispatcher("/error?info=权限不足，请登录").forward(request, response);
            return;
        }


        final String token = authHeader.substring(7);

        try {
            Claims claims = TokenUtil.ParseToken(token);
            //将用户的id放到响应头中
            request.setAttribute("userid",claims.getIssuer());

        } catch (ExpiredJwtException e) {
            request.getRequestDispatcher("/error?info=登录超时，请重新登录").forward(request, response);
            return;
        } catch (Exception e) {
            request.getRequestDispatcher("/error?info=你要干啥").forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
        return;
    }

    @Override
    public void destroy() {

    }
}
