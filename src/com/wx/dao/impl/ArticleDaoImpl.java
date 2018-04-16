package com.wx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.ArticleDao;
import com.wx.entity.Article;


/**
 * 文章 持久层接口实现
 * @author 崔为满
 * @date 2018年3月28日 下午4:59:27
 */
public class ArticleDaoImpl implements ArticleDao {
	
	
	private SqlSessionFactory sqlSessionFactory ;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	

	@Override
	public List<Article> getArticleList(String cid) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList(Article.class.getName()+".findArticleByCommunityId", cid);
		
	}

	
	
	
	
	@Override
	public List<Article> getAllArticleList(String cid) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList(Article.class.getName()+".findAllArticleByCommunityId", cid);
		
	}




	@Override
	public Article getArticleById(String aid) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne(Article.class.getName()+".findArticleById", aid);
	}

}
