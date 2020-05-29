package com.food.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class OrderFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFormExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExpired_timeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpired_timeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpired_timeEqualTo(Date value) {
            addCriterion("expired_time =", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeNotEqualTo(Date value) {
            addCriterion("expired_time <>", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeGreaterThan(Date value) {
            addCriterion("expired_time >", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("expired_time >=", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeLessThan(Date value) {
            addCriterion("expired_time <", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeLessThanOrEqualTo(Date value) {
            addCriterion("expired_time <=", value, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeIn(List<Date> values) {
            addCriterion("expired_time in", values, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeNotIn(List<Date> values) {
            addCriterion("expired_time not in", values, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeBetween(Date value1, Date value2) {
            addCriterion("expired_time between", value1, value2, "expired_time");
            return (Criteria) this;
        }

        public Criteria andExpired_timeNotBetween(Date value1, Date value2) {
            addCriterion("expired_time not between", value1, value2, "expired_time");
            return (Criteria) this;
        }

        public Criteria andBuyerIsNull() {
            addCriterion("buyer is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIsNotNull() {
            addCriterion("buyer is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEqualTo(String value) {
            addCriterion("buyer =", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotEqualTo(String value) {
            addCriterion("buyer <>", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerGreaterThan(String value) {
            addCriterion("buyer >", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("buyer >=", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLessThan(String value) {
            addCriterion("buyer <", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLessThanOrEqualTo(String value) {
            addCriterion("buyer <=", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerLike(String value) {
            addCriterion("buyer like", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotLike(String value) {
            addCriterion("buyer not like", value, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerIn(List<String> values) {
            addCriterion("buyer in", values, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotIn(List<String> values) {
            addCriterion("buyer not in", values, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerBetween(String value1, String value2) {
            addCriterion("buyer between", value1, value2, "buyer");
            return (Criteria) this;
        }

        public Criteria andBuyerNotBetween(String value1, String value2) {
            addCriterion("buyer not between", value1, value2, "buyer");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeEqualTo(String value) {
            addCriterion("order_code =", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThan(String value) {
            addCriterion("order_code >", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThan(String value) {
            addCriterion("order_code <", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLike(String value) {
            addCriterion("order_code like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotLike(String value) {
            addCriterion("order_code not like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIn(List<String> values) {
            addCriterion("order_code in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberEqualTo(String value) {
            addCriterion("order_number =", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThan(String value) {
            addCriterion("order_number >", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThan(String value) {
            addCriterion("order_number <", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLike(String value) {
            addCriterion("order_number like", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotLike(String value) {
            addCriterion("order_number not like", value, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIn(List<String> values) {
            addCriterion("order_number in", values, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "order_number");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "order_number");
            return (Criteria) this;
        }

        public Criteria andPayment_methodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPayment_methodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayment_methodEqualTo(String value) {
            addCriterion("payment_method =", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodGreaterThan(String value) {
            addCriterion("payment_method >", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodLessThan(String value) {
            addCriterion("payment_method <", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodLike(String value) {
            addCriterion("payment_method like", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodNotLike(String value) {
            addCriterion("payment_method not like", value, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodIn(List<String> values) {
            addCriterion("payment_method in", values, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "payment_method");
            return (Criteria) this;
        }

        public Criteria andPayment_methodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "payment_method");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeIsNull() {
            addCriterion("takeaway_time is null");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeIsNotNull() {
            addCriterion("takeaway_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeEqualTo(Date value) {
            addCriterion("takeaway_time =", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeNotEqualTo(Date value) {
            addCriterion("takeaway_time <>", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeGreaterThan(Date value) {
            addCriterion("takeaway_time >", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("takeaway_time >=", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeLessThan(Date value) {
            addCriterion("takeaway_time <", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeLessThanOrEqualTo(Date value) {
            addCriterion("takeaway_time <=", value, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeIn(List<Date> values) {
            addCriterion("takeaway_time in", values, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeNotIn(List<Date> values) {
            addCriterion("takeaway_time not in", values, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeBetween(Date value1, Date value2) {
            addCriterion("takeaway_time between", value1, value2, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTakeaway_timeNotBetween(Date value1, Date value2) {
            addCriterion("takeaway_time not between", value1, value2, "takeaway_time");
            return (Criteria) this;
        }

        public Criteria andTotal_countIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotal_countIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_countEqualTo(Integer value) {
            addCriterion("total_count =", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countGreaterThan(Integer value) {
            addCriterion("total_count >", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countLessThan(Integer value) {
            addCriterion("total_count <", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countIn(List<Integer> values) {
            addCriterion("total_count in", values, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countNotIn(List<Integer> values) {
            addCriterion("total_count not in", values, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_countNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "total_count");
            return (Criteria) this;
        }

        public Criteria andTotal_priceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotal_priceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_priceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "total_price");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andDining_methodIsNull() {
            addCriterion("dining_method is null");
            return (Criteria) this;
        }

        public Criteria andDining_methodIsNotNull() {
            addCriterion("dining_method is not null");
            return (Criteria) this;
        }

        public Criteria andDining_methodEqualTo(String value) {
            addCriterion("dining_method =", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodNotEqualTo(String value) {
            addCriterion("dining_method <>", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodGreaterThan(String value) {
            addCriterion("dining_method >", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodGreaterThanOrEqualTo(String value) {
            addCriterion("dining_method >=", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodLessThan(String value) {
            addCriterion("dining_method <", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodLessThanOrEqualTo(String value) {
            addCriterion("dining_method <=", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodLike(String value) {
            addCriterion("dining_method like", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodNotLike(String value) {
            addCriterion("dining_method not like", value, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodIn(List<String> values) {
            addCriterion("dining_method in", values, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodNotIn(List<String> values) {
            addCriterion("dining_method not in", values, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodBetween(String value1, String value2) {
            addCriterion("dining_method between", value1, value2, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDining_methodNotBetween(String value1, String value2) {
            addCriterion("dining_method not between", value1, value2, "dining_method");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idIsNull() {
            addCriterion("delivery_address_id is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idIsNotNull() {
            addCriterion("delivery_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idEqualTo(Integer value) {
            addCriterion("delivery_address_id =", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idNotEqualTo(Integer value) {
            addCriterion("delivery_address_id <>", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idGreaterThan(Integer value) {
            addCriterion("delivery_address_id >", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_address_id >=", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idLessThan(Integer value) {
            addCriterion("delivery_address_id <", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_address_id <=", value, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idIn(List<Integer> values) {
            addCriterion("delivery_address_id in", values, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idNotIn(List<Integer> values) {
            addCriterion("delivery_address_id not in", values, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idBetween(Integer value1, Integer value2) {
            addCriterion("delivery_address_id between", value1, value2, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andDelivery_address_idNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_address_id not between", value1, value2, "delivery_address_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchant_idIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchant_idEqualTo(Integer value) {
            addCriterion("merchant_id =", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idNotEqualTo(Integer value) {
            addCriterion("merchant_id <>", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idGreaterThan(Integer value) {
            addCriterion("merchant_id >", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_id >=", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idLessThan(Integer value) {
            addCriterion("merchant_id <", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_id <=", value, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idIn(List<Integer> values) {
            addCriterion("merchant_id in", values, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idNotIn(List<Integer> values) {
            addCriterion("merchant_id not in", values, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idBetween(Integer value1, Integer value2) {
            addCriterion("merchant_id between", value1, value2, "merchant_id");
            return (Criteria) this;
        }

        public Criteria andMerchant_idNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_id not between", value1, value2, "merchant_id");
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