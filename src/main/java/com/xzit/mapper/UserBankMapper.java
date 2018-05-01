package com.xzit.mapper;

import com.xzit.entity.UserBank;
import com.xzit.entity.UserBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBankMapper {
    int countByExample(UserBankExample example);

    int deleteByExample(UserBankExample example);

    int deleteByPrimaryKey(Integer userbankid);

    int insert(UserBank record);

    int insertSelective(UserBank record);

    List<UserBank> selectByExample(UserBankExample example);

    UserBank selectByPrimaryKey(Integer userbankid);

    int updateByExampleSelective(@Param("record") UserBank record, @Param("example") UserBankExample example);

    int updateByExample(@Param("record") UserBank record, @Param("example") UserBankExample example);

    int updateByPrimaryKeySelective(UserBank record);

    int updateByPrimaryKey(UserBank record);
}