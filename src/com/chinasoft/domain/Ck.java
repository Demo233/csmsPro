package com.chinasoft.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ck implements Serializable{

	private Integer id;
	private String num;
	private String name;
	private String lxr;
	private String dh;
	private Integer kcl;
	private Integer syskcl;
	
	private Set<Rkmx> rkmxs = new HashSet<Rkmx>();
	// 一个仓库对应多个入库单
	//private List<Rkd> rcks;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public Integer getKcl() {
		return kcl;
	}
	public void setKcl(Integer kcl) {
		this.kcl = kcl;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public Set<Rkmx> getRkmxs() {
		return rkmxs;
	}
	public void setRkmxs(Set<Rkmx> rkmxs) {
		this.rkmxs = rkmxs;
	}
	public Integer getSyskcl() {
		return syskcl;
	}
	public void setSyskcl(Integer syskcl) {
		this.syskcl = syskcl;
	}
	
}
