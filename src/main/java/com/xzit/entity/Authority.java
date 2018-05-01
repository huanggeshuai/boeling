package com.xzit.entity;

public class Authority {
    private Integer authorityId;

    private String authorityNane;

    private String describe;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityNane() {
        return authorityNane;
    }

    public void setAuthorityNane(String authorityNane) {
        this.authorityNane = authorityNane == null ? null : authorityNane.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}