package com.chinasoft.domain;

import java.io.Serializable;

public class Ckd implements Serializable{

	private Integer ckdId;
	private String ckdNum;	//
	private String jsr;
	private String dh;
	private String dz;
	private String bz;
	public Integer getCkdId() {
		return ckdId;
	}
	public void setCkdId(Integer ckdId) {
		this.ckdId = ckdId;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCkdNum() {
		return ckdNum;
	}
	public void setCkdNum(String ckdNum) {
		this.ckdNum = ckdNum;
	}
	
}
