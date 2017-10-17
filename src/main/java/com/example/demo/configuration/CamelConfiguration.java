package com.example.demo.configuration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class CamelConfiguration extends CamelAutoConfiguration {

	@Value("${payX.api.path}")
	String contextPath;
	
	@Bean
	ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean servlet = new ServletRegistrationBean
	      (new CamelHttpTransportServlet(), contextPath+"/*");
	    servlet.setName("CamelServlet");
	    return servlet;
	}
}
    
