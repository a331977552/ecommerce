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

        public Criteria andWechat_payment_code_urlIsNull() {
            addCriterion("wechat_payment_code_url is null");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlIsNotNull() {
            addCriterion("wechat_payment_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlEqualTo(String value) {
            addCriterion("wechat_payment_code_url =", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlNotEqualTo(String value) {
            addCriterion("wechat_payment_code_url <>", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlGreaterThan(String value) {
            addCriterion("wechat_payment_code_url >", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_payment_code_url >=", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlLessThan(String value) {
            addCriterion("wechat_payment_code_url <", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlLessThanOrEqualTo(String value) {
            addCriterion("wechat_payment_code_url <=", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlLike(String value) {
            addCriterion("wechat_payment_code_url like", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlNotLike(String value) {
            addCriterion("wechat_payment_code_url not like", value, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlIn(List<String> values) {
            addCriterion("wechat_payment_code_url in", values, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlNotIn(List<String> values) {
            addCriterion("wechat_payment_code_url not in", values, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlBetween(String value1, String value2) {
            addCriterion("wechat_payment_code_url between", value1, value2, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_payment_code_urlNotBetween(String value1, String value2) {
            addCriterion("wechat_payment_code_url not between", value1, value2, "wechat_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlIsNull() {
            addCriterion("wechat_url is null");
            return (Criteria) this;
        }

        public Criteria andWechat_urlIsNotNull() {
            addCriterion("wechat_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechat_urlEqualTo(String value) {
            addCriterion("wechat_url =", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlNotEqualTo(String value) {
            addCriterion("wechat_url <>", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlGreaterThan(String value) {
            addCriterion("wechat_url >", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_url >=", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlLessThan(String value) {
            addCriterion("wechat_url <", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlLessThanOrEqualTo(String value) {
            addCriterion("wechat_url <=", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlLike(String value) {
            addCriterion("wechat_url like", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlNotLike(String value) {
            addCriterion("wechat_url not like", value, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlIn(List<String> values) {
            addCriterion("wechat_url in", values, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlNotIn(List<String> values) {
            addCriterion("wechat_url not in", values, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlBetween(String value1, String value2) {
            addCriterion("wechat_url between", value1, value2, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andWechat_urlNotBetween(String value1, String value2) {
            addCriterion("wechat_url not between", value1, value2, "wechat_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlIsNull() {
            addCriterion("alipay_url is null");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlIsNotNull() {
            addCriterion("alipay_url is not null");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlEqualTo(String value) {
            addCriterion("alipay_url =", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlNotEqualTo(String value) {
            addCriterion("alipay_url <>", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlGreaterThan(String value) {
            addCriterion("alipay_url >", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_url >=", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlLessThan(String value) {
            addCriterion("alipay_url <", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlLessThanOrEqualTo(String value) {
            addCriterion("alipay_url <=", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlLike(String value) {
            addCriterion("alipay_url like", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlNotLike(String value) {
            addCriterion("alipay_url not like", value, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlIn(List<String> values) {
            addCriterion("alipay_url in", values, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlNotIn(List<String> values) {
            addCriterion("alipay_url not in", values, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlBetween(String value1, String value2) {
            addCriterion("alipay_url between", value1, value2, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_urlNotBetween(String value1, String value2) {
            addCriterion("alipay_url not between", value1, value2, "alipay_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlIsNull() {
            addCriterion("alipay_payment_code_url is null");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlIsNotNull() {
            addCriterion("alipay_payment_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlEqualTo(String value) {
            addCriterion("alipay_payment_code_url =", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlNotEqualTo(String value) {
            addCriterion("alipay_payment_code_url <>", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlGreaterThan(String value) {
            addCriterion("alipay_payment_code_url >", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_payment_code_url >=", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlLessThan(String value) {
            addCriterion("alipay_payment_code_url <", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlLessThanOrEqualTo(String value) {
            addCriterion("alipay_payment_code_url <=", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlLike(String value) {
            addCriterion("alipay_payment_code_url like", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlNotLike(String value) {
            addCriterion("alipay_payment_code_url not like", value, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlIn(List<String> values) {
            addCriterion("alipay_payment_code_url in", values, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlNotIn(List<String> values) {
            addCriterion("alipay_payment_code_url not in", values, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlBetween(String value1, String value2) {
            addCriterion("alipay_payment_code_url between", value1, value2, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andAlipay_payment_code_urlNotBetween(String value1, String value2) {
            addCriterion("alipay_payment_code_url not between", value1, value2, "alipay_payment_code_url");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberIsNull() {
            addCriterion("bank_card_number is null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberIsNotNull() {
            addCriterion("bank_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberEqualTo(String value) {
            addCriterion("bank_card_number =", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberNotEqualTo(String value) {
            addCriterion("bank_card_number <>", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberGreaterThan(String value) {
            addCriterion("bank_card_number >", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_number >=", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberLessThan(String value) {
            addCriterion("bank_card_number <", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberLessThanOrEqualTo(String value) {
            addCriterion("bank_card_number <=", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberLike(String value) {
            addCriterion("bank_card_number like", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberNotLike(String value) {
            addCriterion("bank_card_number not like", value, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberIn(List<String> values) {
            addCriterion("bank_card_number in", values, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberNotIn(List<String> values) {
            addCriterion("bank_card_number not in", values, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberBetween(String value1, String value2) {
            addCriterion("bank_card_number between", value1, value2, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_numberNotBetween(String value1, String value2) {
            addCriterion("bank_card_number not between", value1, value2, "bank_card_number");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameIsNull() {
            addCriterion("bank_card_name is null");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameIsNotNull() {
            addCriterion("bank_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameEqualTo(String value) {
            addCriterion("bank_card_name =", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameNotEqualTo(String value) {
            addCriterion("bank_card_name <>", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameGreaterThan(String value) {
            addCriterion("bank_card_name >", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_name >=", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameLessThan(String value) {
            addCriterion("bank_card_name <", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameLessThanOrEqualTo(String value) {
            addCriterion("bank_card_name <=", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameLike(String value) {
            addCriterion("bank_card_name like", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameNotLike(String value) {
            addCriterion("bank_card_name not like", value, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameIn(List<String> values) {
            addCriterion("bank_card_name in", values, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameNotIn(List<String> values) {
            addCriterion("bank_card_name not in", values, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameBetween(String value1, String value2) {
            addCriterion("bank_card_name between", value1, value2, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_nameNotBetween(String value1, String value2) {
            addCriterion("bank_card_name not between", value1, value2, "bank_card_name");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateIsNull() {
            addCriterion("bank_card_date is null");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateIsNotNull() {
            addCriterion("bank_card_date is not null");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateEqualTo(String value) {
            addCriterion("bank_card_date =", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateNotEqualTo(String value) {
            addCriterion("bank_card_date <>", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateGreaterThan(String value) {
            addCriterion("bank_card_date >", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_date >=", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateLessThan(String value) {
            addCriterion("bank_card_date <", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateLessThanOrEqualTo(String value) {
            addCriterion("bank_card_date <=", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateLike(String value) {
            addCriterion("bank_card_date like", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateNotLike(String value) {
            addCriterion("bank_card_date not like", value, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateIn(List<String> values) {
            addCriterion("bank_card_date in", values, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateNotIn(List<String> values) {
            addCriterion("bank_card_date not in", values, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateBetween(String value1, String value2) {
            addCriterion("bank_card_date between", value1, value2, "bank_card_date");
            return (Criteria) this;
        }

        public Criteria andBank_card_dateNotBetween(String value1, String value2) {
            addCriterion("bank_card_date not between", value1, value2, "bank_card_date");
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