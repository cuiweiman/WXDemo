package com.wx.service;

import java.util.List;

import com.wx.entity.Notice;

/**
 * 通知 业务逻辑层接口
 * @author 崔为满
 * @date 2018年3月27日 下午3:42:35
 */
public interface NoticeService {
	
	/**
	 * 根据社区ID获取该社区发布的所有通知
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
