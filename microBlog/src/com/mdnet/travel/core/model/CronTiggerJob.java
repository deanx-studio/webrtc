package com.mdnet.travel.core.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronTiggerJob {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected boolean pause = false;
	protected String sitemapPath;
	protected String sitemapUrl;

	public String getSitemapPath() {
		return sitemapPath;
	}

	public void setSitemapPath(String sitemapPath) {
		this.sitemapPath = sitemapPath;
	}

	public String getSitemapUrl() {
		return sitemapUrl;
	}

	public void setSitemapUrl(String sitemapUrl) {
		this.sitemapUrl = sitemapUrl;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void work() {

		String xml = HTTPMessage.Send(this.sitemapUrl, "");

		try {
			FileOutputStream writer = new FileOutputStream(this.sitemapPath);
			writer.write(xml.getBytes());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("sitemap URL:" + this.sitemapUrl + ";xml length:"
				+ xml.length());
	}

}
