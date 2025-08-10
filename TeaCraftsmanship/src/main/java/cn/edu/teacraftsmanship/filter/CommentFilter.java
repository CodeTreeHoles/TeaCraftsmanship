package cn.edu.teacraftsmanship.filter;


import cn.edu.teacraftsmanship.pojo.Result;
import cn.edu.teacraftsmanship.utils.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@Component
//@WebFilter("/comment/*")
public class CommentFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器
        log.info("过滤器初始化成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //获取请求头中的token
        String jwt = req.getHeader("token");

        //判断token是否合法
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头中的token为空，返回错误信息");
            Result error = Result.error("令牌为空");
            String errorJson = JSONObject.toJSONString(error);
            resp.getWriter().write(errorJson);
            return;
        }

        //如果合法就放行
        try {
            Claims claims = JwtUtils.parseJWT(jwt);
            log.info("解析令牌：{}",claims);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("令牌解析失败");
            Result error = Result.error("令牌解析失败");
            String errorJson = JSONObject.toJSONString(error);
            resp.getWriter().write(errorJson);
            return;
        }
        log.info("令牌合法,放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
