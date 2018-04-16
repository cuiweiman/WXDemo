package com.wx.entity;

/**
 * 故障类 对象
 * @author 崔为满
 * @date 2018年3月28日 下午6:04:24
 */
public class Fault {
	
	private int id;
	private String area;
	private String thing;
	private String descripe;
	private int flag;
	private String rid;
	
	public Fault() {}

	public int getId() {
		return id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getRid() {
		return rid;
	}

	@Override
	public String toString() {
		return "Fault [id=" + id + ", area=" + area + ", thing=" + thing + ", descripe=" + descripe + ", flag=" + flag
				+ ", rid=" + rid + "]";
	}

	
	
	
}
