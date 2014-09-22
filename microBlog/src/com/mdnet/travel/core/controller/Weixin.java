package com.mdnet.travel.core.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdnet.travel.core.weixin.service.CoreService;
import com.mdnet.travel.core.weixin.service.impl.CoreServiceImpl;
import com.mdnet.travel.core.weixin.utils.SignUtil;

import freemarker.log.Logger;
@Controller
@RequestMapping("/weixin")
public class Weixin{

	@Resource(name = CoreService.SERVICE_NAME)
	protected CoreServiceImpl coreService;
	/**
	 * 确认请求来自微信服务器
	 */
	@RequestMapping(value="/process",method=RequestMethod.GET)
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		//out.println(echostr);
		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	@RequestMapping(value="/process",method=RequestMethod.POST)
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		// 调用核心业务类接收消息、处理消息
		String respMessage = coreService.processRequest(request);
		System.out.println("客户发送微信Post消息");
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}

}
