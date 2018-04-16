package com.wx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wx.dao.NoticeDao;
import com.wx.entity.Notice;

/**
 * 通知持久层实现。
 * @author 崔为满
 * @date 2018年3月27日 下午3:04:54
 */
public class NoticeDaoImpl implements NoticeDao {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	
	public List<Notice> getNoticeList(String cid){
	
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectList(Notice.class.getName()+".findNoticeByCommunityId", cid);
	
	}
	
	
	
	public Notice getNoticeById(String nid){
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne(Notice.class.getName()+".findNoticeById", nid);
	
	}



	@Override
	public Notice getNoticeNew(String cid) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession.selectOne(Notice.class.getName()+".findNoticeNew", cid);
	}
	
	
	
}





