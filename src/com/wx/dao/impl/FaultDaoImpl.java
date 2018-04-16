package com.wx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.FaultDao;
import com.wx.entity.Fault;

public class FaultDaoImpl implements FaultDao {
	
	private SqlSessionFactory SqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		SqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void addFault(Fault fault) {
		
		SqlSession sqlSession=SqlSessionFactory.openSession();
		sqlSession.insert(Fault.class.getName()+".addFault", fault);
		sqlSession.close();
		
	}

	@Override
	public List<Fault> findFaultList(String rid) {

		SqlSession sqlSession=SqlSessionFactory.openSession();
		return sqlSession.selectList(Fault.class.getName()+".findFaultByResidentId", rid);
	}

	@Override
	public Fault findFaultById(String fid) {
		
		SqlSession sqlSession=SqlSessionFactory.openSession();
		return sqlSession.selectOne(Fault.class.getName()+".findFaultById", fid);
	}

}
