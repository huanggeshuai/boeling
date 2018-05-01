package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.VenuesAllocation;

/**
 * Created by huang on 2018/4/7.
 */
public interface VenuesAllocationService {
    PageInfo<VenuesAllocation> alluser(VenuesAllocation venuesAllocation, Integer pageNo, Integer pageSize, String order, String sort);
    boolean addvenuesallocation(VenuesAllocation venuesAllocation);
    boolean editvenuesallocation(VenuesAllocation venuesAllocation);
    VenuesAllocation findbyid(Integer venuesAllocationId );
}
