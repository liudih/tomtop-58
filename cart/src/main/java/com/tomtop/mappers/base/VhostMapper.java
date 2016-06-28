package com.tomtop.mappers.base;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface VhostMapper {
	@Select("select distinct cvhost from t_vhost")
	List<String> getCvhost();

	@Select("select distinct cdevice from t_vhost where cvhost =#{0} limit 1")
	String getCdevice(String vhost);

	/**
	 * 获取在生成订单号时的占位符
	 * 
	 * @author lijun
	 * @param vhost
	 * @return
	 */
	@Select("select distinct corderplaceholder from t_vhost where cvhost =#{0} limit 1")
	String getCorderplaceholder(String vhost);

	@Select("select ilanguageid from t_vhost where cvhost =#{0} limit 1")
	Integer getIlanguageIdByVhost(String vhost);
}
