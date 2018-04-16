package com.wx.service.impl;

import java.util.List;

import com.wx.dao.ArticleDao;
import com.wx.entity.Article;
import com.wx.service.ArticleService;



/**
 * 文章 业务逻辑层接口实现
 * @author 崔为满
 * @date 2018年3月28日 下午5:14:47
 */
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public List<Article> getArticleList(String cid) {

		return articleDao.getArticleList(cid);
	}

	@Override
	public List<Article> getAllArticleList(String cid) {

		return articleDao.getAllArticleList(cid);
	}

	@Override
	public Article getArticleById(String aid) {
		
		return articleDao.getArticleById(aid);
	}

}
