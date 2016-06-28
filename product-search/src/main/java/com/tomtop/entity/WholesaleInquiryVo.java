package com.tomtop.entity;


import java.io.Serializable;

import com.tomtop.utils.CommonsUtil;

public class WholesaleInquiryVo implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4832337848447890621L;
	private String listingId;
    private String sku;
    private String name;
    private String mobilePhone;
    private String emailAddress;
    private Double targetPrice;
    private Integer orderQuantity;
    private String countryState;
    private String companyName;
    private String writeInquiry;
    

	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return CommonsUtil.checkSpecialChar(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilePhone() {
		return CommonsUtil.checkSpecialChar(mobilePhone);
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmailAddress() {
		return CommonsUtil.checkSpecialChar(emailAddress);
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Double getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(Double targetPrice) {
		this.targetPrice = targetPrice;
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getCountryState() {
		return countryState;
	}
	public void setCountryState(String countryState) {
		this.countryState = countryState;
	}
	public String getCompanyName() {
		return CommonsUtil.checkSpecialChar(companyName);
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWriteInquiry() {
		return CommonsUtil.checkSpecialChar(writeInquiry);
	}
	public void setWriteInquiry(String writeInquiry) {
		this.writeInquiry = writeInquiry;
	}
}
