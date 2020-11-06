package com.sdm.auth.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

@Order(2)//优先级
@WebFilter(filterName = "MyFilter2", urlPatterns = "/*")//Filter配置
public class MyFilter2 implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter2--destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("MyFilter2--doFilter");
        filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter2--init");
	}

}
