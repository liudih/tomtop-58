package com.tomtop.member.mappers.loyalty;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tomtop.member.models.dto.loyalty.MemberEdm;


public interface MemberEdmMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(MemberEdm record);

    int insertSelective(MemberEdm record);

    MemberEdm selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(MemberEdm record);

    int updateByPrimaryKey(MemberEdm record);
    
    @Select("select * from t_member_edm where cemail=#{0} and iwebsiteid=#{1}")
    public List<MemberEdm> getEdmByEmail(String email, Integer iwebsiteid);
    
    /**
     * 查询所有订阅过的用户邮箱
     * @return
     */
    @Select("select distinct cemail from t_member_edm where dcreatedate >=#{0} and dcreatedate <=#{1}")
    List<String> getMembers(Date start,Date end);
}