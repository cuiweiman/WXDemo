package com.wx.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 居民类 对象
 * @author 崔为满
 * @date 2018年3月28日 下午6:03:56
 */
public class Resident {
	
	private String id;
	private String name;
	private String tel;
	private String password;
	private String sex;
	private String f_add;
	private String s_add;
	private String t_add;
	private String province;
	private String city;
	private String county;
	private List<Fault> faultList=new ArrayList<Fault>();
	
	public Resident() {}

	public String getId() {
		return id;
	}

	public void setId() {		
		this.id=UUID.randomUUID().toString().replace("-", "").substring(0, 18);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getF_add() {
		return f_add;
	}

	public void setF_add(String f_add) {
		this.f_add = f_add;
	}

	public String getS_add() {
		return s_add;
	}

	public void setS_add(String s_add) {
		this.s_add = s_add;
	}

	public String getT_add() {
		return t_add;
	}

	public void setT_add(String t_add) {
		this.t_add = t_add;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}
	
	public List<Fault> getFaultList() {
		return faultList;
	}

	@Override
	public String toString() {
		return "Resident [id=" + id + ", name=" + name + ", tel=" + tel + ", password=" + password + ", sex=" + sex
				+ ", f_add=" + f_add + ", s_add=" + s_add + ", t_add=" + t_add + ", province=" + province + ", city="
				+ city + ", county=" + county + ", faultList=" + faultList + "]";
	}
	
	
	
	
	
	
	
	
}
