package com.mdnet.travel.core.controller;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

public class OperationBefore extends MethodBeforeAdviceInterceptor{

	public OperationBefore(MethodBeforeAdvice advice) {
		super(advice);
		// TODO Auto-generated constructor stub
	}
	
	
}
