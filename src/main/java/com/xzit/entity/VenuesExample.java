package com.xzit.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VenuesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VenuesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andVenuesidIsNull() {
            addCriterion("venuesid is null");
            return (Criteria) this;
        }

        public Criteria andVenuesidIsNotNull() {
            addCriterion("venuesid is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesidEqualTo(Integer value) {
            addCriterion("venuesid =", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidNotEqualTo(Integer value) {
            addCriterion("venuesid <>", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidGreaterThan(Integer value) {
            addCriterion("venuesid >", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("venuesid >=", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidLessThan(Integer value) {
            addCriterion("venuesid <", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidLessThanOrEqualTo(Integer value) {
            addCriterion("venuesid <=", value, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidIn(List<Integer> values) {
            addCriterion("venuesid in", values, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidNotIn(List<Integer> values) {
            addCriterion("venuesid not in", values, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidBetween(Integer value1, Integer value2) {
            addCriterion("venuesid between", value1, value2, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesidNotBetween(Integer value1, Integer value2) {
            addCriterion("venuesid not between", value1, value2, "venuesid");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeIsNull() {
            addCriterion("venues_user_charge is null");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeIsNotNull() {
            addCriterion("venues_user_charge is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeEqualTo(Integer value) {
            addCriterion("venues_user_charge =", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeNotEqualTo(Integer value) {
            addCriterion("venues_user_charge <>", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeGreaterThan(Integer value) {
            addCriterion("venues_user_charge >", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_user_charge >=", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeLessThan(Integer value) {
            addCriterion("venues_user_charge <", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeLessThanOrEqualTo(Integer value) {
            addCriterion("venues_user_charge <=", value, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeIn(List<Integer> values) {
            addCriterion("venues_user_charge in", values, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeNotIn(List<Integer> values) {
            addCriterion("venues_user_charge not in", values, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeBetween(Integer value1, Integer value2) {
            addCriterion("venues_user_charge between", value1, value2, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesUserChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_user_charge not between", value1, value2, "venuesUserCharge");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceIsNull() {
            addCriterion("venues_provice is null");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceIsNotNull() {
            addCriterion("venues_provice is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceEqualTo(Integer value) {
            addCriterion("venues_provice =", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceNotEqualTo(Integer value) {
            addCriterion("venues_provice <>", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceGreaterThan(Integer value) {
            addCriterion("venues_provice >", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_provice >=", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceLessThan(Integer value) {
            addCriterion("venues_provice <", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceLessThanOrEqualTo(Integer value) {
            addCriterion("venues_provice <=", value, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceIn(List<Integer> values) {
            addCriterion("venues_provice in", values, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceNotIn(List<Integer> values) {
            addCriterion("venues_provice not in", values, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceBetween(Integer value1, Integer value2) {
            addCriterion("venues_provice between", value1, value2, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesProviceNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_provice not between", value1, value2, "venuesProvice");
            return (Criteria) this;
        }

        public Criteria andVenuesCityIsNull() {
            addCriterion("venues_city is null");
            return (Criteria) this;
        }

        public Criteria andVenuesCityIsNotNull() {
            addCriterion("venues_city is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesCityEqualTo(Integer value) {
            addCriterion("venues_city =", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityNotEqualTo(Integer value) {
            addCriterion("venues_city <>", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityGreaterThan(Integer value) {
            addCriterion("venues_city >", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_city >=", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityLessThan(Integer value) {
            addCriterion("venues_city <", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityLessThanOrEqualTo(Integer value) {
            addCriterion("venues_city <=", value, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityIn(List<Integer> values) {
            addCriterion("venues_city in", values, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityNotIn(List<Integer> values) {
            addCriterion("venues_city not in", values, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityBetween(Integer value1, Integer value2) {
            addCriterion("venues_city between", value1, value2, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesCityNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_city not between", value1, value2, "venuesCity");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasIsNull() {
            addCriterion("venues_areas is null");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasIsNotNull() {
            addCriterion("venues_areas is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasEqualTo(Integer value) {
            addCriterion("venues_areas =", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasNotEqualTo(Integer value) {
            addCriterion("venues_areas <>", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasGreaterThan(Integer value) {
            addCriterion("venues_areas >", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_areas >=", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasLessThan(Integer value) {
            addCriterion("venues_areas <", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasLessThanOrEqualTo(Integer value) {
            addCriterion("venues_areas <=", value, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasIn(List<Integer> values) {
            addCriterion("venues_areas in", values, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasNotIn(List<Integer> values) {
            addCriterion("venues_areas not in", values, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasBetween(Integer value1, Integer value2) {
            addCriterion("venues_areas between", value1, value2, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAreasNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_areas not between", value1, value2, "venuesAreas");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressIsNull() {
            addCriterion("venues_address is null");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressIsNotNull() {
            addCriterion("venues_address is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressEqualTo(String value) {
            addCriterion("venues_address =", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressNotEqualTo(String value) {
            addCriterion("venues_address <>", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressGreaterThan(String value) {
            addCriterion("venues_address >", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressGreaterThanOrEqualTo(String value) {
            addCriterion("venues_address >=", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressLessThan(String value) {
            addCriterion("venues_address <", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressLessThanOrEqualTo(String value) {
            addCriterion("venues_address <=", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressLike(String value) {
            addCriterion("venues_address like", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressNotLike(String value) {
            addCriterion("venues_address not like", value, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressIn(List<String> values) {
            addCriterion("venues_address in", values, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressNotIn(List<String> values) {
            addCriterion("venues_address not in", values, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressBetween(String value1, String value2) {
            addCriterion("venues_address between", value1, value2, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesAddressNotBetween(String value1, String value2) {
            addCriterion("venues_address not between", value1, value2, "venuesAddress");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeIsNull() {
            addCriterion("venues_longitude is null");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeIsNotNull() {
            addCriterion("venues_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeEqualTo(BigDecimal value) {
            addCriterion("venues_longitude =", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("venues_longitude <>", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeGreaterThan(BigDecimal value) {
            addCriterion("venues_longitude >", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("venues_longitude >=", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeLessThan(BigDecimal value) {
            addCriterion("venues_longitude <", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("venues_longitude <=", value, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeIn(List<BigDecimal> values) {
            addCriterion("venues_longitude in", values, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("venues_longitude not in", values, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("venues_longitude between", value1, value2, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("venues_longitude not between", value1, value2, "venuesLongitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeIsNull() {
            addCriterion("venues_latitude is null");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeIsNotNull() {
            addCriterion("venues_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeEqualTo(BigDecimal value) {
            addCriterion("venues_latitude =", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("venues_latitude <>", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeGreaterThan(BigDecimal value) {
            addCriterion("venues_latitude >", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("venues_latitude >=", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeLessThan(BigDecimal value) {
            addCriterion("venues_latitude <", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("venues_latitude <=", value, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeIn(List<BigDecimal> values) {
            addCriterion("venues_latitude in", values, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("venues_latitude not in", values, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("venues_latitude between", value1, value2, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andVenuesLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("venues_latitude not between", value1, value2, "venuesLatitude");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterionForJDBCTime("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterionForJDBCTime("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterionForJDBCTime("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterionForJDBCTime("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterionForJDBCTime("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterionForJDBCTime("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andVenuesNameIsNull() {
            addCriterion("venues_name is null");
            return (Criteria) this;
        }

        public Criteria andVenuesNameIsNotNull() {
            addCriterion("venues_name is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesNameEqualTo(String value) {
            addCriterion("venues_name =", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameNotEqualTo(String value) {
            addCriterion("venues_name <>", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameGreaterThan(String value) {
            addCriterion("venues_name >", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameGreaterThanOrEqualTo(String value) {
            addCriterion("venues_name >=", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameLessThan(String value) {
            addCriterion("venues_name <", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameLessThanOrEqualTo(String value) {
            addCriterion("venues_name <=", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameLike(String value) {
            addCriterion("venues_name like", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameNotLike(String value) {
            addCriterion("venues_name not like", value, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameIn(List<String> values) {
            addCriterion("venues_name in", values, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameNotIn(List<String> values) {
            addCriterion("venues_name not in", values, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameBetween(String value1, String value2) {
            addCriterion("venues_name between", value1, value2, "venuesName");
            return (Criteria) this;
        }

        public Criteria andVenuesNameNotBetween(String value1, String value2) {
            addCriterion("venues_name not between", value1, value2, "venuesName");
            return (Criteria) this;
        }

        public Criteria andDeletestateIsNull() {
            addCriterion("deletestate is null");
            return (Criteria) this;
        }

        public Criteria andDeletestateIsNotNull() {
            addCriterion("deletestate is not null");
            return (Criteria) this;
        }

        public Criteria andDeletestateEqualTo(Integer value) {
            addCriterion("deletestate =", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateNotEqualTo(Integer value) {
            addCriterion("deletestate <>", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateGreaterThan(Integer value) {
            addCriterion("deletestate >", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("deletestate >=", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateLessThan(Integer value) {
            addCriterion("deletestate <", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateLessThanOrEqualTo(Integer value) {
            addCriterion("deletestate <=", value, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateIn(List<Integer> values) {
            addCriterion("deletestate in", values, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateNotIn(List<Integer> values) {
            addCriterion("deletestate not in", values, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateBetween(Integer value1, Integer value2) {
            addCriterion("deletestate between", value1, value2, "deletestate");
            return (Criteria) this;
        }

        public Criteria andDeletestateNotBetween(Integer value1, Integer value2) {
            addCriterion("deletestate not between", value1, value2, "deletestate");
            return (Criteria) this;
        }

        public Criteria andCauseIsNull() {
            addCriterion("cause is null");
            return (Criteria) this;
        }

        public Criteria andCauseIsNotNull() {
            addCriterion("cause is not null");
            return (Criteria) this;
        }

        public Criteria andCauseEqualTo(String value) {
            addCriterion("cause =", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotEqualTo(String value) {
            addCriterion("cause <>", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThan(String value) {
            addCriterion("cause >", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThanOrEqualTo(String value) {
            addCriterion("cause >=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThan(String value) {
            addCriterion("cause <", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThanOrEqualTo(String value) {
            addCriterion("cause <=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLike(String value) {
            addCriterion("cause like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotLike(String value) {
            addCriterion("cause not like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseIn(List<String> values) {
            addCriterion("cause in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotIn(List<String> values) {
            addCriterion("cause not in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseBetween(String value1, String value2) {
            addCriterion("cause between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotBetween(String value1, String value2) {
            addCriterion("cause not between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageurl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageurl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageurl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageurl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageurl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageurl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageurl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageurl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageurl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageurl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageurl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageurl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}