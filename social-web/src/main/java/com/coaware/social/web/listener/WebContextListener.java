package com.coaware.social.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		System.out.println("social project start......");		
		return super.initWebApplicationContext(servletContext);
	}
	
	public void contextInitialized(ServletContextEvent event) { 
		//ServletContext context = event.getServletContext(); 
		super.contextInitialized(event); 
		//ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context); 		
		//SocialEventQueueService socialEventQueueService = (SocialEventQueueService)ctx.getBean("socialEventQueueService");
		//int result = socialEventQueueService.restore();
		//System.out.println("Server restart, update SocialEventQueue result :"+result);
	}
}
