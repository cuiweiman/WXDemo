package com.wx.entity;


/**
 * 文章类 对象
 * @author 崔为满
 * @date 2018年3月28日 下午4:56:46
 */

public class Article {
	
	private int id;
	private String title;
	private String content;
	private String pic;
	private String time;
	private String cid;
	
	public Article() {}

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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", pic=" + pic + ", time=" + time
				+ "]";
	}
	
	
	
	
	
	
}
