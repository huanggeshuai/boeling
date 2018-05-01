package com.xzit.mapper;

import com.xzit.entity.UserCustomActivity;
import com.xzit.entity.UserCustomActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCustomActivityMapper {
    int countByExample(UserCustomActivityExample example);

    int deleteByExample(UserCustomActivityExample example);

    int deleteByPrimaryKey(Integer userCustomActivityId);

    int insert(UserCustomActivity record);

    int insertSelective(UserCustomActivity record);

    List<UserCustomActivity> selectByExampleWithBLOBs(UserCustomActivityExample example);

    List<UserCustomActivity> selectByExample(UserCustomActivityExample example);

    UserCustomActivity selectByPrimaryKey(Integer userCustomActivityId);

    int updateByExampleSelective(@Param("record") UserCustomActivity record, @Param("example") UserCustomActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") UserCustomActivity record, @Param("example") UserCustomActivityExample example);

    int updateByExample(@Param("record") UserCustomActivity record, @Param("example") UserCustomActivityExample example);

    int updateByPrimaryKeySelective(UserCustomActivity record);

    int updateByPrimaryKeyWithBLOBs(UserCustomActivity record);

    int updateByPrimaryKey(UserCustomActivity record);
}