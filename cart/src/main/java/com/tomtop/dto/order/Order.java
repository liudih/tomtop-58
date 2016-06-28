package com.tomtop.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tomtop.enums.OrderStatusEnum;
import com.tomtop.enums.PaymentStatus;
import com.tomtop.utils.Utils;

public class Order implements Serializable {
	private static final long serialVersionUID = 6098380563031920127L;

	private Integer iid;
	private String cemail;
	private String ccountry;
	private String ccountrysn;
	private String cprovince;
	private String ccity;
	private String cstreetaddress;
	private String cpostalcode;
	private String ctelephone;
	private String cfirstname;
	private String cmiddlename;
	private String clastname;
	private Integer istorageid;
	private Integer ishippingmethodid;
	private Double fshippingprice;
	private Double fordersubtotal;
	private Double fextra;
	private Double fgrandtotal;
	private String ccartid;
	private Integer istatus;
	private String cpaymentid;
	private String ccurrency;
	private Date dcreatedate;
	private Date dpaymentdate;
	private String corigin;
	private Integer iwebsiteid;
	private String cmemberemail;
	private String cmessage;
	private Integer ishow;
	private String ctransactionid;
	private String cip;
	private String cremark;
	private String creceiveraccount;
	private String cshippingcode;
	private String cordernumber;
	private String cvhost;
	private Integer ipaymentstatus;
	private String cpaymenttype; // 支付类型

	private String cdropshippingid; // dropshipping订单Id

	public Integer getIpaymentstatus() {
		return ipaymentstatus;
	}

	public void setIpaymentstatus(Integer ipaymentstatus) {
		this.ipaymentstatus = ipaymentstatus;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCcountry() {
		return ccountry;
	}

	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	public String getCcountrysn() {
		return ccountrysn;
	}

	public void setCcountrysn(String ccountrysn) {
		this.ccountrysn = ccountrysn;
	}

	public String getCprovince() {
		return cprovince;
	}

	public void setCprovince(String cprovince) {
		this.cprovince = cprovince;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getCstreetaddress() {
		return cstreetaddress;
	}

	public void setCstreetaddress(String cstreetaddress) {
		this.cstreetaddress = cstreetaddress;
	}

	public String getCpostalcode() {
		return cpostalcode;
	}

	public void setCpostalcode(String cpostalcode) {
		this.cpostalcode = cpostalcode;
	}

	public String getCtelephone() {
		return ctelephone;
	}

	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}

	public String getCfirstname() {
		return cfirstname;
	}

	public void setCfirstname(String cfirstname) {
		this.cfirstname = cfirstname;
	}

	public String getCmiddlename() {
		return cmiddlename;
	}

	public void setCmiddlename(String cmiddlename) {
		this.cmiddlename = cmiddlename;
	}

	public String getClastname() {
		return clastname;
	}

	public void setClastname(String clastname) {
		this.clastname = clastname;
	}

	public Integer getIstorageid() {
		return istorageid;
	}

	public void setIstorageid(Integer istorageid) {
		this.istorageid = istorageid;
	}

	public Integer getIshippingmethodid() {
		return ishippingmethodid;
	}

	public void setIshippingmethodid(Integer ishippingmethodid) {
		this.ishippingmethodid = ishippingmethodid;
	}

	public Double getFshippingprice() {
		return fshippingprice;
	}
	
	public String getFshippingpriceStr(String currency) {
		return Utils.money(this.fshippingprice, currency);
	}

	public void setFshippingprice(Double fshippingprice) {
		this.fshippingprice = fshippingprice;
	}

	public Double getFordersubtotal() {
		return fordersubtotal;
	}
	
	public String getFordersubtotalStr() {
		return Utils.money(this.getFordersubtotal(), this.getCcurrency());
	}

	public void setFordersubtotal(Double fordersubtotal) {
		this.fordersubtotal = fordersubtotal;
	}

	public Double getFextra() {
		if(fextra!=null){
			BigDecimal b = new BigDecimal(fextra);
			return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		}
		return fextra;
	}
	
	public String getFextraStr() {
		return Utils.money(this.getFextra(), this.getCcurrency());
	}
	

	public void setFextra(Double fextra) {
		this.fextra = fextra;
	}

	public Double getFgrandtotal() {
		return fgrandtotal;
	}
	
	public String getFgrandtotalStr(){
		return Utils.money(this.getFgrandtotal(), this.getCcurrency());
	}

	public void setFgrandtotal(Double fgrandtotal) {
		this.fgrandtotal = fgrandtotal;
	}

	public String getCcartid() {
		return ccartid;
	}

	public void setCcartid(String ccartid) {
		this.ccartid = ccartid;
	}

	public Integer getIstatus() {
		return istatus;
	}

	public void setIstatus(Integer istatus) {
		this.istatus = istatus;
	}

	public String getCcurrency() {
		return ccurrency;
	}

	public void setCcurrency(String ccurrency) {
		this.ccurrency = ccurrency;
	}

	public Date getDcreatedate() {
		return dcreatedate;
	}

	public void setDcreatedate(Date dcreatedate) {
		this.dcreatedate = dcreatedate;
	}

	public Date getDpaymentdate() {
		return dpaymentdate;
	}

	public void setDpaymentdate(Date dpaymentdate) {
		this.dpaymentdate = dpaymentdate;
	}

	public String getCpaymentid() {
		return cpaymentid;
	}

	public void setCpaymentid(String cpaymentid) {
		this.cpaymentid = cpaymentid;
	}

	public String getCorigin() {
		return corigin;
	}

	public void setCorigin(String corigin) {
		this.corigin = corigin;
	}

	public Integer getIwebsiteid() {
		return iwebsiteid;
	}

	public void setIwebsiteid(Integer iwebsiteid) {
		this.iwebsiteid = iwebsiteid;
	}

	public String getCmemberemail() {
		return cmemberemail;
	}

	public void setCmemberemail(String cmemberemail) {
		this.cmemberemail = cmemberemail;
	}

	public String getCmessage() {
		return cmessage;
	}

	public void setCmessage(String cmessage) {
		this.cmessage = cmessage;
	}

	public Integer getIshow() {
		return ishow;
	}

	public void setIshow(Integer ishow) {
		this.ishow = ishow;
	}

	public String getCtransactionid() {
		return ctransactionid;
	}

	public void setCtransactionid(String ctransactionid) {
		this.ctransactionid = ctransactionid;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCremark() {
		return cremark;
	}

	public void setCremark(String cremark) {
		this.cremark = cremark;
	}

	public String getCreceiveraccount() {
		return creceiveraccount;
	}

	public void setCreceiveraccount(String creceiveraccount) {
		this.creceiveraccount = creceiveraccount;
	}

	public String getCshippingcode() {
		return cshippingcode;
	}

	public void setCshippingcode(String cshippingcode) {
		this.cshippingcode = cshippingcode;
	}

	public String getCordernumber() {
		return cordernumber;
	}

	public void setCordernumber(String cordernumber) {
		this.cordernumber = cordernumber;
	}

	public String getCvhost() {
		return cvhost;
	}

	public void setCvhost(String cvhost) {
		this.cvhost = cvhost;
	}

	public String getCdropshippingid() {
		return cdropshippingid;
	}

	public void setCdropshippingid(String cdropshippingid) {
		this.cdropshippingid = cdropshippingid;
	}

	public String getCreateDateStr() {
		SimpleDateFormat sdf = null;
		if (dcreatedate == null) {
			return "";
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String createDateStr = sdf.format(dcreatedate);
			return createDateStr;
		}
	}

	public String getCpaymenttype() {
		return cpaymenttype;
	}

	public void setCpaymenttype(String cpaymenttype) {
		this.cpaymenttype = cpaymenttype;
	}

	/**
	 * 判断是否未支付，订单状态为待付款且（支付状态为待付款、待定、支付失败）
	 * @return
	 */
	public boolean notPaid() {
		return (istatus == null || istatus == OrderStatusEnum.PAYMENT_PENDING.getCode()
					|| istatus == OrderStatusEnum.PAYMENT_PROCESSING.getCode())
				&& (ipaymentstatus == null
						|| ipaymentstatus == PaymentStatus.UN_PAY.getCode()
						|| ipaymentstatus == PaymentStatus.PENDING.getCode() 
						|| ipaymentstatus == PaymentStatus.FAILURE.getCode());
	}
	@Override
	public String toString() {
		return "Order [iid=" + iid + ", cemail=" + cemail + ", ccountry="
				+ ccountry + ", ccountrysn=" + ccountrysn + ", cprovince="
				+ cprovince + ", ccity=" + ccity + ", cstreetaddress="
				+ cstreetaddress + ", cpostalcode=" + cpostalcode
				+ ", ctelephone=" + ctelephone + ", cfirstname=" + cfirstname
				+ ", cmiddlename=" + cmiddlename + ", clastname=" + clastname
				+ ", istorageid=" + istorageid + ", ishippingmethodid="
				+ ishippingmethodid + ", fshippingprice=" + fshippingprice
				+ ", fordersubtotal=" + fordersubtotal + ", fextra=" + fextra
				+ ", fgrandtotal=" + fgrandtotal + ", ccartid=" + ccartid
				+ ", istatus=" + istatus + ", cpaymentid=" + cpaymentid
				+ ", ccurrency=" + ccurrency + ", dcreatedate=" + dcreatedate
				+ ", dpaymentdate=" + dpaymentdate + ", corigin=" + corigin
				+ ", iwebsiteid=" + iwebsiteid + ", cmemberemail="
				+ cmemberemail + ", cmessage=" + cmessage + ", ishow=" + ishow
				+ ", ctransactionid=" + ctransactionid + ", cip=" + cip
				+ ", cremark=" + cremark + ", creceiveraccount="
				+ creceiveraccount + ", cshippingcode=" + cshippingcode
				+ ", cordernumber=" + cordernumber + ", cvhost=" + cvhost
				+ ", ipaymentstatus=" + ipaymentstatus + ", cpaymenttype="
				+ cpaymenttype + ", cdropshippingid=" + cdropshippingid + "]";
	}

}
