package com.mdnet.travel.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.KeyDefine;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.vo.KeysBean;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController {
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;

	@RequestMapping(value = "/article/keys", method = RequestMethod.GET)
	public ModelAndView listUI(HttpServletRequest request) {

		String et = request.getParameter("et");
		this.mav = new ModelAndView();
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> keysList = this.messageService.findAllKeys(et,
				acc.getWxFromUserName());
		this.mav.addObject("keys_list", keysList);
		this.mav.addObject("et", et);
		this.mav.setViewName("article/keys");

		return mav;
	}

	@RequestMapping(value = "/article/delete", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam(value = "id", required = true) int key_id) {
		// this.messageService.findKey(key_id);
		return String.valueOf(this.messageService.DeleteKey(key_id));
	}

	@RequestMapping(value = "/article/detail", method = RequestMethod.GET)
	public ModelAndView detailUI(
			@RequestParam(value = "keyid", required = true) int key_id) {

		KeyDefine key = this.messageService.findKey(key_id);
		this.mav = new ModelAndView();
		this.mav.addObject("key", key);
		this.mav.setViewName("article/key_update");

		return mav;
	}

	@RequestMapping(value = "/article/update", method = RequestMethod.POST)
	public ModelAndView update(KeysBean keyBean) {
		// 保存数据
		KeyDefine key = new KeyDefine();
		key.setId(keyBean.getId());
		key.setKeyDescript(keyBean.getKey_descript());
		key.setKeyName(keyBean.getKey_name());
		key.setKeyValue(keyBean.getKey_value());
		key.setToUserName(this.getWeixinAccount().getWxFromUserName());
		this.mav = new ModelAndView();
		if (this.messageService.UpdateKey(key) > 0) {
			this.mav.addObject("message", "数据更新成功");
		} else {
			this.mav.addObject("message", "数据更新失败");
		}
		// return this.REDIRECT + "/event/article/detail?keyid=" + key.getId();
		KeyDefine key0 = this.messageService.findKey(key.getId());

		this.mav.addObject("key", key0);
		this.mav.setViewName("article/key_update");

		return mav;
	}

	@RequestMapping(value = "/article/keyexist", method = RequestMethod.GET)
	@ResponseBody
	public String keyExist(
			@RequestParam(value = "keyValue", required = true) int key_id) {
		WeixinAccount acc = this.getWeixinAccount();
		List<KeyDefine> key = this.messageService.findKeyValue(key_id,
				acc.getWxFromUserName());
		if (key != null && key.size() > 0)
			return "0";// 已经存在了
		else
			return "1";
	}

	@RequestMapping(value = "/article/add", method = RequestMethod.GET)
	public ModelAndView add() {
		this.mav = new ModelAndView();

		this.mav.setViewName("article/key_add");

		return mav;
	}

	@RequestMapping(value = "/article/addNew", method = RequestMethod.POST)
	public ModelAndView addNew(KeysBean key) {

		this.mav = new ModelAndView();

		KeyDefine keyDefine = new KeyDefine();
		keyDefine.setKeyDescript(key.getKey_descript());
		keyDefine.setKeyName(key.getKey_name());
		keyDefine.setKeyValue(key.getKey_value());
		WeixinAccount acc = this.getWeixinAccount();
		keyDefine.setToUserName(acc.getWxFromUserName());
		int key_id = this.messageService.AddKey(keyDefine);

		// return this.REDIRECT + "/event/article/detail?keyid=" + id;
		this.mav = new ModelAndView();
		if (key_id > 0) {
			this.mav.addObject("message", "增加成功。");
		} else {
			this.mav.addObject("message", "增加失败。");
		}
		KeyDefine key0 = this.messageService.findKey(key_id);

		this.mav.addObject("key", key0);
		this.mav.setViewName("article/key_update");

		return mav;
	}

}
