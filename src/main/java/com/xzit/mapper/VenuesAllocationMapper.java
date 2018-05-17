package com.xzit.mapper;

import com.xzit.entity.VenuesAllocation;
import com.xzit.entity.VenuesAllocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VenuesAllocationMapper {
    int countByExample(VenuesAllocationExample example);

    int deleteByExample(VenuesAllocationExample example);

    int deleteByPrimaryKey(Integer venuesAllocationId);

    int insert(VenuesAllocation record);

    int insertSelective(VenuesAllocation record);

    List<VenuesAllocation> selectByExample(VenuesAllocationExample example);

    VenuesAllocation selectByPrimaryKey(Integer venuesAllocationId);

    int updateByExampleSelective(@Param("record") VenuesAllocation record, @Param("example") VenuesAllocationExample example);

    int updateByExample(@Param("record") VenuesAllocation record, @Param("example") VenuesAllocationExample example);

    int updateByPrimaryKeySelective(VenuesAllocation record);

    int updateByPrimaryKey(VenuesAllocation record);
    long insertforeach(List<VenuesAllocation> record);
}