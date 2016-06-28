package com.tomtop.entity;

/**
 * 类目
 * 
 * @author lijun
 *
 */
public class Category extends BaseBean {

	private static final long serialVersionUID = -5337957366147745142L;

	private Integer iwebsiteid;
	private Integer ilanguageid;
	private Integer icategoryid;
	private Integer iparentid;
	private Integer ilevel;
	private Integer iposition;
	private String cpath;
	private String cname;
	private String cbgimglink;
	private String cdescription;
	private String metaTitle;
	private String metaKeyWords;
	private String metadescription;

	public Integer getIlanguageid() {
		return ilanguageid;
	}

	public void setIlanguageid(Integer ilanguageid) {
		this.ilanguageid = ilanguageid;
	}

	public Integer getIwebsiteid() {
		return iwebsiteid;
	}

	public void setIwebsiteid(Integer iwebsiteid) {
		this.iwebsiteid = iwebsiteid;
	}

	public Integer getIcategoryid() {
		return icategoryid;
	}

	public void setIcategoryid(Integer icategoryid) {
		this.icategoryid = icategoryid;
	}

	public Integer getIparentid() {
		return iparentid;
	}

	public void setIparentid(Integer iparentid) {
		this.iparentid = iparentid;
	}

	public Integer getIlevel() {
		return ilevel;
	}

	public void setIlevel(Integer ilevel) {
		this.ilevel = ilevel;
	}

	public Integer getIposition() {
		return iposition;
	}

	public void setIposition(Integer iposition) {
		this.iposition = iposition;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCbgimglink() {
		return cbgimglink;
	}

	public void setCbgimglink(String cbgimglink) {
		this.cbgimglink = cbgimglink;
	}

	public String getCpath() {
		return cpath;
	}

	public void setCpath(String cpath) {
		this.cpath = cpath;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

	public String getMetadescription() {
		return metadescription;
	}

	public void setMetadescription(String metadescription) {
		this.metadescription = metadescription;
	}
}
