package com.chinasoft.domain;

import java.io.Serializable;

public class Rkmx implements Serializable{

	private Integer rkmxId;
	private String rkmxNum;
	private Integer count;	//数量
	private Rkd rkd;
	private Ck ck;
	//private Clothing clothing;
	public Integer getRkmxId() {
		return rkmxId;
	}
	public void setRkmxId(Integer rkmxId) {
		this.rkmxId = rkmxId;
	}
	public String getRkmxNum() {
		return rkmxNum;
	}
	public void setRkmxNum(String rkmxNum) {
		this.rkmxNum = rkmxNum;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Rkd getRkd() {
		return rkd;
	}
	public void setRkd(Rkd rkd) {
		this.rkd = rkd;
	}
	public Ck getCk() {
		return ck;
	}
	public void setCk(Ck ck) {
		this.ck = ck;
	}
	
}
