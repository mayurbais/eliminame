package com.eliminame.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.eliminame.EliminameApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(EliminameApplication.class);
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext context = getContext();

		Dynamic registration = container.addServlet("dispatcher",
				new DispatcherServlet(context));
		registration.setLoadOnStartup(1);
		registration.addMapping("/*"); // required JBOSS EAP 6.2.0 GA
		super.onStartup(container);
	}

	private WebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(EliminameApplication.class.getName());
		return context;
	}

}
