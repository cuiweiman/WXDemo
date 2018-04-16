package com.wx.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 社区类 对象
 * @author 崔为满
 * @date 2018年3月28日 下午4:56:35
 */

public class Community {
	
	private String id;
	private String name;
	private String address;
	private String property;
	private String phone;
	private String province;
	private String city;
	private String county;
	private String water;
	private String electric;
	private List<Notice> noticeList=new ArrayList<Notice>();
	private List<Article> articleList=new ArrayList<Article>();
	
	public Community() {}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getElectric() {
		return electric;
	}
	
	public void setElectric(String electric) {
		this.electric = electric;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	public List<Article> getArticleList() {
		return articleList;
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", name=" + name + ", address=" + address + ", property=" + property + ", phone="
				+ phone + ", province=" + province + ", city=" + city + ", county=" + county + ", water=" + water
				+ ", electric=" + electric + ", noticeList=" + noticeList + ", articleList=" + articleList + "]";
	}
	
	
	
	
}
