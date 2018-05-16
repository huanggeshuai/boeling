package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.VenuesAllocation;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Created by huang on 2018/4/7.
 */
public interface VenuesAllocationService {
    PageInfo<VenuesAllocation> alluser(VenuesAllocation venuesAllocation, Integer pageNo, Integer pageSize, String order, String sort);
    boolean addvenuesallocation(VenuesAllocation venuesAllocation);
    boolean editvenuesallocation(VenuesAllocation venuesAllocation);
    VenuesAllocation findbyid(Integer venuesAllocationId );
    void importExcelInfo(InputStream in, MultipartFile file) throws Exception;
}
