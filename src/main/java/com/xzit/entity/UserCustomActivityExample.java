package com.xzit.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCustomActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCustomActivityExample() {
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

        public Criteria andUserCustomActivityIdIsNull() {
            addCriterion("user_custom_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdIsNotNull() {
            addCriterion("user_custom_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdEqualTo(Integer value) {
            addCriterion("user_custom_activity_id =", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdNotEqualTo(Integer value) {
            addCriterion("user_custom_activity_id <>", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdGreaterThan(Integer value) {
            addCriterion("user_custom_activity_id >", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_custom_activity_id >=", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdLessThan(Integer value) {
            addCriterion("user_custom_activity_id <", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_custom_activity_id <=", value, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdIn(List<Integer> values) {
            addCriterion("user_custom_activity_id in", values, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdNotIn(List<Integer> values) {
            addCriterion("user_custom_activity_id not in", values, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("user_custom_activity_id between", value1, value2, "userCustomActivityId");
            return (Criteria) this;
        }

        public Criteria andUserCustomActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_custom_activity_id not between", value1, value2, "userCustomActivityId");
            return (Criteria) this;
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdIsNull() {
            addCriterion("venues_allocation_id is null");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdIsNotNull() {
            addCriterion("venues_allocation_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdEqualTo(Integer value) {
            addCriterion("venues_allocation_id =", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdNotEqualTo(Integer value) {
            addCriterion("venues_allocation_id <>", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdGreaterThan(Integer value) {
            addCriterion("venues_allocation_id >", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_allocation_id >=", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdLessThan(Integer value) {
            addCriterion("venues_allocation_id <", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("venues_allocation_id <=", value, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdIn(List<Integer> values) {
            addCriterion("venues_allocation_id in", values, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdNotIn(List<Integer> values) {
            addCriterion("venues_allocation_id not in", values, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdBetween(Integer value1, Integer value2) {
            addCriterion("venues_allocation_id between", value1, value2, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_allocation_id not between", value1, value2, "venuesAllocationId");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeIsNull() {
            addCriterion("activities_setting_time is null");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeIsNotNull() {
            addCriterion("activities_setting_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeEqualTo(Date value) {
            addCriterion("activities_setting_time =", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeNotEqualTo(Date value) {
            addCriterion("activities_setting_time <>", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeGreaterThan(Date value) {
            addCriterion("activities_setting_time >", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activities_setting_time >=", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeLessThan(Date value) {
            addCriterion("activities_setting_time <", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeLessThanOrEqualTo(Date value) {
            addCriterion("activities_setting_time <=", value, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeIn(List<Date> values) {
            addCriterion("activities_setting_time in", values, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeNotIn(List<Date> values) {
            addCriterion("activities_setting_time not in", values, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeBetween(Date value1, Date value2) {
            addCriterion("activities_setting_time between", value1, value2, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesSettingTimeNotBetween(Date value1, Date value2) {
            addCriterion("activities_setting_time not between", value1, value2, "activitiesSettingTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeIsNull() {
            addCriterion("activities_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeIsNotNull() {
            addCriterion("activities_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeEqualTo(Date value) {
            addCriterion("activities_start_time =", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeNotEqualTo(Date value) {
            addCriterion("activities_start_time <>", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeGreaterThan(Date value) {
            addCriterion("activities_start_time >", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activities_start_time >=", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeLessThan(Date value) {
            addCriterion("activities_start_time <", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("activities_start_time <=", value, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeIn(List<Date> values) {
            addCriterion("activities_start_time in", values, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeNotIn(List<Date> values) {
            addCriterion("activities_start_time not in", values, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeBetween(Date value1, Date value2) {
            addCriterion("activities_start_time between", value1, value2, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("activities_start_time not between", value1, value2, "activitiesStartTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeIsNull() {
            addCriterion("activities_stop_time is null");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeIsNotNull() {
            addCriterion("activities_stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeEqualTo(Date value) {
            addCriterion("activities_stop_time =", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeNotEqualTo(Date value) {
            addCriterion("activities_stop_time <>", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeGreaterThan(Date value) {
            addCriterion("activities_stop_time >", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activities_stop_time >=", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeLessThan(Date value) {
            addCriterion("activities_stop_time <", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("activities_stop_time <=", value, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeIn(List<Date> values) {
            addCriterion("activities_stop_time in", values, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeNotIn(List<Date> values) {
            addCriterion("activities_stop_time not in", values, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeBetween(Date value1, Date value2) {
            addCriterion("activities_stop_time between", value1, value2, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andActivitiesStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("activities_stop_time not between", value1, value2, "activitiesStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeIsNull() {
            addCriterion("enlist_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeIsNotNull() {
            addCriterion("enlist_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeEqualTo(Date value) {
            addCriterion("enlist_start_time =", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeNotEqualTo(Date value) {
            addCriterion("enlist_start_time <>", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeGreaterThan(Date value) {
            addCriterion("enlist_start_time >", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enlist_start_time >=", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeLessThan(Date value) {
            addCriterion("enlist_start_time <", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("enlist_start_time <=", value, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeIn(List<Date> values) {
            addCriterion("enlist_start_time in", values, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeNotIn(List<Date> values) {
            addCriterion("enlist_start_time not in", values, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeBetween(Date value1, Date value2) {
            addCriterion("enlist_start_time between", value1, value2, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("enlist_start_time not between", value1, value2, "enlistStartTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeIsNull() {
            addCriterion("enlist_stop_time is null");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeIsNotNull() {
            addCriterion("enlist_stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeEqualTo(Date value) {
            addCriterion("enlist_stop_time =", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeNotEqualTo(Date value) {
            addCriterion("enlist_stop_time <>", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeGreaterThan(Date value) {
            addCriterion("enlist_stop_time >", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enlist_stop_time >=", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeLessThan(Date value) {
            addCriterion("enlist_stop_time <", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("enlist_stop_time <=", value, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeIn(List<Date> values) {
            addCriterion("enlist_stop_time in", values, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeNotIn(List<Date> values) {
            addCriterion("enlist_stop_time not in", values, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeBetween(Date value1, Date value2) {
            addCriterion("enlist_stop_time between", value1, value2, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andEnlistStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("enlist_stop_time not between", value1, value2, "enlistStopTime");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andEnlistnumIsNull() {
            addCriterion("enlistnum is null");
            return (Criteria) this;
        }

        public Criteria andEnlistnumIsNotNull() {
            addCriterion("enlistnum is not null");
            return (Criteria) this;
        }

        public Criteria andEnlistnumEqualTo(Integer value) {
            addCriterion("enlistnum =", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumNotEqualTo(Integer value) {
            addCriterion("enlistnum <>", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumGreaterThan(Integer value) {
            addCriterion("enlistnum >", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("enlistnum >=", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumLessThan(Integer value) {
            addCriterion("enlistnum <", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumLessThanOrEqualTo(Integer value) {
            addCriterion("enlistnum <=", value, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumIn(List<Integer> values) {
            addCriterion("enlistnum in", values, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumNotIn(List<Integer> values) {
            addCriterion("enlistnum not in", values, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumBetween(Integer value1, Integer value2) {
            addCriterion("enlistnum between", value1, value2, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andEnlistnumNotBetween(Integer value1, Integer value2) {
            addCriterion("enlistnum not between", value1, value2, "enlistnum");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyIsNull() {
            addCriterion("paymentmoney is null");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyIsNotNull() {
            addCriterion("paymentmoney is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyEqualTo(BigDecimal value) {
            addCriterion("paymentmoney =", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyNotEqualTo(BigDecimal value) {
            addCriterion("paymentmoney <>", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyGreaterThan(BigDecimal value) {
            addCriterion("paymentmoney >", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentmoney >=", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyLessThan(BigDecimal value) {
            addCriterion("paymentmoney <", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentmoney <=", value, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyIn(List<BigDecimal> values) {
            addCriterion("paymentmoney in", values, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyNotIn(List<BigDecimal> values) {
            addCriterion("paymentmoney not in", values, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentmoney between", value1, value2, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andPaymentmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentmoney not between", value1, value2, "paymentmoney");
            return (Criteria) this;
        }

        public Criteria andAuditingIsNull() {
            addCriterion("auditing is null");
            return (Criteria) this;
        }

        public Criteria andAuditingIsNotNull() {
            addCriterion("auditing is not null");
            return (Criteria) this;
        }

        public Criteria andAuditingEqualTo(Integer value) {
            addCriterion("auditing =", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingNotEqualTo(Integer value) {
            addCriterion("auditing <>", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingGreaterThan(Integer value) {
            addCriterion("auditing >", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditing >=", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingLessThan(Integer value) {
            addCriterion("auditing <", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingLessThanOrEqualTo(Integer value) {
            addCriterion("auditing <=", value, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingIn(List<Integer> values) {
            addCriterion("auditing in", values, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingNotIn(List<Integer> values) {
            addCriterion("auditing not in", values, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingBetween(Integer value1, Integer value2) {
            addCriterion("auditing between", value1, value2, "auditing");
            return (Criteria) this;
        }

        public Criteria andAuditingNotBetween(Integer value1, Integer value2) {
            addCriterion("auditing not between", value1, value2, "auditing");
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

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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

        public Criteria andActivitynameIsNull() {
            addCriterion("activityname is null");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNotNull() {
            addCriterion("activityname is not null");
            return (Criteria) this;
        }

        public Criteria andActivitynameEqualTo(String value) {
            addCriterion("activityname =", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotEqualTo(String value) {
            addCriterion("activityname <>", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThan(String value) {
            addCriterion("activityname >", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThanOrEqualTo(String value) {
            addCriterion("activityname >=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThan(String value) {
            addCriterion("activityname <", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThanOrEqualTo(String value) {
            addCriterion("activityname <=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLike(String value) {
            addCriterion("activityname like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotLike(String value) {
            addCriterion("activityname not like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameIn(List<String> values) {
            addCriterion("activityname in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotIn(List<String> values) {
            addCriterion("activityname not in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameBetween(String value1, String value2) {
            addCriterion("activityname between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotBetween(String value1, String value2) {
            addCriterion("activityname not between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andUserpayIsNull() {
            addCriterion("userpay is null");
            return (Criteria) this;
        }

        public Criteria andUserpayIsNotNull() {
            addCriterion("userpay is not null");
            return (Criteria) this;
        }

        public Criteria andUserpayEqualTo(BigDecimal value) {
            addCriterion("userpay =", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayNotEqualTo(BigDecimal value) {
            addCriterion("userpay <>", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayGreaterThan(BigDecimal value) {
            addCriterion("userpay >", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userpay >=", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayLessThan(BigDecimal value) {
            addCriterion("userpay <", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userpay <=", value, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayIn(List<BigDecimal> values) {
            addCriterion("userpay in", values, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayNotIn(List<BigDecimal> values) {
            addCriterion("userpay not in", values, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userpay between", value1, value2, "userpay");
            return (Criteria) this;
        }

        public Criteria andUserpayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userpay not between", value1, value2, "userpay");
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