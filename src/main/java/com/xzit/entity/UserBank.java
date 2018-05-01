package com.xzit.entity;

import java.util.Date;

public class UserBank {
    private Integer userbankid;

    private Integer userId;

    private String userBankNumber;

    private Date addtime;

    private String cause;

    public Integer getUserbankid() {
        return userbankid;
    }

    public void setUserbankid(Integer userbankid) {
        this.userbankid = userbankid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserBankNumber() {
        return userBankNumber;
    }

    public void setUserBankNumber(String userBankNumber) {
        this.userBankNumber = userBankNumber == null ? null : userBankNumber.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }
}