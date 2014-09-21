package com.mdnet.travel.core.model;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.mdnet.asterisk.ami.AMIBase;
public class MyListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {   
	     super.contextInitialized(event);
	     AMIBase.instance().run();
	}  
}
