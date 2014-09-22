package com.mdnet.travel.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mdnet.travel.core.dao.GroupDateDAO;
import com.mdnet.travel.core.dao.PersonalCustomDAO;
import com.mdnet.travel.core.dao.WeixinAccountDAO;
import com.mdnet.travel.core.model.GroupDate;
import com.mdnet.travel.core.model.PersonalCustom;
import com.mdnet.travel.core.service.ICustomService;
import com.mdnet.travel.core.service.IMessageService;

@Service(ICustomService.SERVICE_NAME)
@Scope("prototype")
public class CustomServiceImpl implements ICustomService {

	@Resource(name = PersonalCustomDAO.DAO_NAME)
	protected PersonalCustomDAO personalDAO;
	@Resource(name = GroupDateDAO.DAO_NAME)
	protected GroupDateDAO groupDateDAO;

	@Override
	public void savePrivate_Dest(String sid, String[] national,
			String[] cities, String[] goal) {
		PersonalCustom pc = this.getPersonal(sid);
		boolean isUpdate = true;
		if (pc == null) {
			isUpdate = false;
			pc = new PersonalCustom();
			pc.setState(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pc.setMakeTime(sdf.format(new Date()));

		}
		pc.setSessionID(sid);
		String cityNames = array2str(cities);
		pc.setCities(cityNames);
		pc.setGoal(array2str(goal));
		String strNational = array2str(national);
		pc.setNational(strNational);
		if (!isUpdate)
			personalDAO.save(pc);
		else
			personalDAO.update(pc);
	}

	public String array2str(String[] array) {
		String result = "";
		for (int i = 0; array != null && i < array.length; i++) {
			result += array[i] + ",";
		}
		return result;
	}

	@Override
	public void updatePersonal(PersonalCustom personal) {
		personalDAO.update(personal);
	}

	@Override
	public PersonalCustom getPersonal(String sid) {
		return personalDAO.getPersonalBySession(sid);
	}

	@Override
	public List<PersonalCustom> findall(int page, int count, int sType,
			String context) {
		return this.personalDAO.findAll(page, count, sType, context);
	}

	@Override
	public List<GroupDate> getGroupList(String where, int page) {

		return this.groupDateDAO.getList(where, page);
		// else
		// return this.groupDateDAO.getList("where productId=" + pid, page);
	}

	@Override
	public List<PersonalCustom> getPersonalByMobile(String mobile, int page) {
		return personalDAO.findAll(page, 20, 0, mobile);
	}

	@Override
	public List<PersonalCustom> getPersonals(String sid, int page) {
		return this.personalDAO.findAll(page, 20, 2, sid);
	}

	@Override
	public int AddGroup(String groupName, String productName, String startDate,
			int productId, int bookCount, int totalCount) {
		GroupDate entity = new GroupDate();
		entity.setBookCount(bookCount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String makeTime = sdf.format(new Date());
		entity.setMakeTime(makeTime);
		entity.setProductId(productId);
		entity.setProductName(groupName);
		entity.setStartDate(startDate);
		entity.setTotalCount(totalCount);
		return this.groupDateDAO.save(entity);
	}

	@Override
	public int UpdateGroup(int groupId, String groupName, String productName,
			String startDate, int productId, int bookCount, int totalCount) {
		GroupDate entity = this.groupDateDAO.get(groupId);
		entity.setBookCount(bookCount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String makeTime = sdf.format(new Date());
		entity.setMakeTime(makeTime);
		entity.setProductId(productId);
		entity.setProductName(groupName);
		entity.setStartDate(startDate);
		entity.setTotalCount(totalCount);
		this.groupDateDAO.update(entity);
		return 0;

	}

	@Override
	public int deleteGroup(int groupId) {
		GroupDate entity = this.groupDateDAO.get(groupId);
		if (entity != null)
			this.groupDateDAO.delete(entity);
		return groupId;
	}

	@Override
	public String markGroupFull(int groupId) {
		GroupDate entity = this.groupDateDAO.get(groupId);
		entity.setBookCount(entity.getTotalCount());
		this.groupDateDAO.update(entity);
		Gson g = new Gson();
		return g.toJson(entity);
	}

}
