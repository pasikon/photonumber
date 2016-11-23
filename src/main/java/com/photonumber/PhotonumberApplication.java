package com.photonumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@EntityScan
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class PhotonumberApplication extends SpringBootServletInitializer
		implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(PhotonumberApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PhotonumberApplication.class);
	}

	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(facesServlet(), "*.jsf");
		servletRegistrationBean.addUrlMappings("/faces/*");
		servletRegistrationBean.setName("FacesServlet");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.addListener(org.springframework.web.context.request.RequestContextListener.class);
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
		//        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
		//        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		//        servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "-1");
//		servletContext.setInitParameter("primefaces.THEME", "redmond");

	}
}
