package com.mdnet.travel.core.intercept;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.controller.BaseController;
import com.mdnet.travel.core.model.Traveler;

@Service("userDetailsService")
public class ValidateHandlerInterceptor extends BaseController implements HandlerInterceptor {
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		String openId = request.getParameter("openId") == null ? "" : request
//				.getParameter("openId");
//
//		// 判断openId是否为空，如果为空，则不处理，如果不为空，则检查数据库中是否有该openId的记录，如果有，则实现动登录，如果没有，则直接跳到业务逻辑
//		if (openId != null && !openId.equals("")) {
//			
//			Traveler traveler = this.travelerService.findTravelByOpenId(openId);
//			
//			//说明此用户注册过，将实现自动登录功能
//			if(traveler != null){
//				
//				 String username = traveler.getUsername();
//				    String password = traveler.getPassword();
//				    boolean enabled = true;//userEntity.isActive();
//				    boolean accountNonExpired = true;//userEntity.isActive();
//				    boolean credentialsNonExpired = true;//userEntity.isActive();
//				    boolean accountNonLocked = true;//userEntity.isActive();
				    
//				    this.test(traveler);
				  //得到用户的权限  
//				    HashMap<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
//				   
//				    List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();  
//				    
//			        authsList.add(new SimpleGrantedAuthority(traveler.getAuthority()));  
//				    
//				    UserDetails userdetails = new org.springframework.security.core.userdetails.User(traveler.getUsername(), traveler  
//			                .getPassword(),enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authsList);
//				  
//				    org.springframework.security.authentication.UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(traveler, traveler);
//				  usernamePasswordAuthenticationToken.getAuthorities();
//				request.getSession().setAttribute("username", traveler);
//				request.getSession().setMaxInactiveInterval(-1);
				
//			}else{
//				//此用户未注册过，
//				//new org.springframework.security.core.userdetails.User
//			}
//
//		}else{
//			
//			
//		}

		return true;
	}
	
	public String test(Traveler traveler){
		
		
		System.out.println("test");
		
		mav = this.getMav();
	
		mav.addObject("traveler", traveler);
		
		
		mav.setViewName("/login");
		
		return this.REDIRECT + "ccc";
		
	//	return mav;
	
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
