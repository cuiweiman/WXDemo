package com.wx.service.impl;

import java.util.List;

import com.wx.dao.NoticeDao;
import com.wx.entity.Notice;
import com.wx.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	
	@Override
	public List<Notice> getNoticeList(String cid) {
		return noticeDao.getNoticeList(cid);
	}


	@Override
	public Notice getNoticeById(String nid) {
		
		return noticeDao.getNoticeById(nid);
	}


	@Override
	public Notice getNoticeNew(String cid) {
		
		return noticeDao.getNoticeNew(cid);
	}

}
