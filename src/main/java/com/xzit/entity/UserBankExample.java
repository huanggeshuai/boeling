package com.xzit.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserBankExample() {
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

        public Criteria andUserbankidIsNull() {
            addCriterion("userbankid is null");
            return (Criteria) this;
        }

        public Criteria andUserbankidIsNotNull() {
            addCriterion("userbankid is not null");
            return (Criteria) this;
        }

        public Criteria andUserbankidEqualTo(Integer value) {
            addCriterion("userbankid =", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidNotEqualTo(Integer value) {
            addCriterion("userbankid <>", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidGreaterThan(Integer value) {
            addCriterion("userbankid >", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userbankid >=", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidLessThan(Integer value) {
            addCriterion("userbankid <", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidLessThanOrEqualTo(Integer value) {
            addCriterion("userbankid <=", value, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidIn(List<Integer> values) {
            addCriterion("userbankid in", values, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidNotIn(List<Integer> values) {
            addCriterion("userbankid not in", values, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidBetween(Integer value1, Integer value2) {
            addCriterion("userbankid between", value1, value2, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserbankidNotBetween(Integer value1, Integer value2) {
            addCriterion("userbankid not between", value1, value2, "userbankid");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberIsNull() {
            addCriterion("user_bank_number is null");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberIsNotNull() {
            addCriterion("user_bank_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberEqualTo(String value) {
            addCriterion("user_bank_number =", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberNotEqualTo(String value) {
            addCriterion("user_bank_number <>", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberGreaterThan(String value) {
            addCriterion("user_bank_number >", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_bank_number >=", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberLessThan(String value) {
            addCriterion("user_bank_number <", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberLessThanOrEqualTo(String value) {
            addCriterion("user_bank_number <=", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberLike(String value) {
            addCriterion("user_bank_number like", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberNotLike(String value) {
            addCriterion("user_bank_number not like", value, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberIn(List<String> values) {
            addCriterion("user_bank_number in", values, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberNotIn(List<String> values) {
            addCriterion("user_bank_number not in", values, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberBetween(String value1, String value2) {
            addCriterion("user_bank_number between", value1, value2, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andUserBankNumberNotBetween(String value1, String value2) {
            addCriterion("user_bank_number not between", value1, value2, "userBankNumber");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
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