package com.xzit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ParticipateVenuesActivitiey {
    private Integer participateVenuesActivieyId;

    private Integer userid;

    private Integer venuesid;

    private Integer venuesAllocationId;

    private Integer enlistNum;

    private BigDecimal paymentMoney;

    private Integer paymentState;

    private Integer userState;

    private String evaluate;

    private Integer deletestate;

    private Date createtime;

    private Date ordertime;

    private Date finishtime;

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

    public Integer getParticipateVenuesActivieyId() {
        return participateVenuesActivieyId;
    }

    public void setParticipateVenuesActivieyId(Integer participateVenuesActivieyId) {
        this.participateVenuesActivieyId = participateVenuesActivieyId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVenuesid() {
        return venuesid;
    }

    public void setVenuesid(Integer venuesid) {
        this.venuesid = venuesid;
    }

    public Integer getVenuesAllocationId() {
        return venuesAllocationId;
    }

    public void setVenuesAllocationId(Integer venuesAllocationId) {
        this.venuesAllocationId = venuesAllocationId;
    }

    public Integer getEnlistNum() {
        return enlistNum;
    }

    public void setEnlistNum(Integer enlistNum) {
        this.enlistNum = enlistNum;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public Integer getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(Integer paymentState) {
        this.paymentState = paymentState;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
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

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }
}