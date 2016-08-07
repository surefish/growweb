package com.cms.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_Messages")//新闻资讯表
public class TMessages extends StatusEntity{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//消息ID	

    private String ftitle;//标题

    private Integer fhit;//浏览次数

    private String fcatalog;//分类

    private String ftag;//标签

    private Date fpublishtime;//发布时间

   // private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String fotheruid;//数据归属

    private String fimages;//图片

    private String fcontent;//内容

	public TMessages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TMessages(String fuID, String ftitle, String fcatalog, String ftag,
			Date fpublishtime, String fotheruid, String fimages,
			String fcontent) {
		super();
		this.fuID = fuID;
		this.ftitle = ftitle;
		this.fcatalog = fcatalog;
		this.ftag = ftag;
		this.fpublishtime = fpublishtime;
		this.fotheruid = fotheruid;
		this.fimages = fimages;
		//this.fimagesurl = fimagesurl;
		this.fcontent = fcontent;
		//this.fpraise = fpraise;
		//this.freads = freads;
	}

	@Override
	public String toString() {
		return "TMessages [fuID=" + fuID + ", ftitle=" + ftitle + ","
				+ " fcatalog=" + fcatalog + ", ftag=" + ftag + ", fpublishtime="
				+ fpublishtime + ", fotheruid=" + fotheruid + ", fimages="
				+ fimages + ", fcontent="
				+ fcontent +  "]";
	}

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public Integer getFhit() {
        return fhit;
    }

    public void setFhit(Integer fhit) {
        this.fhit = fhit;
    }

    public String getFcatalog() {
        return fcatalog;
    }

    public void setFcatalog(String fcatalog) {
        this.fcatalog = fcatalog == null ? null : fcatalog.trim();
    }

    public String getFtag() {
        return ftag;
    }

    public void setFtag(String ftag) {
        this.ftag = ftag == null ? null : ftag.trim();
    }

    public Date getFpublishtime() {
        return fpublishtime;
    }

    public void setFpublishtime(Date fpublishtime) {
        this.fpublishtime = fpublishtime;
    }

    public String getFotheruid() {
        return fotheruid;
    }

    public void setFotheruid(String fotheruid) {
        this.fotheruid = fotheruid == null ? null : fotheruid.trim();
    }

    public String getFimages() {
        return fimages;
    }

    public void setFimages(String fimages) {
        this.fimages = fimages == null ? null : fimages.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }
}