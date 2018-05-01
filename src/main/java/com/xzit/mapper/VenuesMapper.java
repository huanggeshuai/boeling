package com.xzit.mapper;

import com.xzit.entity.Venues;
import com.xzit.entity.VenuesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VenuesMapper {
    int countByExample(VenuesExample example);

    int deleteByExample(VenuesExample example);

    int deleteByPrimaryKey(Integer venuesid);

    int insert(Venues record);

    int insertSelective(Venues record);

    List<Venues> selectByExample(VenuesExample example);

    Venues selectByPrimaryKey(Integer venuesid);

    int updateByExampleSelective(@Param("record") Venues record, @Param("example") VenuesExample example);

    int updateByExample(@Param("record") Venues record, @Param("example") VenuesExample example);

    int updateByPrimaryKeySelective(Venues record);

    int updateByPrimaryKey(Venues record);
}