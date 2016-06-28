package com.tomtop.mappers.payment;

import org.apache.ibatis.annotations.Select;

import com.tomtop.entity.payment.paypal.PaymentBase;

public interface PaymentMapper {
	@Select("select cbusiness,citemname,creturnurl,cnotifyurl,cfromkey,cuser,cpwd,csignature from t_payment_paypal_account where iwebsiteid=#{0} and #{1} >= fbeginprice AND #{1}<= fendprice limit 1 ")
	PaymentBase getPaymentAccountBase(Integer iwebsiteid, double price);
}
