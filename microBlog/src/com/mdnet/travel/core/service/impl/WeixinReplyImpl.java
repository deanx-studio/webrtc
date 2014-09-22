package com.mdnet.travel.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.dao.ArticleDAO;
import com.mdnet.travel.core.dao.WeixinAccountDAO;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.WeixinReplyProxy;
import com.mdnet.travel.core.utils.ArraysUtil;
import com.mdnet.travel.core.utils.FileOperationUtil;
import com.mdnet.travel.core.weixin.pojo.Article;

@Service(WeixinReplyProxy.SERVICE_NAME)
@Scope("prototype")
@Transactional(readOnly = true)
public class WeixinReplyImpl implements WeixinReplyProxy {

	@Resource(name = ArticleDAO.DAO_NAME)
	protected ArticleDAO articleDAO;
	
	@Resource(name = WeixinAccountDAO.DAO_NAME)
	protected WeixinAccountDAO wxAccountDAO;
	

	public List<Article> getArticles(String id, String toUserName) {

		if (StringUtils.isNotBlank(id)) {
			List<com.mdnet.travel.core.model.Article> articleList = this.articleDAO
					.findByIds(id, toUserName);
			// List<com.mdnet.travel.core.model.Article> or_articleList =
			// ArraysUtil.getOlArray(articleList,pointer);
			//this.
			WeixinAccount acc = this.wxAccountDAO.find(toUserName);
			int wid = acc.getAccountId();
			List<Article> w_articleList = new ArrayList<Article>();
			for (com.mdnet.travel.core.model.Article article : articleList) {
				Article arc = new Article();
				arc.setDescription(article.getDescription());
				arc.setPicUrl(article.getPicUrl());
				arc.setTitle(article.getTitle());
				arc.setUrl(article.getUrl());
				arc.setWid(wid);
				w_articleList.add(arc);
			}
			return w_articleList;
		}
		return null;
	}

}
