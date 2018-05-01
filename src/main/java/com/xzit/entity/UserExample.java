package com.xzit.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserTruenameIsNull() {
            addCriterion("user_truename is null");
            return (Criteria) this;
        }

        public Criteria andUserTruenameIsNotNull() {
            addCriterion("user_truename is not null");
            return (Criteria) this;
        }

        public Criteria andUserTruenameEqualTo(String value) {
            addCriterion("user_truename =", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameNotEqualTo(String value) {
            addCriterion("user_truename <>", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameGreaterThan(String value) {
            addCriterion("user_truename >", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("user_truename >=", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameLessThan(String value) {
            addCriterion("user_truename <", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameLessThanOrEqualTo(String value) {
            addCriterion("user_truename <=", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameLike(String value) {
            addCriterion("user_truename like", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameNotLike(String value) {
            addCriterion("user_truename not like", value, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameIn(List<String> values) {
            addCriterion("user_truename in", values, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameNotIn(List<String> values) {
            addCriterion("user_truename not in", values, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameBetween(String value1, String value2) {
            addCriterion("user_truename between", value1, value2, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserTruenameNotBetween(String value1, String value2) {
            addCriterion("user_truename not between", value1, value2, "userTruename");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordIsNull() {
            addCriterion("user_paypassword is null");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordIsNotNull() {
            addCriterion("user_paypassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordEqualTo(String value) {
            addCriterion("user_paypassword =", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordNotEqualTo(String value) {
            addCriterion("user_paypassword <>", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordGreaterThan(String value) {
            addCriterion("user_paypassword >", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_paypassword >=", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordLessThan(String value) {
            addCriterion("user_paypassword <", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordLessThanOrEqualTo(String value) {
            addCriterion("user_paypassword <=", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordLike(String value) {
            addCriterion("user_paypassword like", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordNotLike(String value) {
            addCriterion("user_paypassword not like", value, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordIn(List<String> values) {
            addCriterion("user_paypassword in", values, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordNotIn(List<String> values) {
            addCriterion("user_paypassword not in", values, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordBetween(String value1, String value2) {
            addCriterion("user_paypassword between", value1, value2, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserPaypasswordNotBetween(String value1, String value2) {
            addCriterion("user_paypassword not between", value1, value2, "userPaypassword");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIsNull() {
            addCriterion("user_balance is null");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIsNotNull() {
            addCriterion("user_balance is not null");
            return (Criteria) this;
        }

        public Criteria andUserBalanceEqualTo(BigDecimal value) {
            addCriterion("user_balance =", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotEqualTo(BigDecimal value) {
            addCriterion("user_balance <>", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceGreaterThan(BigDecimal value) {
            addCriterion("user_balance >", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_balance >=", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceLessThan(BigDecimal value) {
            addCriterion("user_balance <", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_balance <=", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIn(List<BigDecimal> values) {
            addCriterion("user_balance in", values, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotIn(List<BigDecimal> values) {
            addCriterion("user_balance not in", values, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_balance between", value1, value2, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_balance not between", value1, value2, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserResignDateIsNull() {
            addCriterion("user_resign_date is null");
            return (Criteria) this;
        }

        public Criteria andUserResignDateIsNotNull() {
            addCriterion("user_resign_date is not null");
            return (Criteria) this;
        }

        public Criteria andUserResignDateEqualTo(Date value) {
            addCriterion("user_resign_date =", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateNotEqualTo(Date value) {
            addCriterion("user_resign_date <>", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateGreaterThan(Date value) {
            addCriterion("user_resign_date >", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("user_resign_date >=", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateLessThan(Date value) {
            addCriterion("user_resign_date <", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateLessThanOrEqualTo(Date value) {
            addCriterion("user_resign_date <=", value, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateIn(List<Date> values) {
            addCriterion("user_resign_date in", values, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateNotIn(List<Date> values) {
            addCriterion("user_resign_date not in", values, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateBetween(Date value1, Date value2) {
            addCriterion("user_resign_date between", value1, value2, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserResignDateNotBetween(Date value1, Date value2) {
            addCriterion("user_resign_date not between", value1, value2, "userResignDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateIsNull() {
            addCriterion("user_login_date is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateIsNotNull() {
            addCriterion("user_login_date is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateEqualTo(Date value) {
            addCriterion("user_login_date =", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateNotEqualTo(Date value) {
            addCriterion("user_login_date <>", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateGreaterThan(Date value) {
            addCriterion("user_login_date >", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("user_login_date >=", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateLessThan(Date value) {
            addCriterion("user_login_date <", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("user_login_date <=", value, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateIn(List<Date> values) {
            addCriterion("user_login_date in", values, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateNotIn(List<Date> values) {
            addCriterion("user_login_date not in", values, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateBetween(Date value1, Date value2) {
            addCriterion("user_login_date between", value1, value2, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("user_login_date not between", value1, value2, "userLoginDate");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountIsNull() {
            addCriterion("user_login_count is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountIsNotNull() {
            addCriterion("user_login_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountEqualTo(Integer value) {
            addCriterion("user_login_count =", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountNotEqualTo(Integer value) {
            addCriterion("user_login_count <>", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountGreaterThan(Integer value) {
            addCriterion("user_login_count >", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_login_count >=", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountLessThan(Integer value) {
            addCriterion("user_login_count <", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_login_count <=", value, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountIn(List<Integer> values) {
            addCriterion("user_login_count in", values, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountNotIn(List<Integer> values) {
            addCriterion("user_login_count not in", values, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountBetween(Integer value1, Integer value2) {
            addCriterion("user_login_count between", value1, value2, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserLoginCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_login_count not between", value1, value2, "userLoginCount");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("user_state is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("user_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(Integer value) {
            addCriterion("user_state =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(Integer value) {
            addCriterion("user_state <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(Integer value) {
            addCriterion("user_state >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_state >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(Integer value) {
            addCriterion("user_state <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(Integer value) {
            addCriterion("user_state <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<Integer> values) {
            addCriterion("user_state in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<Integer> values) {
            addCriterion("user_state not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(Integer value1, Integer value2) {
            addCriterion("user_state between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(Integer value1, Integer value2) {
            addCriterion("user_state not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityIsNull() {
            addCriterion("user_authority is null");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityIsNotNull() {
            addCriterion("user_authority is not null");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityEqualTo(Integer value) {
            addCriterion("user_authority =", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityNotEqualTo(Integer value) {
            addCriterion("user_authority <>", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityGreaterThan(Integer value) {
            addCriterion("user_authority >", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_authority >=", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityLessThan(Integer value) {
            addCriterion("user_authority <", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityLessThanOrEqualTo(Integer value) {
            addCriterion("user_authority <=", value, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityIn(List<Integer> values) {
            addCriterion("user_authority in", values, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityNotIn(List<Integer> values) {
            addCriterion("user_authority not in", values, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityBetween(Integer value1, Integer value2) {
            addCriterion("user_authority between", value1, value2, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserAuthorityNotBetween(Integer value1, Integer value2) {
            addCriterion("user_authority not between", value1, value2, "userAuthority");
            return (Criteria) this;
        }

        public Criteria andUserDriveIsNull() {
            addCriterion("user_drive is null");
            return (Criteria) this;
        }

        public Criteria andUserDriveIsNotNull() {
            addCriterion("user_drive is not null");
            return (Criteria) this;
        }

        public Criteria andUserDriveEqualTo(String value) {
            addCriterion("user_drive =", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveNotEqualTo(String value) {
            addCriterion("user_drive <>", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveGreaterThan(String value) {
            addCriterion("user_drive >", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveGreaterThanOrEqualTo(String value) {
            addCriterion("user_drive >=", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveLessThan(String value) {
            addCriterion("user_drive <", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveLessThanOrEqualTo(String value) {
            addCriterion("user_drive <=", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveLike(String value) {
            addCriterion("user_drive like", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveNotLike(String value) {
            addCriterion("user_drive not like", value, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveIn(List<String> values) {
            addCriterion("user_drive in", values, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveNotIn(List<String> values) {
            addCriterion("user_drive not in", values, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveBetween(String value1, String value2) {
            addCriterion("user_drive between", value1, value2, "userDrive");
            return (Criteria) this;
        }

        public Criteria andUserDriveNotBetween(String value1, String value2) {
            addCriterion("user_drive not between", value1, value2, "userDrive");
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