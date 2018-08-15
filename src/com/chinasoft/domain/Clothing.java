package com.chinasoft.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Clothing implements Serializable{

	private Integer clotId;
	private String clotNum;		// 货单编号
	private String clotColor;	// 颜色
	private Integer clotSize;	// 大小
	private String clotBrand;	//品牌
	private String clotMl;		// 面料
	private String clotLl;		// 里料
	private Double clotPrimPrice;	// 出厂价格
	private Double clotSellPrice;	// 销售价格
	
	//private Set<Rkmx> rkmxs = new HashSet<Rkmx>();
	
	
	public Integer getClotId() {
		return clotId;
	}
	public void setClotId(Integer clotId) {
		this.clotId = clotId;
	}
	public String getClotNum() {
		return clotNum;
	}
	public void setClotNum(String clotNum) {
		this.clotNum = clotNum;
	}
	public String getClotColor() {
		return clotColor;
	}
	public void setClotColor(String clotColor) {
		this.clotColor = clotColor;
	}
	public Integer getClotSize() {
		return clotSize;
	}
	public void setClotSize(Integer clotSize) {
		this.clotSize = clotSize;
	}
	public String getClotBrand() {
		return clotBrand;
	}
	public void setClotBrand(String clotBrand) {
		this.clotBrand = clotBrand;
	}
	public String getClotMl() {
		return clotMl;
	}
	public void setClotMl(String clotMl) {
		this.clotMl = clotMl;
	}
	public String getClotLl() {
		return clotLl;
	}
	public void setClotLl(String clotLl) {
		this.clotLl = clotLl;
	}
	public Double getClotPrimPrice() {
		return clotPrimPrice;
	}
	public void setClotPrimPrice(Double clotPrimPrice) {
		this.clotPrimPrice = clotPrimPrice;
	}
	public Double getClotSellPrice() {
		return clotSellPrice;
	}
	public void setClotSellPrice(Double clotSellPrice) {
		this.clotSellPrice = clotSellPrice;
	}
	
}
