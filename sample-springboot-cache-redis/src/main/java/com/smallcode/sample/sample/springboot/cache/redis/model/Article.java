package com.smallcode.sample.sample.springboot.cache.redis.model;

import java.io.Serializable;

/**
 * @Auther: lenny
 * @Date: 2018/12/1 23:29
 * @Description:
 */
public class Article implements Serializable {

	private Integer id;

	private String title;

	private String articleTag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleTag() {
		return articleTag;
	}

	public void setArticleTag(String articleTag) {
		this.articleTag = articleTag;
	}
}
