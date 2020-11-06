package com.sdm.auth.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
@Order(1)//优先级
@WebFilter(filterName = "MyFilter1", urlPatterns = "/*")//Filter配置
public class MyFilter1 implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter1--destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("MyFilter1--doFilter");
        System.out.println("this is MyFilter,url :" + ((HttpServletRequest) request).getRequestURI());
        filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter1--init");
	}

}
