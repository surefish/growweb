package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_Book")
public class TBook extends StatusEntity{
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//书本主键
	
	private String fname;//书本名称
	
	private String furl;//书本照片
	
	private String fremark;//备注
	
	private float fprice;//书本价格

	private String fwriter;//作者
	
	private Date fFirsttime;//首版时间

	private String fBooksite;//购书地点
	
	private String fintroduced;//内容介绍

	private String fBookTypefuid;
	public String getfBookTypefuid() {
		return fBookTypefuid;
	}
	public void setfBookTypefuid(
			String fBookTypefuid) {
		this.fBookTypefuid = fBookTypefuid;
	}

	private  TBookType tBookType;
	@ManyToOne (fetch = FetchType.LAZY )
	@Cascade(CascadeType.ALL)
	@JoinColumn( name="tBookType")
		
	public TBookType gettBookType(){
		return tBookType;
	}
	public void settBookType(TBookType tBookType) {
		this.tBookType =tBookType;
	}


	
	
	
	public String getFwriter() {
		return fwriter;
	}

	public void setFwriter(String fwriter) {
		this.fwriter = fwriter;
	}

	public Date getfFirsttime() {
		return fFirsttime;
	}

	public void setfFirsttime(Date fFirsttime) {
		this.fFirsttime = fFirsttime;
	}

	public String getfBooksite() {
		return fBooksite;
	}

	public void setfBooksite(String fBooksite) {
		this.fBooksite = fBooksite;
	}

	public String getFintroduced() {
		return fintroduced;
	}

	public void setFintroduced(String fintroduced) {
		this.fintroduced = fintroduced;
	}



	public float getFprice() {
		return fprice;
	}

	public void setFprice(float fprice) {
		this.fprice = fprice;
	}

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

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFremark() {
		return fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	
	
	

}
