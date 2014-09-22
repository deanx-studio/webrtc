package com.mdnet.travel.core.service;

import java.util.List;

import com.mdnet.travel.core.model.MetaKeys;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.vo.FindPassVO;
import com.mdnet.travel.core.vo.MemberInfoVO;
import com.mdnet.travel.core.vo.ResetMobileVO;
import com.mdnet.travel.core.vo.ResetPassVO;
import com.mdnet.travel.core.vo.UserListBean;


public interface ITravelerService {

	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.TravelerServiceImpl";

	Integer saveTraveler(String username, String pass, String mobile, String openId, String role, String wxFromUserName, String travelerId);

	//根据微信的from user name获取手机号码
	Traveler findFromUserName(String fromUserName);
	
	String findMobile(String username);
	
	Integer findPrimaryKey(String username);

	String resetPassByUser(ResetPassVO passInfo, String username);

	String saveValidCode(String username,String mobile, String validCode);

	String resetMobileByUser(ResetMobileVO mobiles, String username);

	MemberInfoVO findUserByMobile(String mobile);

	String findPassOrUser(FindPassVO findInfo);

	String findValidCodeByMobile(String mobile);
	
	String findValidateCodeByMobileAndName(String username,String mobile);
	
	Traveler findTravelByOpenId(String openId);

	String findMobileByOpenId(String openId);

	List<UserListBean> findAdmin(int pageNo, String role);
	
	UserListBean findTravelerById(int travelerId);

	//List<WeixinAccount> findWXAccounts(int pageNo);

	boolean checkUsename(int travelerId, String username);

	int deleteUser(int id);

	Traveler findTravelerByUname(String uname);

	String getMetaKeys(String uri);

	List<MetaKeys> getAllMetaKeys(int page);

	String saveMetaKeys(int id, String newKeys);

	MetaKeys getMetaKeysByUri(String valueOf);

	MetaKeys updateMetaKeys(String uri, String newKeys);

}
