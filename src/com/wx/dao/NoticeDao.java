package com.wx.dao;

import java.util.List;

import com.wx.entity.Notice;

/**
 * 通知 持久层接口
 * @author 崔为满
 * @date 2018年3月27日 下午3:05:38
 */
public interface NoticeDao {

	/**
	 * 根据社区id按照时间倒叙查询通知列表
	 * @param cid
	 * @return
	 */
	public List<Notice> getNoticeList(String cid); 
	
	
	
	/**
	 * 根据通知ID获取该通知的详情
	 * @param cid
	 * @return
	 */
	public Notice getNoticeById(String nid);
	
	
	
	
	
	/**
	 * 根据社区ID获取该社区发布的最新的通知
	 * @param cid
	 * @return
	 */
	public Notice getNoticeNew(String cid);
	
}
