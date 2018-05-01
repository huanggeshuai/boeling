package com.xzit.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class UserCustomActivity {
    private Integer userCustomActivityId;

    private Integer venuesid;

    private Integer userid;

    private Integer venuesAllocationId;

    private Date activitiesSettingTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activitiesStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activitiesStopTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enlistStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enlistStopTime;

    private Integer total;

    private Integer enlistnum;

    private BigDecimal paymentmoney;

    private Integer auditing;

    private String cause;

    private Integer payState;

    private Integer deletestate;

    private Date createtime;

    private String imageurl;

    private String activityname;

    private BigDecimal userpay;

    private String detailinfo;

    private User user;

    private Venues venues;

    private VenuesAllocation venuesAllocation;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Venues getVenues() {
        return venues;
    }

    public void setVenues(Venues venues) {
        this.venues = venues;
    }

    public VenuesAllocation getVenuesAllocation() {
        return venuesAllocation;
    }

    public void setVenuesAllocation(VenuesAllocation venuesAllocation) {
        this.venuesAllocation = venuesAllocation;
    }

    public Integer getUserCustomActivityId() {
        return userCustomActivityId;
    }

    public void setUserCustomActivityId(Integer userCustomActivityId) {
        this.userCustomActivityId = userCustomActivityId;
    }

    public Integer getVenuesid() {
        return venuesid;
    }

    public void setVenuesid(Integer venuesid) {
        this.venuesid = venuesid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVenuesAllocationId() {
        return venuesAllocationId;
    }

    public void setVenuesAllocationId(Integer venuesAllocationId) {
        this.venuesAllocationId = venuesAllocationId;
    }

    public Date getActivitiesSettingTime() {
        return activitiesSettingTime;
    }

    public void setActivitiesSettingTime(Date activitiesSettingTime) {
        this.activitiesSettingTime = activitiesSettingTime;
    }

    public Date getActivitiesStartTime() {
        return activitiesStartTime;
    }

    public void setActivitiesStartTime(Date activitiesStartTime) {
        this.activitiesStartTime = activitiesStartTime;
    }

    public Date getActivitiesStopTime() {
        return activitiesStopTime;
    }

    public void setActivitiesStopTime(Date activitiesStopTime) {
        this.activitiesStopTime = activitiesStopTime;
    }

    public Date getEnlistStartTime() {
        return enlistStartTime;
    }

    public void setEnlistStartTime(Date enlistStartTime) {
        this.enlistStartTime = enlistStartTime;
    }

    public Date getEnlistStopTime() {
        return enlistStopTime;
    }

    public void setEnlistStopTime(Date enlistStopTime) {
        this.enlistStopTime = enlistStopTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getEnlistnum() {
        return enlistnum;
    }

    public void setEnlistnum(Integer enlistnum) {
        this.enlistnum = enlistnum;
    }

    public BigDecimal getPaymentmoney() {
        return paymentmoney;
    }

    public void setPaymentmoney(BigDecimal paymentmoney) {
        this.paymentmoney = paymentmoney;
    }

    public Integer getAuditing() {
        return auditing;
    }

    public void setAuditing(Integer auditing) {
        this.auditing = auditing;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getDeletestate() {
        return deletestate;
    }

    public void setDeletestate(Integer deletestate) {
        this.deletestate = deletestate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public BigDecimal getUserpay() {
        return userpay;
    }

    public void setUserpay(BigDecimal userpay) {
        this.userpay = userpay;
    }

    public String getDetailinfo() {
        return detailinfo;
    }

    public void setDetailinfo(String detailinfo) {
        this.detailinfo = detailinfo == null ? null : detailinfo.trim();
    }
}