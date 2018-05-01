package com.xzit.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VenuesAllocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VenuesAllocationExample() {
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

        public Criteria andVenuesConfigurationIsNull() {
            addCriterion("venues_configuration is null");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationIsNotNull() {
            addCriterion("venues_configuration is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationEqualTo(Integer value) {
            addCriterion("venues_configuration =", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationNotEqualTo(Integer value) {
            addCriterion("venues_configuration <>", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationGreaterThan(Integer value) {
            addCriterion("venues_configuration >", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_configuration >=", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationLessThan(Integer value) {
            addCriterion("venues_configuration <", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationLessThanOrEqualTo(Integer value) {
            addCriterion("venues_configuration <=", value, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationIn(List<Integer> values) {
            addCriterion("venues_configuration in", values, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationNotIn(List<Integer> values) {
            addCriterion("venues_configuration not in", values, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationBetween(Integer value1, Integer value2) {
            addCriterion("venues_configuration between", value1, value2, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesConfigurationNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_configuration not between", value1, value2, "venuesConfiguration");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateIsNull() {
            addCriterion("venues_allocation_state is null");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateIsNotNull() {
            addCriterion("venues_allocation_state is not null");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateEqualTo(Integer value) {
            addCriterion("venues_allocation_state =", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateNotEqualTo(Integer value) {
            addCriterion("venues_allocation_state <>", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateGreaterThan(Integer value) {
            addCriterion("venues_allocation_state >", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("venues_allocation_state >=", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateLessThan(Integer value) {
            addCriterion("venues_allocation_state <", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateLessThanOrEqualTo(Integer value) {
            addCriterion("venues_allocation_state <=", value, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateIn(List<Integer> values) {
            addCriterion("venues_allocation_state in", values, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateNotIn(List<Integer> values) {
            addCriterion("venues_allocation_state not in", values, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateBetween(Integer value1, Integer value2) {
            addCriterion("venues_allocation_state between", value1, value2, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andVenuesAllocationStateNotBetween(Integer value1, Integer value2) {
            addCriterion("venues_allocation_state not between", value1, value2, "venuesAllocationState");
            return (Criteria) this;
        }

        public Criteria andFeeScaleIsNull() {
            addCriterion("fee_scale is null");
            return (Criteria) this;
        }

        public Criteria andFeeScaleIsNotNull() {
            addCriterion("fee_scale is not null");
            return (Criteria) this;
        }

        public Criteria andFeeScaleEqualTo(BigDecimal value) {
            addCriterion("fee_scale =", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleNotEqualTo(BigDecimal value) {
            addCriterion("fee_scale <>", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleGreaterThan(BigDecimal value) {
            addCriterion("fee_scale >", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_scale >=", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleLessThan(BigDecimal value) {
            addCriterion("fee_scale <", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_scale <=", value, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleIn(List<BigDecimal> values) {
            addCriterion("fee_scale in", values, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleNotIn(List<BigDecimal> values) {
            addCriterion("fee_scale not in", values, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_scale between", value1, value2, "feeScale");
            return (Criteria) this;
        }

        public Criteria andFeeScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_scale not between", value1, value2, "feeScale");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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