package com.wx.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.ResidentDao;
import com.wx.entity.Resident;

public class ResidentDaoImpl implements ResidentDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	@Override
	public Resident getResidentByTelPass(Resident resident) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne(Resident.class.getName()+".getResidentByTelPass",resident);
				
	}

	
	@Override
	public void addResident(Resident resident) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert(Resident.class.getName()+".addResident", resident);
		
		sqlSession.close();
	}
	
	

	@Override
	public void updateResidentPass(Resident resident) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update(Resident.class.getName()+".updateResidentPass", resident);
		
		sqlSession.close();
	}


	@Override
	public Resident findResidentByTel(String tel) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne(Resident.class.getName()+".getResidentByTel",tel);
		
	}



}
