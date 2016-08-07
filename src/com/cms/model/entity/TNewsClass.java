package com.cms.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_News_Class")//新闻类别
public class TNewsClass{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuid;//角色ID
	
	private String fname;//菜单名
	
	private String fmemo;//菜单备注
	
	private String fparentid;//0 为父菜单 
	
	private String furl;//图片路径

	private String ficon;//图片

	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFmemo() {
		return fmemo;
	}

	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}

	public String getFparentid() {
		return fparentid;
	}

	public void setFparentid(String fparentid) {
		this.fparentid = fparentid;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}
	
	public String getFicon() {
		return ficon;
	}

	public void setFicon(String ficon) {
		this.ficon = ficon;
	}
}