package com.ksshlee.dto;

public class CommentVO {
	private int cid;//댓글 Id
	private int bid;//게시물 id
	private String content;//덧글 내용 
	private String author;
	private int rcid;//대댓글 달 댓글 id
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getRcid() {
		return rcid;
	}
	public void setRcid(int rcid) {
		this.rcid = rcid;
	}
	
	
	
	
}
