package com.xzit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Venues {
    private Integer venuesid;

    private Integer venuesUserCharge;

    private Integer venuesProvice;

    private Integer venuesCity;

    private Integer venuesAreas;

    private String venuesAddress;

    private BigDecimal venuesLongitude;

    private BigDecimal venuesLatitude;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date openTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date closeTime;

    private String venuesName;

    private Integer deletestate;

    private String cause;

    private String phone;

    private String brief;

    private String imageurl;

    private User userCharge;

    private Provinces provinces;

    private Cities cities;

    private Areas areas;

    public User getUserCharge() {
        return userCharge;
    }

    public void setUserCharge(User userCharge) {
        this.userCharge = userCharge;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public Integer getVenuesid() {
        return venuesid;
    }

    public void setVenuesid(Integer venuesid) {
        this.venuesid = venuesid;
    }

    public Integer getVenuesUserCharge() {
        return venuesUserCharge;
    }

    public void setVenuesUserCharge(Integer venuesUserCharge) {
        this.venuesUserCharge = venuesUserCharge;
    }

    public Integer getVenuesProvice() {
        return venuesProvice;
    }

    public void setVenuesProvice(Integer venuesProvice) {
        this.venuesProvice = venuesProvice;
    }

    public Integer getVenuesCity() {
        return venuesCity;
    }

    public void setVenuesCity(Integer venuesCity) {
        this.venuesCity = venuesCity;
    }

    public Integer getVenuesAreas() {
        return venuesAreas;
    }

    public void setVenuesAreas(Integer venuesAreas) {
        this.venuesAreas = venuesAreas;
    }

    public String getVenuesAddress() {
        return venuesAddress;
    }

    public void setVenuesAddress(String venuesAddress) {
        this.venuesAddress = venuesAddress == null ? null : venuesAddress.trim();
    }

    public BigDecimal getVenuesLongitude() {
        return venuesLongitude;
    }

    public void setVenuesLongitude(BigDecimal venuesLongitude) {
        this.venuesLongitude = venuesLongitude;
    }

    public BigDecimal getVenuesLatitude() {
        return venuesLatitude;
    }

    public void setVenuesLatitude(BigDecimal venuesLatitude) {
        this.venuesLatitude = venuesLatitude;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getVenuesName() {
        return venuesName;
    }

    public void setVenuesName(String venuesName) {
        this.venuesName = venuesName == null ? null : venuesName.trim();
    }

    public Integer getDeletestate() {
        return deletestate;
    }

    public void setDeletestate(Integer deletestate) {
        this.deletestate = deletestate;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}