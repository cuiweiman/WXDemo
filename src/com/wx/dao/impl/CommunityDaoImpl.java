package com.wx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.CommunityDao;
import com.wx.entity.Community;

public class CommunityDaoImpl implements CommunityDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	@Override
	public List<Community> getCommunityList(String rid) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList(Community.class.getName()+".findCommunityListByRid", rid);
	}


	@Override
	public List<Community> getCommunity() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList(Community.class.getName()+".findCommunityList");
	}



}










