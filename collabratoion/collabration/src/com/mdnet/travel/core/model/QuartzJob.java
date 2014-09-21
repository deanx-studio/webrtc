package com.mdnet.travel.core.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdnet.asterisk.ami.AMIBase;
import com.mdnet.travel.core.service.ICallService;
import com.mdnet.travel.core.service.impl.CallServiceImpl;

public class QuartzJob {

	public static int quartzCount;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService _callService;
	public static ICallService callService = null;

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public void work() {
		if (QuartzJob.callService == null)
			QuartzJob.callService =  this._callService;
		//logger.info("定时器到时处理。");
		AMIBase.instance().checkConnect();
	}
}
