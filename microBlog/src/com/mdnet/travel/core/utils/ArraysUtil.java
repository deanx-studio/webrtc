package com.mdnet.travel.core.utils;

import java.util.ArrayList;
import java.util.List;

import com.mdnet.travel.core.model.Article;

public class ArraysUtil {

	/**
	 * 按指定顺序重排list对象
	 * 
	 * @param articleList
	 * @param pointer
	 * @return
	 */
	public static List<Article> getOlArray(List<Article> articleList) {
		List<Article> o_articleList = new ArrayList<Article>();

		for (Article article : articleList) {

			Article art = article;
			if (null != art) {
				o_articleList.add(art);
			}

		}
		return o_articleList;
	}

}
