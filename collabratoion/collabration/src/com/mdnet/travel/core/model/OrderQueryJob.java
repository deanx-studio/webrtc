package com.mdnet.travel.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderQueryJob {

	protected boolean pause = false;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void work() {
		logger.info("定时器到时。");
	}
}
