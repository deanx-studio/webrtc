package com.mdnet.travel.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.mdnet.travel.core.model.Customer;
import com.mdnet.travel.core.model.KeyDefine;
import com.mdnet.travel.core.model.Media;
import com.mdnet.travel.core.model.Special;
import com.mdnet.travel.core.vo.KeysBean;
import com.mdnet.travel.core.vo.MenusBean;
import com.mdnet.travel.core.vo.NewsBean;
import com.mdnet.travel.core.vo.SpecialBean;
import com.mdnet.travel.core.vo.SpecialInfo;
import com.mdnet.travel.core.vo.UserListBean;
import com.mdnet.travel.core.weixin.pojo.Menu;

public interface IMessageService {

	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.MessageServiceImpl";

	int updateArticleState(int articleId, int state);
	
	List<KeysBean> findAllKeys(String et, String string);
	
	int addNews(NewsBean news, String weixinId);

	List<NewsBean> findAllNews(int pageNo, String search, String weixinId);
	
	int deleteNews(int news_id);

	SpecialBean GetSpecial(int id);
	
	List<SpecialBean> findSpecial(String query, int page, int length);
	
	SpecialInfo[] GetContentList(SpecialBean sb);
	
	int updateSpecial(int id, String title, String writer, String align,
			String content);
	
	int AddSpecial(String title, String writer, String align, String weixinId);
	
	int updateSpecialState(int id, String state);
	
	int DeleteSpecial(int id);
	
	int upload(String title, MultipartFile file, String path, String weixinId);
	
	int deleteMedia(int id);
	
	List<Media> findMedia(int page, int count, String t, String search, String string);
	
	int UpdateMedia(String id, String title);
	
	MenusBean findMenuById(int id);
	
	List<KeyDefine> findKeyValue(int key_id, String weixinId);
	
	void updateMenu(MenusBean menu, String weixinId);
	
	Menu getMenuList(int wxId);
	
	int DeleteMenu(int id);
	
	NewsBean findNewsByArticleId(int articleId, String weixinId);
	
	KeyDefine findKey(int key_id);
	
	int DeleteKey(int id);
	
	int AddKey(KeyDefine key);
	
	int UpdateKey(KeyDefine key);
	/*******************合并截止***********************/
	
	void unSubscribe(Map<String, String> requestMap);

	void subscribe(Map<String, String> requestMap);

	Customer findByAccount(String account);

	void addCustomer(Map<String, String> requestMap);

	void saveMessage(Map<String, String> requestMap, Customer cus);

	void updateCustomer(Customer cus, Map<String, String> requestMap);

	List<NewsBean> findAllNews();

	NewsBean findNewsById(Integer news_id);

	void updateNews(NewsBean news);

	int AddMenu(MenusBean menu, String weixinId);

	List<MenusBean> findMenus(String where, String weixinId);

	void updateLocation(String fromUserName, String toUserName,
			String latitude, String longitude);

	Special getNextSpecial(int id, String wxAccount);

	Special getPrevSpecial(int id, String wxAccount);
	
}
