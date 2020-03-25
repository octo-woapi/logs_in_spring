package com.example.poclog.logging;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class TraceIdServletRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String traceid = request.getHeader("trace_id");
            if (StringUtils.isEmpty(traceid)) traceid = UUID.randomUUID().toString();
            MDC.put("trace_id", traceid);
            response.addHeader("trace_id", traceid);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MDC.clear();
        }
    }
}
