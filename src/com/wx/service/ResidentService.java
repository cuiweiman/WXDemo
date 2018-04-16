package com.wx.service;

import com.wx.entity.Resident;

/**
 * 居民类 业务逻辑层接口
 * @author 崔为满
 * @date 2018年3月30日 下午3:15:38
 */

public interface ResidentService {


	/**
	 * 根据用户电话和密码查询用户是否存在——用于居民登录
	 * @param tel
	 * @param password
	 */
	public Resident getResidentByTelPass(Resident resident);
	
	
	
	
	/**
	 * 添加居民信息——用于居民个人注册
	 * @param resident
	 */
	public void addResident(Resident resident);
	
	
	
	/**
	 * 根据用户手机号码修改用户的密码、忘记密码
	 * @param tel
	 * @param password
	 */
	public void updateResidentPass(Resident resident);
	
	
	
	
	
	/**
	 * 根据手机号码查询居民的密码，以便修改密码
	 * @param tel
	 * @return
	 */
	public Resident findResidentByTel(String tel);
	
	
}
