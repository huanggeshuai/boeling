package com.xzit.entity;

import java.math.BigDecimal;

public class VenuesAllocation {
    private Integer venuesAllocationId;

    private Integer venuesid;

    private Integer venuesConfiguration;

    private Integer venuesAllocationState;

    private BigDecimal feeScale;

    private String remark;

    private Venues venues;

    public Venues getVenues() {
        return venues;
    }

    public void setVenues(Venues venues) {
        this.venues = venues;
    }

    public Integer getVenuesAllocationId() {
        return venuesAllocationId;
    }

    public void setVenuesAllocationId(Integer venuesAllocationId) {
        this.venuesAllocationId = venuesAllocationId;
    }

    public Integer getVenuesid() {
        return venuesid;
    }

    public void setVenuesid(Integer venuesid) {
        this.venuesid = venuesid;
    }

    public Integer getVenuesConfiguration() {
        return venuesConfiguration;
    }

    public void setVenuesConfiguration(Integer venuesConfiguration) {
        this.venuesConfiguration = venuesConfiguration;
    }

    public Integer getVenuesAllocationState() {
        return venuesAllocationState;
    }

    public void setVenuesAllocationState(Integer venuesAllocationState) {
        this.venuesAllocationState = venuesAllocationState;
    }

    public BigDecimal getFeeScale() {
        return feeScale;
    }

    public void setFeeScale(BigDecimal feeScale) {
        this.feeScale = feeScale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}