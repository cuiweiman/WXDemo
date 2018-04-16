package com.wx.service;

import java.util.List;

import com.wx.entity.Fault;

/**
 * 故障类 业务逻辑层
 * @author 崔为满
 * @date 2018年3月29日 上午11:17:23
 */

public interface FaultService {
	
	/**
	 * 添加故障内容
	 * @param fault 故障实体类对象
	 */
	public void addFault(Fault fault);
	
	
	
	/**
	 * 根据居民id查询该居民汇报的故障
	 * @param rid 居民id
	 * @return
	 */
	public List<Fault> findFaultList(String rid);
	
	
	
	/**
	 * 根据故障id获取故障详情
	 * @param fid
	 * @return
	 */
	public Fault findFaultById(String fid);
	
	
	
}
