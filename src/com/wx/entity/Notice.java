package com.wx.entity;

/**
 * 通知类 对象
 * @author 崔为满
 * @date 2018年3月28日 下午4:56:22
 */

public class Notice {
	
	private int id;
	private String title;
	private String content;
	private String time;
	private String cid;
	
	public Notice() {}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", time=" + time + "]";
	}
	
	
	
}
