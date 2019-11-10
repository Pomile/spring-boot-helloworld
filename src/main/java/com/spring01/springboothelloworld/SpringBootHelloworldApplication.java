package com.spring01.springboothelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloworldApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<HelloServlet> getServletRegistrationBean() {
		ServletRegistrationBean<HelloServlet> servletBean = new ServletRegistrationBean<>(new HelloServlet());
		servletBean.addUrlMappings("/helloServlet");
		return servletBean;
	}

	/// Register Filter.
	@Bean
	public FilterRegistrationBean<HelloFilter> getFilterRegistrationBean() {
		FilterRegistrationBean<HelloFilter> filterBean = new FilterRegistrationBean<>(new HelloFilter());
		// Add filter path
		filterBean.addUrlPatterns("/helloServlet");
		return filterBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<HelloListener> listenerBean =
				new ServletListenerRegistrationBean<>(new HelloListener());
		return listenerBean;
	}

}
