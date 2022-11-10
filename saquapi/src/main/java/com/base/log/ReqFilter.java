package com.base.log;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReqFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        ReqWrapper wrap = new ReqWrapper((HttpServletRequest)request);
        chain.doFilter(wrap, response);
    }

    @Override
    public void destroy(){

    }
}