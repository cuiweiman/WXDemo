package com.wx.service.impl;

import com.wx.dao.MiddleDao;
import com.wx.entity.Middle;
import com.wx.service.MiddleService;

public class MiddleServiceImpl implements MiddleService {
	
	private MiddleDao middleDao;
	
	public void setMiddleDao(MiddleDao middleDao) {
		this.middleDao = middleDao;
	}
	

	@Override
	public void addMiddle(Middle middle) {
		middleDao.addMiddle(middle);
		
	}

}
