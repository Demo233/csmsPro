package com.chinasoft.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNumUtils {

	// 自动生成货号
	public static String generate(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = "HH"+df.format(date);
		return str;
	}
	
	// 自动生成仓库号
	public static String getCkNum(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = "CK"+df.format(date);
		return str;
	}
	
	// 自动生成入库单号
	public static String getRkcNum(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = "RK"+df.format(date);
		return str;
	}
	
	// 自动生成入库明细的单号
	public static String getRkmxNum(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = "MX"+df.format(date);
		return str;
	}
	
	// 自动生成出库明细的单号
	public static String getCkmxNum(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = "CK"+df.format(date);
		return str;
	}
}
