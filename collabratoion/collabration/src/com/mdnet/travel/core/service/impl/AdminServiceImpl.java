package com.mdnet.travel.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.ParamConfig;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdnet.travel.core.dao.IParamConfigDAO;
import com.mdnet.travel.core.dao.IUserInfoDAO;
import com.mdnet.travel.core.service.IAdminService;
import com.mdnet.travel.core.utils.EncryptSpring;

@Service(IAdminService.SERVICE_NAME)
@Scope("singleton")
@Transactional(readOnly = false)
public class AdminServiceImpl implements IAdminService {

	@Resource(name = IUserInfoDAO.DAO_NAME)
	protected IUserInfoDAO userDAO;

	@Resource(name = IParamConfigDAO.DAO_NAME)
	protected IParamConfigDAO paramsDAO;

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public int deleteUser(int id) {
		UserInfo ui = this.userDAO.get(id);
		if (ui != null)
			this.userDAO.delete(ui);
		return 0;
	}

	@Override
	public List<UserInfo> findAdmin(int pageNo) {

		List<UserInfo> userInfos = this.userDAO.findByHQL("", pageNo);

		return userInfos;
	}

	@Override
	public int checkUsename(String username) {
		List<UserInfo> ui = this.userDAO.findByHQL(" where username='"
				+ username + "'", 0);

		if (ui != null && ui.size() > 0
				&& ui.get(0).getUsername().compareTo(username) == 0)
			return ui.get(0).getId();
		else
			return 0;
	}

	@Override
	public int insertUserInfo(String username, String passWd, String mobile,
			String role, String terminateNumber) {
		UserInfo ui = new UserInfo();
		ui.setAuthority(role);

		ui.setMakeTime(sdf.format(new Date()));
		ui.setMobile(mobile);
		ui.setPassword(EncryptSpring.md5_32(passWd));
		ui.setRole(role);
		ui.setTerminateNumber(terminateNumber);
		ui.setUsername(username);
		this.userDAO.save(ui);
		return ui.getId();
	}

	@Override
	public int updateUserInfo(int uid, String username, String passWd,
			String mobile, String role, String terminateNumber) {
		UserInfo ui = this.userDAO.get(uid);
		ui.setMakeTime(sdf.format(new Date()));
		ui.setMobile(mobile);
		if (passWd != null && passWd.length() > 0)
			ui.setPassword(EncryptSpring.md5_32(passWd));

		ui.setRole(role);
		ui.setAuthority(role);
		ui.setTerminateNumber(terminateNumber);
		ui.setUsername(username);
		this.userDAO.update(ui);
		return 0;// TODO Auto-generated method stub

	}

	@Override
	public UserInfo getUserInfo(String name) {
		List<UserInfo> uis = this.userDAO.findByHQL(" where username='" + name
				+ "'", 0);
		if (uis != null && uis.size() > 0)
			return uis.get(0);
		return null;
	}

	@Override
	public List<ParamConfig> getParams() {
		return paramsDAO.findAll();
	}

	@Override
	public void setParam(String paramKey, String keyValue, String keyDesc) {
		this.paramsDAO.setParam(paramKey, keyValue, keyDesc);
	}

	@Override
	public void setParam(String paramKey, int keyValue, String keyDesc) {
		this.paramsDAO.setParam(paramKey, String.valueOf(keyValue), keyDesc);
	}

	@Override
	public String getParam(String paramKey) {
		return this.paramsDAO.getValue(paramKey);
	}

	@Override
	public void reloadParam() {

		ParamConfigInstance.inst().setAmiPort(
				Integer.parseInt(paramsDAO.getValue("amiPort")));
		ParamConfigInstance.inst()
				.setAmiServer(paramsDAO.getValue("amiServer"));
		ParamConfigInstance.inst().setAmiUsername(
				paramsDAO.getValue("amiUsername"));
		ParamConfigInstance.inst().setAmiSecrect(
				paramsDAO.getValue("amiSecrect"));

		ParamConfigInstance.inst().setDomain(paramsDAO.getValue("domain"));
		ParamConfigInstance.inst().setWebsocket_proxy_url(
				paramsDAO.getValue("websocket_proxy_url"));
		ParamConfigInstance.inst().setOutbound_proxy_url(
				paramsDAO.getValue("outbound_proxy_url"));
		ParamConfigInstance.inst().setIce_servers(paramsDAO.getValue("ICE"));
		ParamConfigInstance.inst().setRealm(paramsDAO.getValue("realm"));

	}

}