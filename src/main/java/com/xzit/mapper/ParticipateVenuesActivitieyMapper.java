package com.xzit.mapper;

import com.xzit.entity.ParticipateVenuesActivitiey;
import com.xzit.entity.ParticipateVenuesActivitieyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipateVenuesActivitieyMapper {
    int countByExample(ParticipateVenuesActivitieyExample example);

    int deleteByExample(ParticipateVenuesActivitieyExample example);

    int deleteByPrimaryKey(Integer participateVenuesActivieyId);

    int insert(ParticipateVenuesActivitiey record);

    int insertSelective(ParticipateVenuesActivitiey record);

    List<ParticipateVenuesActivitiey> selectByExample(ParticipateVenuesActivitieyExample example);

    ParticipateVenuesActivitiey selectByPrimaryKey(Integer participateVenuesActivieyId);

    int updateByExampleSelective(@Param("record") ParticipateVenuesActivitiey record, @Param("example") ParticipateVenuesActivitieyExample example);

    int updateByExample(@Param("record") ParticipateVenuesActivitiey record, @Param("example") ParticipateVenuesActivitieyExample example);

    int updateByPrimaryKeySelective(ParticipateVenuesActivitiey record);

    int updateByPrimaryKey(ParticipateVenuesActivitiey record);
}