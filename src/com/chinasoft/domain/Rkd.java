package com.chinasoft.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Rkd implements Serializable{

	private Integer rkdId;	//ID
	private String rkdNum;	//编号
	private Date rkdDate;	//入库日期
	
	private String ckName;	//仓库姓名
	
	private String rkdLy;	//来源
	private String rkdBly;	//办理人
	private String rkdNote;	//备注
	
	// 一个入库单可以有多个入库明细
	private Set<Rkmx> rkmxs = new HashSet<Rkmx>();
	
	public Integer getRkdId() {
		return rkdId;
	}
	public void setRkdId(Integer rkdId) {
		this.rkdId = rkdId;
	}
	public String getRkdNum() {
		return rkdNum;
	}
	public void setRkdNum(String rkdNum) {
		this.rkdNum = rkdNum;
	}
	public Date getRkdDate() {
		return rkdDate;
	}
	public void setRkdDate(Date rkdDate) {
		this.rkdDate = rkdDate;
	}
	public String getRkdLy() {
		return rkdLy;
	}
	public void setRkdLy(String rkdLy) {
		this.rkdLy = rkdLy;
	}
	public String getRkdBly() {
		return rkdBly;
	}
	public void setRkdBly(String rkdBly) {
		this.rkdBly = rkdBly;
	}
	public String getRkdNote() {
		return rkdNote;
	}
	public void setRkdNote(String rkdNote) {
		this.rkdNote = rkdNote;
	}
	public String getCkName() {
		return ckName;
	}
	public void setCkName(String ckName) {
		this.ckName = ckName;
	}
	public Set<Rkmx> getRkmxs() {
		return rkmxs;
	}
	public void setRkmxs(Set<Rkmx> rkmxs) {
		this.rkmxs = rkmxs;
	}
	
	
	
}
