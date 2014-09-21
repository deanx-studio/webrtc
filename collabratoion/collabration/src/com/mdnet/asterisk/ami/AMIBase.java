package com.mdnet.asterisk.ami;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AMIBase {
	protected static AMIBase instObj = null;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected AMISocket socket = new AMISocket("deanx.cn", 5039);

	protected AMIBase() {

	}

	public static AMIBase instance() {
		if (instObj == null)
			instObj = new AMIBase();
		return instObj;
	}

	public void run() {
		logger.info("AMIBase had started!");
		socket.connect();
	}

	public void checkConnect() {
		//logger.info("AMIBase checked!");
		socket.reconnect();
	}

	public int sendAction(ActionMsg msg) {
		return 1;
	}
}