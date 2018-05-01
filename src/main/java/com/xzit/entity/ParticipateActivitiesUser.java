package com.xzit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ParticipateActivitiesUser {
    private Integer participateActivitiesIdUser;

    private Integer userid;

    private Integer userCustomActivityId;

    private Integer totalnum;

    private BigDecimal paymentMoney;

    private Integer paymentState;

    private String evaluate;

    private Integer participateState;

    private Date time;

    private Integer deletestate;

    private Date ordertime;

    private User user;

    private UserCustomActivity userCustomActivity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustomActivity getUserCustomActivity() {
        return userCustomActivity;
    }

    public void setUserCustomActivity(UserCustomActivity userCustomActivity) {
        this.userCustomActivity = userCustomActivity;
    }

    public Integer getParticipateActivitiesIdUser() {
        return participateActivitiesIdUser;
    }

    public void setParticipateActivitiesIdUser(Integer participateActivitiesIdUser) {
        this.participateActivitiesIdUser = participateActivitiesIdUser;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserCustomActivityId() {
        return userCustomActivityId;
    }

    public void setUserCustomActivityId(Integer userCustomActivityId) {
        this.userCustomActivityId = userCustomActivityId;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
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

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Integer getParticipateState() {
        return participateState;
    }

    public void setParticipateState(Integer participateState) {
        this.participateState = participateState;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDeletestate() {
        return deletestate;
    }

    public void setDeletestate(Integer deletestate) {
        this.deletestate = deletestate;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }
}