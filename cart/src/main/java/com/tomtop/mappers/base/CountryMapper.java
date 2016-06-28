package com.tomtop.mappers.base;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tomtop.dto.Country;

public interface CountryMapper {

	@Select("select * from t_country where iid = #{iid} limit 1")
	Country getCountryByCountryId(Integer iid);

	@Select("select * from t_country where cshortname = #{cshortname} limit 1")
	Country getCountryByCountryName(String cshortname);

	@Select("select * from t_country order by ishowindex")
	List<Country> getAllCountry();

	@Select("select max(iid) from t_country ")
	int getCountryMaxId();

	@Select("select * from t_country where iid>#{0} order by iid asc")
	public List<Country> getMaxCountry(Integer mid);

	/**
	 * 
	 * @Title: getCountries
	 * @Description: TODO(查询国家(分页))
	 * @param @param pageIndex
	 * @param @param limit
	 * @param @return
	 * @return List<Country>
	 * @throws
	 * @author yinfei
	 */
	@Select("select * from t_country order by ishowindex,cname limit #{1} offset #{0}")
	List<Country> getCountries(int pageIndex, int limit);

	/**
	 * 
	 * @Title: getCountryCount
	 * @Description: TODO(查询所有国家的个数)
	 * @param @return
	 * @return int
	 * @throws
	 * @author yinfei
	 */
	@Select("select count(*) from t_country")
	int getCountryCount();

}
