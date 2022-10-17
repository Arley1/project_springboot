package dev.com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "myFilterWithAnnotationOne" ,value = "/order/*")
public class MyFilterWithAnnotationOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter init---");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter ..");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("myFilter destroy..");
    }
}
