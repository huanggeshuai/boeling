package com.xzit.mapper;

import com.xzit.entity.ParticipateActivitiesUser;
import com.xzit.entity.ParticipateActivitiesUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipateActivitiesUserMapper {
    int countByExample(ParticipateActivitiesUserExample example);

    int deleteByExample(ParticipateActivitiesUserExample example);

    int deleteByPrimaryKey(Integer participateActivitiesIdUser);

    int insert(ParticipateActivitiesUser record);

    int insertSelective(ParticipateActivitiesUser record);

    List<ParticipateActivitiesUser> selectByExample(ParticipateActivitiesUserExample example);

    ParticipateActivitiesUser selectByPrimaryKey(Integer participateActivitiesIdUser);

    int updateByExampleSelective(@Param("record") ParticipateActivitiesUser record, @Param("example") ParticipateActivitiesUserExample example);

    int updateByExample(@Param("record") ParticipateActivitiesUser record, @Param("example") ParticipateActivitiesUserExample example);

    int updateByPrimaryKeySelective(ParticipateActivitiesUser record);

    int updateByPrimaryKey(ParticipateActivitiesUser record);
}