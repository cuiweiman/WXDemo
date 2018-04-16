package com.wx.service;

import java.util.List;

import com.wx.entity.Article;

/**
 * 文章 业务逻辑层 接口
 * @author 崔为满
 * @date 2018年3月28日 下午5:12:41
 */

public interface ArticleService {
	
	
	/**
	 * 根据社区id 查询该社区发布的文章，只查询最新的三篇以便首页展示
	 * @param cid
	 * @return
	 */
	public List<Article> getArticleList(String cid);
	
	
	
	
	/**
	 * 根据社区id 查询该社区发布的所有文章，列表展示
	 * @param cid
	 * @return
	 */
	public List<Article> getAllArticleList(String cid); 
	
	
	
	
	/**
	 * 根据文章id 查询文章详情
	 * @param cid
	 * @return
	 */
	public Article getArticleById(String aid);
	
	
}
