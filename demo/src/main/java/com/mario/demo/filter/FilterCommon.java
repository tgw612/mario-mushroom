package com.mario.demo.filter;
import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class FilterCommon implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
