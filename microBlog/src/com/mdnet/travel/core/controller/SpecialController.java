package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.vo.SpecialBean;
import com.mdnet.travel.core.vo.SpecialInfo;

@Controller
@RequestMapping("/special")
public class SpecialController extends BaseController {
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;

	/**
	 * 编辑标题作者
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addnewpic", method = RequestMethod.POST)
	public ModelAndView addNewPic(
			@RequestParam(value = "id", required = true) int id,
			/*
			 * @RequestParam(value = "title", required = true) String title,
			 * 
			 * @RequestParam(value = "writer", required = true) String writer,
			 */
			@RequestParam(value = "new_smart_pic", required = true) String newPic) {
		String msg = "";
		SpecialBean sb = this.messageService.GetSpecial(id);
		String title = "";
		String writer = "";
		String align = "";
		if (sb != null) {
			title = sb.getTitle();
			writer = sb.getSpecialWriter();
			align = sb.getAlign();
			SpecialInfo[] content_list = this.messageService.GetContentList(sb);
			SpecialInfo[] newList = null;
			if (content_list != null) {
				newList = new SpecialInfo[content_list.length + 1];
				// 保存原始数据
				for (int i = 0; i < content_list.length; i++) {
					newList[i] = content_list[i];
				}
			} else
				newList = new SpecialInfo[1];

			// 写入新的数据
			int inx = newList.length - 1;
			newList[inx] = new SpecialInfo();
			newList[inx].setIs_show(1);
			newList[inx].setSmart(newPic);
			newList[inx].setSmart_text("");

			Gson g = new Gson();
			String content = g.toJson(newList);
			// 保存数据
			this.messageService
					.updateSpecial(id, title, writer, align, content);
			msg = "增加成功";
		} else// 未找到相关数据
		{
			msg = "未找到原始数据，不能更新。";
		}
		this.mav = new ModelAndView();

		this.mav.setViewName("special/update");
		this.mav.addObject("id", id);
		this.mav.addObject("title", title);
		this.mav.addObject("writer", writer);
		this.mav.addObject("msg", msg);
		sb = this.messageService.GetSpecial(id);
		this.mav.addObject("content_list",
				this.messageService.GetContentList(sb));
		return mav;// 回到页面编辑
	}

	@RequestMapping(value = "/autoSave", method = RequestMethod.POST)
	@ResponseBody
	public String autoSave(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "item", required = true) int item,
			@RequestParam(value = "text", required = true) String text,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "subhead", required = false) String subhead) {
		int ret = -1;
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {
			SpecialInfo[] content_list = this.messageService.GetContentList(sb);
			// 更新文档
			for (int i = 0; i < content_list.length; i++) {
				if (content_list[i].getHashCode() == item) {
					// 找到了修改项
					content_list[i].setSmart_text(text);
					content_list[i].setTitle(title);
					content_list[i].setSubhead(subhead);
					// 保存数据
					Gson g = new Gson();
					String content = g.toJson(content_list);
					// 更新数据
					ret = this.messageService.updateSpecial(id, sb.getTitle(),
							sb.getSpecialWriter(), sb.getAlign(), content);
					break;
				}
			}
		}

		return String.valueOf(ret);
	}

	/**
	 * 编辑标题作者
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update/action", method = RequestMethod.POST)
	public ModelAndView updateAction(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String align = request.getParameter("align");
		String msg = "";
		// 获取现在的数据
		// 从数据库中获取当前的数据
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {
			SpecialInfo[] content_list = this.messageService.GetContentList(sb);
			// 更新文档
			for (int i = 0; i < content_list.length; i++) {
				// 获取图片的附加文字说明
				String text = request.getParameter("smart_text_"
						+ content_list[i].getHashCode());
				content_list[i].setSmart_text(text);
			}
			// 将cotent_list变成json
			Gson g = new Gson();
			String content = g.toJson(content_list);
			// 更新数据
			int ret = this.messageService.updateSpecial(id, title, writer,
					align, content);
			if (ret == 0) {
				msg = "修改成功，请继续编辑相关的内容。";
			} else {
				msg = "修改失败，请检查数据。";
			}
		} else// 未找到相关数据
		{
			msg = "未找到原始数据，不能更新。";
		}
		this.mav = new ModelAndView();

		this.mav.setViewName("special/update");
		this.mav.addObject("title", title);
		this.mav.addObject("writer", writer);
		this.mav.addObject("align", align);
		this.mav.addObject("id", id);
		this.mav.addObject("msg", msg);
		sb = this.messageService.GetSpecial(id);
		this.mav.addObject("content_list",
				this.messageService.GetContentList(sb));
		return mav;// 回到页面编辑
	}

	/**
	 * 编辑标题作者
	 * 
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(
			@RequestParam(value = "id", required = true) int id) {
		this.mav = new ModelAndView();
		String msg = "";
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {

			this.mav.addObject("title", sb.getTitle());
			this.mav.addObject("writer", sb.getSpecialWriter());
			this.mav.addObject("align", sb.getAlign());
			this.mav.addObject("content_list",
					this.messageService.GetContentList(sb));
		} else {
			msg = "数据查找失败。";
		}
		this.mav.addObject("id", id);
		this.mav.setViewName("special/update");
		this.mav.addObject("msg", msg);
		return mav;// 回到页面编辑
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUI() {
		this.mav = new ModelAndView();

		this.mav.setViewName("special/add");
		this.mav.addObject("title", "");
		this.mav.addObject("wrtier", "");
		return mav;
	}

	/**
	 * 编辑标题作者
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add/action", method = RequestMethod.POST)
	public ModelAndView addAction(
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "writer", required = true) String writer,
			@RequestParam(value = "align", required = true) String align) {
		this.mav = new ModelAndView();
		String msg = "";
		WeixinAccount acc = this.getWeixinAccount();
		int ret = this.messageService.AddSpecial(title, writer, align,
				acc.getWxFromUserName());
		SpecialInfo[] content = null;
		if (ret > 0) {
			this.mav.setViewName("special/update");
			msg = "增加成功，请继续编辑相关的内容";
			this.mav.addObject("id", ret);
			SpecialBean sb = this.messageService.GetSpecial(ret);
			content = this.messageService.GetContentList(sb);
		} else {
			this.mav.setViewName("special/add");
			msg = "增加失败，请检查";
		}
		this.mav.addObject("title", title);
		this.mav.addObject("writer", writer);
		this.mav.addObject("align", align);
		this.mav.addObject("msg", msg);

		this.mav.addObject("content_list", content);

		return mav;// 回到页面编辑
	}

	/**
	 * 列出专题
	 * 
	 * @param pageNo
	 *            从0开始
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUI(
			@RequestParam(value = "page", required = false) String page,
			HttpServletRequest request) {
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		String search = "";
		try {
			String s = request.getParameter("s");
			if (s != null && s.length() > 0) {
				search = new String(s.getBytes("iso-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int pageCount = 20;
		int nextPage = 0;
		int prevPage = 0;
		if (pageNo < 0)
			pageNo = 0;
		prevPage = pageNo - 1;
		this.mav = new ModelAndView();
		WeixinAccount acc = this.getWeixinAccount();
		String where = " toUserName='" + acc.getWxFromUserName() + "' ";
		if (search.length() > 0) {
			where += " and title like '%" + search + "%' ";
		}
		List<SpecialBean> SpecialsBean = this.messageService.findSpecial(where,
				pageNo, pageCount);
		if (SpecialsBean == null || SpecialsBean.size() == 0) {
			nextPage = pageNo;
		} else {
			nextPage = pageNo + 1;
		}
		this.mav.addObject("special_list", SpecialsBean);

		this.mav.setViewName("special/list");

		this.mav.addObject("prevPage", prevPage);
		this.mav.addObject("pageNo", pageNo);
		this.mav.addObject("nextPage", nextPage);
		this.mav.addObject("search", search);
		return mav;
	}

	/**
	 * 处理修改记录状态请求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	@ResponseBody
	public String state(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "state", required = true) String state) {
		int ret = this.messageService.updateSpecialState(id, state);
		return String.valueOf(ret);
	}

	/**
	 * 图片上移
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/moveItem", method = RequestMethod.GET)
	@ResponseBody
	public String moveItem(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "code", required = true) int hashCode) {
		int ret = 0;
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {
			SpecialInfo[] sp = this.messageService.GetContentList(sb);
			if (sp.length > 0) {
				if (sp[0].getSmart().hashCode() == hashCode)
					return "1";// 已经到顶了
			}

			for (int i = 0; i < sp.length; i++) {
				if (sp[i].getSmart().hashCode() == hashCode) {
					// 找到元素和前一个对调
					// 备份上一个
					SpecialInfo prev = sp[i - 1];
					// 将当前的复制到上一个
					sp[i - 1] = sp[i];
					// 将上一个复制到当前
					sp[i] = prev;
					break;// 对调结束退出循环
				}
			}

			// 保存到数据库中
			Gson g = new Gson();
			String content = g.toJson(sp);
			// 更新数据
			ret = this.messageService.updateSpecial(id, sb.getTitle(),
					sb.getSpecialWriter(), sb.getAlign(), content);
		} else {
			ret = -1;// 未找到
		}
		return String.valueOf(ret);

	}

	/**
	 * 处理修改记录状态请求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stateItem", method = RequestMethod.GET)
	@ResponseBody
	public String stateItem(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "code", required = true) int hashCode,
			@RequestParam(value = "state", required = true) String state) {
		int ret = 0;
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {
			SpecialInfo[] sp = this.messageService.GetContentList(sb);

			for (int i = 0; i < sp.length; i++) {
				if (sp[i].getSmart().hashCode() == hashCode) {
					sp[i].setIs_show(state.equals("true") ? 1 : 0);
				}
			}
			// 保存到数据库中
			Gson g = new Gson();
			String content = g.toJson(sp);
			// 更新数据
			ret = this.messageService.updateSpecial(id, sb.getTitle(),
					sb.getSpecialWriter(), sb.getAlign(), content);
		} else {
			ret = -1;
		}
		return String.valueOf(ret);

	}

	/**
	 * 删除整条专题记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	@ResponseBody
	public String deleteItem(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "code", required = true) int hashCode) {
		int ret = 0;
		SpecialBean sb = this.messageService.GetSpecial(id);
		if (sb != null) {
			SpecialInfo[] sp = this.messageService.GetContentList(sb);
			// 计算有个删除对象
			int removeCount = 0;
			for (int i = 0; i < sp.length; i++) {
				if (sp[i].getSmart().hashCode() == hashCode) {
					removeCount++;
				}
			}
			SpecialInfo[] up = new SpecialInfo[sp.length - removeCount];
			int n = 0;

			for (int i = 0; i < sp.length; i++) {
				if (sp[i].getSmart().hashCode() != hashCode) {
					up[n] = sp[i];
					n++;
				}
			}

			// 保存到数据库中
			Gson g = new Gson();
			String content = g.toJson(up);
			// 更新数据
			ret = this.messageService.updateSpecial(id, sb.getTitle(),
					sb.getSpecialWriter(), sb.getAlign(), content);
		} else {
			ret = -1;
		}
		return String.valueOf(ret);
	}

	/**
	 * 删除整条专题记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam(value = "id", required = true) int id) {
		int ret = this.messageService.DeleteSpecial(id);
		return String.valueOf(ret);
	}

}
