package com.food.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNull() {
            addCriterion("notice is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNotNull() {
            addCriterion("notice is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEqualTo(String value) {
            addCriterion("notice =", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotEqualTo(String value) {
            addCriterion("notice <>", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThan(String value) {
            addCriterion("notice >", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("notice >=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThan(String value) {
            addCriterion("notice <", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThanOrEqualTo(String value) {
            addCriterion("notice <=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLike(String value) {
            addCriterion("notice like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotLike(String value) {
            addCriterion("notice not like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeIn(List<String> values) {
            addCriterion("notice in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotIn(List<String> values) {
            addCriterion("notice not in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeBetween(String value1, String value2) {
            addCriterion("notice between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotBetween(String value1, String value2) {
            addCriterion("notice not between", value1, value2, "notice");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAvailabilityIsNull() {
            addCriterion("availability is null");
            return (Criteria) this;
        }

        public Criteria andAvailabilityIsNotNull() {
            addCriterion("availability is not null");
            return (Criteria) this;
        }

        public Criteria andAvailabilityEqualTo(String value) {
            addCriterion("availability =", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityNotEqualTo(String value) {
            addCriterion("availability <>", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityGreaterThan(String value) {
            addCriterion("availability >", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityGreaterThanOrEqualTo(String value) {
            addCriterion("availability >=", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityLessThan(String value) {
            addCriterion("availability <", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityLessThanOrEqualTo(String value) {
            addCriterion("availability <=", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityLike(String value) {
            addCriterion("availability like", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityNotLike(String value) {
            addCriterion("availability not like", value, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityIn(List<String> values) {
            addCriterion("availability in", values, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityNotIn(List<String> values) {
            addCriterion("availability not in", values, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityBetween(String value1, String value2) {
            addCriterion("availability between", value1, value2, "availability");
            return (Criteria) this;
        }

        public Criteria andAvailabilityNotBetween(String value1, String value2) {
            addCriterion("availability not between", value1, value2, "availability");
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

        public Criteria andWechatPaymentCodeUrlIsNull() {
            addCriterion("wechat_payment_code_url is null");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlIsNotNull() {
            addCriterion("wechat_payment_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlEqualTo(String value) {
            addCriterion("wechat_payment_code_url =", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlNotEqualTo(String value) {
            addCriterion("wechat_payment_code_url <>", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlGreaterThan(String value) {
            addCriterion("wechat_payment_code_url >", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_payment_code_url >=", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlLessThan(String value) {
            addCriterion("wechat_payment_code_url <", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("wechat_payment_code_url <=", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlLike(String value) {
            addCriterion("wechat_payment_code_url like", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlNotLike(String value) {
            addCriterion("wechat_payment_code_url not like", value, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlIn(List<String> values) {
            addCriterion("wechat_payment_code_url in", values, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlNotIn(List<String> values) {
            addCriterion("wechat_payment_code_url not in", values, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlBetween(String value1, String value2) {
            addCriterion("wechat_payment_code_url between", value1, value2, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPaymentCodeUrlNotBetween(String value1, String value2) {
            addCriterion("wechat_payment_code_url not between", value1, value2, "wechatPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIsNull() {
            addCriterion("wechat_url is null");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIsNotNull() {
            addCriterion("wechat_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechatUrlEqualTo(String value) {
            addCriterion("wechat_url =", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotEqualTo(String value) {
            addCriterion("wechat_url <>", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlGreaterThan(String value) {
            addCriterion("wechat_url >", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_url >=", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLessThan(String value) {
            addCriterion("wechat_url <", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLessThanOrEqualTo(String value) {
            addCriterion("wechat_url <=", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlLike(String value) {
            addCriterion("wechat_url like", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotLike(String value) {
            addCriterion("wechat_url not like", value, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlIn(List<String> values) {
            addCriterion("wechat_url in", values, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotIn(List<String> values) {
            addCriterion("wechat_url not in", values, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlBetween(String value1, String value2) {
            addCriterion("wechat_url between", value1, value2, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andWechatUrlNotBetween(String value1, String value2) {
            addCriterion("wechat_url not between", value1, value2, "wechatUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlIsNull() {
            addCriterion("alipay_url is null");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlIsNotNull() {
            addCriterion("alipay_url is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlEqualTo(String value) {
            addCriterion("alipay_url =", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlNotEqualTo(String value) {
            addCriterion("alipay_url <>", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlGreaterThan(String value) {
            addCriterion("alipay_url >", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_url >=", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlLessThan(String value) {
            addCriterion("alipay_url <", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlLessThanOrEqualTo(String value) {
            addCriterion("alipay_url <=", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlLike(String value) {
            addCriterion("alipay_url like", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlNotLike(String value) {
            addCriterion("alipay_url not like", value, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlIn(List<String> values) {
            addCriterion("alipay_url in", values, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlNotIn(List<String> values) {
            addCriterion("alipay_url not in", values, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlBetween(String value1, String value2) {
            addCriterion("alipay_url between", value1, value2, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayUrlNotBetween(String value1, String value2) {
            addCriterion("alipay_url not between", value1, value2, "alipayUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlIsNull() {
            addCriterion("alipay_payment_code_url is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlIsNotNull() {
            addCriterion("alipay_payment_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlEqualTo(String value) {
            addCriterion("alipay_payment_code_url =", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlNotEqualTo(String value) {
            addCriterion("alipay_payment_code_url <>", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlGreaterThan(String value) {
            addCriterion("alipay_payment_code_url >", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_payment_code_url >=", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlLessThan(String value) {
            addCriterion("alipay_payment_code_url <", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("alipay_payment_code_url <=", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlLike(String value) {
            addCriterion("alipay_payment_code_url like", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlNotLike(String value) {
            addCriterion("alipay_payment_code_url not like", value, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlIn(List<String> values) {
            addCriterion("alipay_payment_code_url in", values, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlNotIn(List<String> values) {
            addCriterion("alipay_payment_code_url not in", values, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlBetween(String value1, String value2) {
            addCriterion("alipay_payment_code_url between", value1, value2, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andAlipayPaymentCodeUrlNotBetween(String value1, String value2) {
            addCriterion("alipay_payment_code_url not between", value1, value2, "alipayPaymentCodeUrl");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNull() {
            addCriterion("bank_card_number is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNotNull() {
            addCriterion("bank_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberEqualTo(String value) {
            addCriterion("bank_card_number =", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotEqualTo(String value) {
            addCriterion("bank_card_number <>", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThan(String value) {
            addCriterion("bank_card_number >", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_number >=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThan(String value) {
            addCriterion("bank_card_number <", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThanOrEqualTo(String value) {
            addCriterion("bank_card_number <=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLike(String value) {
            addCriterion("bank_card_number like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotLike(String value) {
            addCriterion("bank_card_number not like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIn(List<String> values) {
            addCriterion("bank_card_number in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotIn(List<String> values) {
            addCriterion("bank_card_number not in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberBetween(String value1, String value2) {
            addCriterion("bank_card_number between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotBetween(String value1, String value2) {
            addCriterion("bank_card_number not between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIsNull() {
            addCriterion("bank_card_name is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIsNotNull() {
            addCriterion("bank_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNameEqualTo(String value) {
            addCriterion("bank_card_name =", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotEqualTo(String value) {
            addCriterion("bank_card_name <>", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameGreaterThan(String value) {
            addCriterion("bank_card_name >", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_name >=", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLessThan(String value) {
            addCriterion("bank_card_name <", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLessThanOrEqualTo(String value) {
            addCriterion("bank_card_name <=", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameLike(String value) {
            addCriterion("bank_card_name like", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotLike(String value) {
            addCriterion("bank_card_name not like", value, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameIn(List<String> values) {
            addCriterion("bank_card_name in", values, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotIn(List<String> values) {
            addCriterion("bank_card_name not in", values, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameBetween(String value1, String value2) {
            addCriterion("bank_card_name between", value1, value2, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardNameNotBetween(String value1, String value2) {
            addCriterion("bank_card_name not between", value1, value2, "bankCardName");
            return (Criteria) this;
        }

        public Criteria andBankCardDateIsNull() {
            addCriterion("bank_card_date is null");
            return (Criteria) this;
        }

        public Criteria andBankCardDateIsNotNull() {
            addCriterion("bank_card_date is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardDateEqualTo(String value) {
            addCriterion("bank_card_date =", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateNotEqualTo(String value) {
            addCriterion("bank_card_date <>", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateGreaterThan(String value) {
            addCriterion("bank_card_date >", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_date >=", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateLessThan(String value) {
            addCriterion("bank_card_date <", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateLessThanOrEqualTo(String value) {
            addCriterion("bank_card_date <=", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateLike(String value) {
            addCriterion("bank_card_date like", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateNotLike(String value) {
            addCriterion("bank_card_date not like", value, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateIn(List<String> values) {
            addCriterion("bank_card_date in", values, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateNotIn(List<String> values) {
            addCriterion("bank_card_date not in", values, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateBetween(String value1, String value2) {
            addCriterion("bank_card_date between", value1, value2, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andBankCardDateNotBetween(String value1, String value2) {
            addCriterion("bank_card_date not between", value1, value2, "bankCardDate");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
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