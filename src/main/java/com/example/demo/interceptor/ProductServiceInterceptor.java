package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*You can use the Interceptor in Spring Boot to perform operations under the following situations −
Before sending the request to the controller
Before sending the response to the client*/

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 
		System.out.println("Pre Handle method is Calling" + System.currentTimeMillis());
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	      System.out.println("Post Handle method is Calling" + System.currentTimeMillis());
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	      System.out.println("Request and Response is completed" + System.currentTimeMillis());

	}

}
