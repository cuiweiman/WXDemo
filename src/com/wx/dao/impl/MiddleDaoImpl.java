package com.wx.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.MiddleDao;
import com.wx.entity.Middle;

public class MiddleDaoImpl implements MiddleDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	@Override
	public void addMiddle(Middle middle) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert(Middle.class.getName()+".addMiddle", middle);
		sqlSession.close();
		
	}

}
