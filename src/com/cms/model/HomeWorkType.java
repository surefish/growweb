package com.cms.model;

import java.util.Date;

public class HomeWorkType {
	private String fuID;//角色ID
	private String fname;
	private String fcreateBy;
	private Date fcreateTime;
	private String fupdateBy;
	private Date fupdateTime;
	private String fdesc;
	private String fstatusCode;
	private String fstatusDesc;
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFcreateBy() {
		return fcreateBy;
	}
	public void setFcreateBy(String fcreateBy) {
		this.fcreateBy = fcreateBy;
	}
	public Date getFcreateTime() {
		return fcreateTime;
	}
	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	public String getFupdateBy() {
		return fupdateBy;
	}
	public void setFupdateBy(String fupdateBy) {
		this.fupdateBy = fupdateBy;
	}
	public Date getFupdateTime() {
		return fupdateTime;
	}
	public void setFupdateTime(Date fupdateTime) {
		this.fupdateTime = fupdateTime;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public String getFstatusCode() {
		return fstatusCode;
	}
	public void setFstatusCode(String fstatusCode) {
		this.fstatusCode = fstatusCode;
	}
	public String getFstatusDesc() {
		return fstatusDesc;
	}
	public void setFstatusDesc(String fstatusDesc) {
		this.fstatusDesc = fstatusDesc;
	}
	
}
