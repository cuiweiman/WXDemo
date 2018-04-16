package com.wx.dao;

import java.util.List;

import com.wx.entity.Community;

/**
 * 社区 持久层接口
 * @author 崔为满
 * @date 2018年3月29日 下午1:40:23
 */
public interface CommunityDao {
	

	/**
	 * 根据 社区居民ID 获取该居民所处的社区信息列表
	 * @param rid
	 * @return
	 */
	public List<Community > getCommunityList(String rid);
	
	
	
	
	
	/**
	 * 获取社区的id和名称
	 * @return
	 */
	public List<Community> getCommunity();
}
