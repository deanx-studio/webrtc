package com.mdnet.travel.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/type")
public class TypeController extends BaseController{
	
	@RequestMapping(value = "/typeView")
	public ModelAndView typeView(){
		
		this.mav = new ModelAndView();
		this.mav.setViewName("type");
		//this.mav.addObject("view_list", viewList);
		return mav;
		
	}

}
