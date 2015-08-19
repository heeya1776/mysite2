package com.bit2015.mysite2.vo;

public class BoardVo {
	
	private long no;
	private String name;
	private String title;
	private String content;
	private String regDate;
	private long memberNo;
	private long readNo;
	private long rNum;
	private long page;
	private long totcnt;
	private long groupNo;
	private long orderNo;
	private long depth;
	
	public long getrNum() {
		return rNum;
	}
	public void setrNum(long rNum) {
		this.rNum = rNum;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getTotcnt() {
		return totcnt;
	}
	public void setTotcnt(long totcnt) {
		this.totcnt = totcnt;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public long getReadNo() {
		return readNo;
	}
	public void setReadNo(long readNo) {
		this.readNo = readNo;
	}
	public long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(long groupNo) {
		this.groupNo = groupNo;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", name=" + name + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate
				+ ", memberNo=" + memberNo + ", readNo=" + readNo + ", rNum="
				+ rNum + ", page=" + page + ", totcnt=" + totcnt + ", groupNo="
				+ groupNo + ", orderNo=" + orderNo + ", depth=" + depth + "]";
	}
	
	
}
