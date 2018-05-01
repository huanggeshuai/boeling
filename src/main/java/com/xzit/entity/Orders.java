package com.xzit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer orderId;

    private Integer userid;

    private Integer incomeState;

    private BigDecimal money;

    private String cause;

    private Integer incomeUserId;

    private Integer medium;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date time;

    private Integer deletestate;

    private User user;

    private User incomeUser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getIncomeUser() {
        return incomeUser;
    }

    public void setIncomeUser(User incomeUser) {
        this.incomeUser = incomeUser;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIncomeState() {
        return incomeState;
    }

    public void setIncomeState(Integer incomeState) {
        this.incomeState = incomeState;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Integer getIncomeUserId() {
        return incomeUserId;
    }

    public void setIncomeUserId(Integer incomeUserId) {
        this.incomeUserId = incomeUserId;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
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
}