package com.cms.model.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.servlet.annotation.WebServlet;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_BookType")
public class TBookType extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	
	
	
	private String fuID;//类型主键
	
	private String fname;//类型名称

	private String fremark;//备注
	
	private String ficon;
	private String fparentid;
	@ElementCollection
	private Set<TBook> tBooks = new HashSet<TBook>();


	@OneToMany(mappedBy="fBookTypefuid")
	
	@JoinColumn(name = "tBookType")
	@OrderBy("fuID")
	@Cascade({CascadeType.ALL,CascadeType.DELETE_ORPHAN })
	public Set<TBook> getTBooks(){
		return tBooks;
	}
	
	public void setTBooks(Set<TBook> tBooks){
		this.tBooks = tBooks;
	}
	
	
	
	public String getFparentid() {
		return fparentid;
	}

	public void setFparentid(
			String fparentid) {
		this.fparentid = fparentid;
	}

	public String getFicon() {
		return ficon;
	}

	public void setFicon(
			String ficon) {
		this.ficon = ficon;
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

	

	public String getFremark() {
		return fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	
	
	

}
