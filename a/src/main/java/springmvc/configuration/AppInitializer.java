package springmvc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
public class AppInitializer implements WebApplicationInitializer {
 	
	// <servlet>
	// <servlet-name>dispatcher</servlet-name>
	// <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	// <init-param>
	// <param-name>contextConfigLocation</param-name>
	// <param-value>/WEB-INF/spring-configuration.xml</param-value>
	// </init-param>
	// <load-on-startup>1</load-on-startup>
	// </servlet>
	//
	// <servlet-mapping>
	// <servlet-name>dispatcher</servlet-name>
	// <url-pattern>/</url-pattern>
	// </servlet-mapping>

    public void onStartup(ServletContext container) throws ServletException {
 
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
 
        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
 
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
//    
//    The content above resembles the content of web.xml as we are using the front-controller DispatherServler, assigning the mapping (url-pattern in xml) and instead of providing the path to spring configuration file(spring-servlet.xml) , here we are registering the Configuration Class.
//
//    UPDATE: Note that above class can be written even more concisely [and it’s the preferred way], by extending AbstractAnnotationConfigDispatcherServletInitializer base class, as shown below:
//
//    package com.websystique.springmvc.configuration;
//     
//    import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//     
//    public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//     
//        @Override
//        protected Class<?>[] getRootConfigClasses() {
//            return new Class[] { AppConfig.class };
//        }
//      
//        @Override
//        protected Class<?>[] getServletConfigClasses() {
//            return null;
//        }
//      
//        @Override
//        protected String[] getServletMappings() {
//            return new String[] { "/" };
//        }
//     
//    }
 
}