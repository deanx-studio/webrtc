package com.mdnet.travel.core.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.dao.ArticleDAO;
import com.mdnet.travel.core.dao.CustomerDAO;
import com.mdnet.travel.core.dao.KeysDAO;
import com.mdnet.travel.core.dao.MediaDAO;
import com.mdnet.travel.core.dao.MenuDAO;
import com.mdnet.travel.core.dao.ReqMessageDAO;
import com.mdnet.travel.core.dao.SpecialDAO;
import com.mdnet.travel.core.dao.WeixinAccountDAO;
import com.mdnet.travel.core.model.Article;
import com.mdnet.travel.core.model.Customer;
import com.mdnet.travel.core.model.KeyDefine;
import com.mdnet.travel.core.model.Media;
import com.mdnet.travel.core.model.MenuDefine;
import com.mdnet.travel.core.model.ReqMessage;
import com.mdnet.travel.core.model.Special;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.utils.MD5;
import com.mdnet.travel.core.vo.KeysBean;
import com.mdnet.travel.core.vo.MenusBean;
import com.mdnet.travel.core.vo.NewsBean;
import com.mdnet.travel.core.vo.SpecialBean;
import com.mdnet.travel.core.vo.SpecialInfo;
import com.mdnet.travel.core.weixin.pojo.Button;
import com.mdnet.travel.core.weixin.pojo.CommonButton;
import com.mdnet.travel.core.weixin.pojo.ComplexButton;
import com.mdnet.travel.core.weixin.pojo.Menu;
import com.mdnet.travel.core.weixin.pojo.ViewButton;
import com.mdnet.travel.core.weixin.utils.MessageUtil;

@Service(IMessageService.SERVICE_NAME)
@Scope("prototype")
@Transactional(readOnly = true)
public class MessageServiceImpl implements IMessageService {

	@Resource(name = ReqMessageDAO.DAO_NAME)
	protected ReqMessageDAO reqMessageDAO;

	@Resource(name = CustomerDAO.DAO_NAME)
	protected CustomerDAO customerDAO;

	@Resource(name = ArticleDAO.DAO_NAME)
	protected ArticleDAO articleDAO;

	@Resource(name = KeysDAO.DAO_NAME)
	protected KeysDAO keysDAO;

	@Resource(name = MenuDAO.DAO_NAME)
	protected MenuDAO menuDAO;

	@Resource(name = SpecialDAO.DAO_NAME)
	protected SpecialDAO specialDAO;

	@Resource(name = MediaDAO.DAO_NAME)
	protected MediaDAO mediaDAO;

	@Resource(name = WeixinAccountDAO.DAO_NAME)
	protected WeixinAccountDAO wxAccountDAO;

	@Resource(name = "constant")
	protected Constant myConstant;

	/**
	 * 
	 * @param articleId
	 * @param state
	 * @return 0:成功 1：更新失败 -1：未找到有关记录
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int updateArticleState(int articleId, int state) {
		List<Article> articles = this.articleDAO.findById(articleId);
		if (articles != null && articles.size() > 0) {
			Article article = articles.get(0);
			article.setAticleState(state);
			this.articleDAO.update(article);
			return 0;
		} else
			return -1;
	}

	@Override
	public List<KeysBean> findAllKeys(String et, String weixinId) {
		List<KeyDefine> keys = this.keysDAO.findAll(et, weixinId);
		List<KeysBean> keysList = new ArrayList<KeysBean>();
		if (keys != null && keys.size() > 0) {
			for (KeyDefine key : keys) {
				KeysBean keyBean = new KeysBean();
				keyBean.setId(key.getId());
				keyBean.setKey_descript(key.getKeyDescript());
				keyBean.setKey_name(key.getKeyName());
				keyBean.setKey_value(key.getKeyValue());
				keysList.add(keyBean);
			}
		}
		return keysList;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int addNews(NewsBean news, String weixinId) {
		if (null != news) {
			Article article = new Article(news.getTitle(),
					news.getDescription(), news.getPic_url(), news.getUrl());
			article.setAticleState(1);// 默认为显示
			article.setSeq(news.getSeq());
			article.setArticleId(news.getNews_id());
			article.setToUserName(weixinId);
			return this.articleDAO.save(article);
		}
		return -1;
	}

	@Override
	public List<NewsBean> findAllNews(int pageNo, String search, String weixinId) {
		List<Article> articleList = this.articleDAO.findAll(pageNo, search,
				weixinId);
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		if (articleList.size() > 0) {
			for (Article article : articleList) {
				NewsBean news = new NewsBean(article.getTitle(),
						article.getDescription(), article.getPicUrl(),
						article.getUrl());
				news.setNews_id(article.getArticleId());

				List<KeyDefine> keys = this.keysDAO.findByKeyValue(
						article.getArticleId(), weixinId);
				if (keys != null && keys.size() > 0)
					news.setKeyName(keys.get(0).getKeyName());
				else
					news.setKeyName("");
				news.setId(article.getId());
				news.setSeq(article.getSeq());
				news.setArticleState(article.getAticleState());
				newsList.add(news);
			}
		}
		if (newsList.size() > 0) {
			return newsList;
		}
		return null;
	}

	@Override
	public NewsBean findNewsByArticleId(int articleId, String weixinId) {
		List<Article> articles = this.articleDAO.findByIds(
				String.valueOf(articleId), weixinId);
		if (null != articles && articles.size() > 0) {
			NewsBean news = new NewsBean(articles.get(0).getTitle(), articles
					.get(0).getDescription(), articles.get(0).getPicUrl(),
					articles.get(0).getUrl());
			news.setNews_id(articles.get(0).getArticleId());
			news.setId(articles.get(0).getId());
			news.setSeq(articles.get(0).getSeq());
			return news;
		}
		return null;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int deleteNews(int news_id) {
		// int c = this.articleDAO
		// .count("from Article where id=" + news_id);
		// System.out.println("count=" + c);
		List<Article> articles = this.articleDAO.findById(news_id);
		if (articles != null && articles.size() > 0) {
			this.articleDAO.delete(articles.get(0));
			return 0;

		}
		return -1;
	}

	/*************** 图文消息结束 **************/
	@Override
	public SpecialBean GetSpecial(int id) {
		List<SpecialBean> sbs = this.findSpecial("id=" + id, 0, 1);

		if (sbs != null && sbs.size() > 0) {
			return sbs.get(0);
		} else
			return null;
	}

	@Override
	public List<SpecialBean> findSpecial(String query, int page, int length) {
		List<SpecialBean> specialBean = new ArrayList<SpecialBean>();

		List<Special> specials = this.specialDAO.findAll(query,
		/* Constant.WEIXIN_ID, */page * length, length);
		for (int i = 0; i < specials.size(); i++) {
			SpecialBean sb = new SpecialBean();
			sb.setId(specials.get(i).getId());
			sb.setSpecialBody(specials.get(i).getSpecialBody());
			sb.setSpecialMaketime(specials.get(i).getSpecialMaketime());
			sb.setSpecialState(specials.get(i).getSpecialState());
			sb.setSpecialWriter(specials.get(i).getSpecialWriter());
			sb.setTitle(specials.get(i).getTitle());
			sb.setAlign(specials.get(i).getTextAlign());
			sb.setToUserName(specials.get(i).getToUserName());
			specialBean.add(sb);
		}
		return specialBean;
	}

	// 将json字符串转变为对象
	protected SpecialInfo[] jsonToObj(SpecialBean sb) {
		SpecialInfo[] content_list = null;
		try {
			Gson g = new Gson();
			content_list = g.fromJson(sb.getSpecialBody(), SpecialInfo[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content_list;
	}

	@Override
	public SpecialInfo[] GetContentList(SpecialBean sb) {
		SpecialInfo[] content_list = null;

		if (sb != null) {
			content_list = jsonToObj(sb);
		}
		// 生成MD5码
		if (content_list != null) {
			for (int i = 0; i < content_list.length; i++) {
				content_list[i].setHashCode(content_list[i].getSmart()
						.hashCode());
			}
		}
		return content_list;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int updateSpecial(int id, String title, String writer, String align,
			String content) {
		Special sp = this.specialDAO.findById(id);
		sp.setSpecialWriter(writer);
		sp.setTitle(title);
		sp.setTextAlign(align);
		sp.setSpecialBody(content);
		this.specialDAO.save(sp);
		return 0;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int AddSpecial(String title, String writer, String align,
			String weixinId) {
		Special sp = new Special();
		String maketime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		maketime = sdf.format(new Date());
		sp.setSpecialMaketime(maketime);
		sp.setSpecialState(1);
		sp.setSpecialWriter(writer);
		sp.setTitle(title);
		sp.setTextAlign(align);
		// 一个默认的以文本开始的节点
		SpecialInfo[] spi = new SpecialInfo[1];
		spi[0] = new SpecialInfo();
		spi[0].setIs_show(1);
		spi[0].setSmart("");
		spi[0].setSmart_text("");
		Gson g = new Gson();
		sp.setSpecialBody(g.toJson(spi));
		sp.setToUserName(weixinId);
		return this.specialDAO.save(sp);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int updateSpecialState(int id, String state) {
		List<Special> special = this.specialDAO.findAll(" id=" + id, 0, 1);
		if (special != null && special.size() > 0) {
			Special sp = special.get(0);
			sp.setSpecialState(state.equals("true") ? 1 : 0);
			this.specialDAO.update(sp);
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int DeleteSpecial(int id) {
		List<Special> special = this.specialDAO.findAll(" id=" + id, 0, 1);
		if (special != null && special.size() > 0)
			this.specialDAO.delete(special.get(0));
		return 0;
	}

	protected String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return "";
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int upload(String title, MultipartFile file, String path,
			String weixinId) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

			String src_id = file.getSize() + file.getOriginalFilename();
			String mediaPath = sdf.format(new Date());
			path = path + "/" + mediaPath;
			//
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdir();
			String md5 = MD5.getMD5(src_id.getBytes());
			String mediaFile = md5 + "."
					+ this.getExtensionName(file.getOriginalFilename());
			String filename = path + "/" + mediaFile;
			File newFile = new File(filename);
			file.transferTo(newFile);

			long length = newFile.length();// .getSize();

			// 保存到数据库
			Media entity = new Media();
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
			entity.setMaketime(sdf.format(new Date()));
			entity.setMedia_url("resources/media/" + mediaPath + "/"
					+ mediaFile);// 相对路径
			entity.setMediaMD5("");
			entity.setOriginalFileName(file.getOriginalFilename());
			entity.setMediaSize((int) length);
			entity.setMediaState(1);
			entity.setMediaType(file.getContentType());
			entity.setPhysicalPath(filename);
			entity.setTitle(title);
			entity.setToUserName(weixinId);
			return this.mediaDAO.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/********* 媒体部分开始 *************/
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int deleteMedia(int id) {
		List<Media> media = this.mediaDAO.findAll(0, 1, "id",
				String.valueOf(id), null);
		if (media != null && media.size() > 0) {
			this.mediaDAO.delete(media.get(0));
			return 0;
		}
		return -1;

	}

	@Override
	public List<Media> findMedia(int page, int count, String t, String search,
			String weixinId) {
		return this.mediaDAO.findAll(page, count, t, search, weixinId);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int UpdateMedia(String id, String title) {
		Media media = this.mediaDAO.get(Integer.parseInt(id));
		if (media != null) {
			media.setTitle(title);
			this.mediaDAO.save(media);
			return 0;
		} else
			return -1;

	}

	/******************* 媒体部分结束 **********************/

	/******************* 菜单部分开始开始 **********************/
	protected MenusBean MenuDefineToBean(MenuDefine md) {
		MenusBean mb = new MenusBean();
		mb.setId(md.getId());
		mb.setMenuKey(md.getMenuKey());
		mb.setMenuName(md.getMenuName());
		mb.setMenuType(md.getMenuType());
		mb.setMenuUrl(md.getMenuUrl());
		mb.setParentId(md.getParentId());
		return mb;
	}

	@Override
	public List<MenusBean> findMenus(String where, String weixinId) {
		List<MenuDefine> mds = this.menuDAO.findMenus(where, weixinId);
		List<MenusBean> mbs = new ArrayList<MenusBean>();
		for (int i = 0; i < mds.size(); i++) {
			MenuDefine md = mds.get(i);
			MenusBean mb = this.MenuDefineToBean(md);
			mbs.add(mb);
		}
		return mbs;
	}

	@Override
	public MenusBean findMenuById(int id) {
		List<MenuDefine> md = this.menuDAO.findMenus(" where id=" + id, null);
		if (md != null && md.size() > 0) {
			MenusBean mb = MenuDefineToBean(md.get(0));
			return mb;
		}
		return null;
	}

	@Override
	public List<KeyDefine> findKeyValue(int key_id, String weixinId) {
		return this.keysDAO.findByKeyValue(key_id, weixinId);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int AddMenu(MenusBean menu, String weixinId) {

		int menuKey = menu.getMenuKey();
		// 等于1是手动选择
		if (menu.getCreateKeyMode() == 0 && menu.getMenuType().equals("click")) {
			// 创建自动的键值关联到菜单
			KeyDefine newKey = new KeyDefine();
			newKey.setKeyDescript("为菜单：" + menu.getMenuName() + "自动创建的专题目录项。");
			newKey.setKeyName("菜单：[" + menu.getMenuName() + "] 对应的专题目录项。");
			int keyValue = 101;// 默认值是101
			// 从系统获取最大值+1
			int maxValue = this.keysDAO.getMaxValue();

			if (maxValue >= 100)
				keyValue = maxValue + 1;
			newKey.setKeyValue(keyValue);
			newKey.setToUserName(weixinId);
			menuKey = this.keysDAO.save(newKey);
			if (menuKey <= 0)
				return -3;
			else
				menuKey = keyValue;
		}
		MenuDefine md = new MenuDefine();
		md.setMenuKey(menuKey);
		md.setMenuName(menu.getMenuName());
		md.setMenuType(menu.getMenuType());
		md.setMenuUrl(menu.getMenuUrl());
		md.setParentId(menu.getParentId());

		md.setToUserName(weixinId);
		return this.menuDAO.save(md);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMenu(MenusBean menu, String weixinId) {
		MenuDefine entity = new MenuDefine();
		entity.setId(menu.getId());
		entity.setMenuKey(menu.getMenuKey());
		entity.setMenuName(menu.getMenuName());
		entity.setMenuType(menu.getMenuType());
		entity.setMenuUrl(menu.getMenuUrl());
		entity.setParentId(menu.getParentId());
		entity.setToUserName(weixinId);
		this.menuDAO.update(entity);
	}

	protected Button createButton(MenusBean subMenu) {
		if (subMenu.getMenuType().equals("click")) {

			CommonButton btn = new CommonButton();
			btn.setName(subMenu.getMenuName());
			btn.setKey(String.valueOf(subMenu.getMenuKey()));
			btn.setType(subMenu.getMenuType());
			return btn;
		} else {
			ViewButton btn = new ViewButton();
			btn.setName(subMenu.getMenuName());
			btn.setUrl(subMenu.getMenuUrl());
			btn.setType(subMenu.getMenuType());
			return btn;
		}
	}

	@Override
	public Menu getMenuList(int wxId) {
		// 找到顶级菜单
		// 根据wxId找到微信原始ID
		WeixinAccount acc = this.wxAccountDAO.findById(wxId);
		List<MenusBean> parentMenus = this.findMenus(" and parentId=0",
				acc.getWxFromUserName());
		List<Button> menuObj = new ArrayList<Button>();
		for (int i = 0; i < parentMenus.size(); i++) {
			ComplexButton mainBtn = new ComplexButton();
			mainBtn.setName(parentMenus.get(i).getMenuName());
			// 找到对应的子菜单
			List<MenusBean> subMenus = this.findMenus(" and parentId="
					+ parentMenus.get(i).getId(), acc.getWxFromUserName());
			Button[] subBtn = null;
			if (subMenus != null && subMenus.size() > 0) {// 含有子菜单
				subBtn = new Button[subMenus.size()];
				for (int n = 0; n < subMenus.size(); n++) {
					MenusBean mb = subMenus.get(n);
					// 默认菜单的跳转地址为带有菜单ID的固定链接
					// 当菜单的指向不是本站点时直接指向目的地址
					if (mb.getMenuType().compareTo("view") == 0
					/*
					 * && mb.getMenuUrl().indexOf(
					 * this.myConstant.getWeixin_web()) >= 0
					 */) {
						mb.setMenuUrl(this.myConstant.getWeixin_web()
								+ "wxm/click?mid=" + mb.getId());
					}
					if (mb.getMenuUrl()
							.indexOf(this.myConstant.getWeixin_web()) >= 0)
						mb.setMenuUrl(this.AddParam(mb.getMenuUrl(), wxId));
					subBtn[n] = this.createButton(mb);
				}
				mainBtn.setSub_button(subBtn);
				menuObj.add(mainBtn);
			} else// 没有子菜单
			{
				if (parentMenus.get(i).getMenuType().equals("click")
						|| parentMenus.get(i).getMenuType().equals("view")) {
					MenusBean mb = parentMenus.get(i);

					Button noSubMainBtn = this.createButton(mb);
					if (mb.getMenuType().compareTo("view") == 0
					/*
					 * && mb.getMenuUrl().indexOf(
					 * this.myConstant.getWeixin_web()) >= 0
					 */) {
						mb.setMenuUrl(this.myConstant.getWeixin_web()
								+ "wxm/click?mid=" + mb.getId());
					}
					if (mb.getMenuUrl()
							.indexOf(this.myConstant.getWeixin_web()) >= 0)
						mb.setMenuUrl(this.AddParam(mb.getMenuUrl(), wxId));
					menuObj.add(noSubMainBtn);
				}
			}
		}
		Menu menu = new Menu();
		Button[] buttons = new Button[menuObj.size()];
		for (int m = 0; m < menuObj.size(); m++) {
			buttons[m] = menuObj.get(m);
		}
		menu.setButton(buttons);
		return menu;

	}

	private String AddParam(String menuUrl, int wxId) {
		if (menuUrl != null && menuUrl.length() > 0) {
			if (menuUrl.indexOf('?') > 0)
				return menuUrl + "&wid=" + wxId;
			else
				return menuUrl + "?wid=" + wxId;
		} else
			return menuUrl;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int DeleteMenu(int id) {
		List<MenuDefine> md = this.menuDAO.findMenus(" where id=" + id, null);
		if (md != null && md.size() > 0) {
			this.menuDAO.delete(id);
			return 0;
		}
		return -1;
	}

	/******************* 菜单部分开始结束 **********************/

	/**************** 版本合并截止 ****************/

	/**
	 * 找到对应的顾客，更新取消订阅时间，最后交互时间
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void unSubscribe(Map<String, String> requestMap) {
		String account = requestMap.get(MessageUtil.REQ_MESSAGE_ACCOUNT);
		String createTime = requestMap.get(MessageUtil.REQ_MESSAGE_TIME);
		Customer customer = this.customerDAO.findByName(account);
		customer.setUnSubscribeTime(createTime);
		customer.setLastVisit(createTime);
		this.customerDAO.update(customer);
	}

	/**
	 * 订阅时，分两种情况： 1、第一次访问 保存订阅时间，openID 2、非第一次访问 保存
	 * 找到对应的对应的openID,更新订阅时间，把取消订阅时间置为null
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void subscribe(Map<String, String> requestMap) {
		String account = requestMap.get(MessageUtil.REQ_MESSAGE_ACCOUNT);
		String createTime = requestMap.get(MessageUtil.REQ_MESSAGE_TIME);
		Customer customer = this.customerDAO.findByName(account);
		if (null == customer) {
			Customer cus = new Customer(account, createTime, null, createTime,
					null, null, null);
			this.customerDAO.save(cus);
		} else {
			customer.setLastVisit(createTime);
			customer.setSubscribeTime(createTime);
			this.customerDAO.update(customer);
		}
	}

	/**
	 * 
	 */
	public Customer findByAccount(String openId) {
		return this.customerDAO.findByName(openId);
	}

	/**
	 * 
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void addCustomer(Map<String, String> requestMap) {
		Customer customer = new Customer(
				requestMap.get(MessageUtil.REQ_MESSAGE_ACCOUNT));
		this.customerDAO.save(customer);
	}

	/**
	 * 保存发送者信息，更新时间、地理位置
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveMessage(Map<String, String> requestMap, Customer cus) {
		String msgType = requestMap.get(MessageUtil.REQ_MESSAGE_TYPE);
		ReqMessage reqMessage = new ReqMessage();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeStamp = Long.parseLong(requestMap
				.get(MessageUtil.REQ_MESSAGE_TIME));
		reqMessage.setCreateTime(sdf.format(new Date(timeStamp * 1000)));
		reqMessage.setMsgType(msgType);
		reqMessage.setCustomer(cus);

		// if (msgType.compareTo(MessageUtil.REQ_MESSAGE_TYPE_TEXT)==0) {
		reqMessage.setContent(requestMap.get(MessageUtil.REQ_MESSAGE_DETAIL));
		// }
		this.reqMessageDAO.save(reqMessage);
	}

	/**
	 * 更新最后访问时间
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCustomer(Customer cus, Map<String, String> requestMap) {
		String time = requestMap.get(MessageUtil.REQ_MESSAGE_TIME);
		String msgType = requestMap.get(MessageUtil.REQ_MESSAGE_TYPE);
		cus.setLastVisit(time);
		if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION == msgType) {
			cus.setLocation_x(requestMap.get(MessageUtil.REQ_MESSAGE_LX));
			cus.setLocation_y(requestMap.get(MessageUtil.REQ_MESSAGE_LY));
			cus.setLabel(requestMap.get(MessageUtil.REQ_MESSAGE_LABEL));
		}
		this.customerDAO.update(cus);
	}

	@Override
	public List<NewsBean> findAllNews() {
		List<Article> aticleList = this.articleDAO.findAll();
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		if (aticleList.size() > 0) {
			for (Article aticle : aticleList) {
				NewsBean news = new NewsBean(aticle.getTitle(),
						aticle.getDescription(), aticle.getPicUrl(),
						aticle.getUrl());
				news.setNews_id(aticle.getArticleId());
				newsList.add(news);
			}
		}
		if (newsList.size() > 0) {
			return newsList;
		}
		return null;
	}

	@Override
	public NewsBean findNewsById(Integer news_id) {
		Article article = this.articleDAO.get(news_id);
		if (null != article) {
			NewsBean news = new NewsBean(article.getTitle(),
					article.getDescription(), article.getPicUrl(),
					article.getUrl());
			news.setNews_id(article.getArticleId());
			news.setId(news_id);
			return news;
		}
		return null;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateNews(NewsBean news) {
		Article article = this.articleDAO.get(news.getId());
		if (null != article) {
			article.setDescription(news.getDescription());
			article.setPicUrl(news.getPic_url());
			article.setTitle(news.getTitle());
			article.setUrl(news.getUrl());
			article.setSeq(news.getSeq());
			this.articleDAO.update(article);
		} else {
			// TODO 构建应用自身的异常体系，此处就是没找到类
		}
	}

	@Override
	public KeyDefine findKey(int key_id) {
		KeyDefine key = this.keysDAO.get(key_id);
		return key;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int DeleteKey(int id) {
		KeyDefine key = this.keysDAO.get(id);
		if (key != null) {
			this.keysDAO.delete(key);
			return 0;
		} else
			return -1;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int UpdateKey(KeyDefine key) {
		this.keysDAO.update(key);
		return 0;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int AddKey(KeyDefine key) {
		return this.keysDAO.save(key);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateLocation(String fromUserName, String toUserName,
			String latitude, String longitude) {
		Customer cust = this.customerDAO.findByName(fromUserName);
		if (cust == null)
			cust = new Customer();
		cust.setFromUserName(fromUserName);
		cust.setLastVisit(String.valueOf(new Date().getTime()));
		cust.setLocation_x(latitude);
		cust.setLocation_y(longitude);
		if (cust == null)
			this.customerDAO.save(cust);
		else
			this.customerDAO.update(cust);
	}

	@Override
	public Special getNextSpecial(int id, String wxAccount) {
		return this.specialDAO.getNext(id, wxAccount);
	}

	@Override
	public Special getPrevSpecial(int id, String wxAccount) {
		return this.specialDAO.getPrev(id, wxAccount);
	}

}
