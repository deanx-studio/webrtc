package com.mdnet.travel.core.service;

import java.util.List;

import com.mdnet.travel.core.weixin.pojo.Article;

public interface WeixinReplyProxy {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.WeixinReplyImpl";

	List<Article> getArticles(String pointer, String toUserName);
}
