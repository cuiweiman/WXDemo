package com.wx.service.impl;

import java.util.List;

import com.wx.dao.CommunityDao;
import com.wx.entity.Community;
import com.wx.service.CommunityService;

public class CommunityServiceImpl implements CommunityService {
	
	private CommunityDao communityDao;
	
	public void setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
	}

	@Override
	public List<Community> getCommunityList(String rid) {

		return communityDao.getCommunityList(rid);
	}

	@Override
	public List<Community> getCommunity() {
		
		return communityDao.getCommunity();
	}


}
