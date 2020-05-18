package com.food.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andCreate_dateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIn(List<Date> values) {
            addCriterion("create_date in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(String value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(String value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(String value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(String value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(String value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(String value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLike(String value) {
            addCriterion("hot like", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotLike(String value) {
            addCriterion("hot not like", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<String> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<String> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(String value1, String value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(String value1, String value2) {
            addCriterion("hot not between", value1, value2, "hot");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceprev1IsNull() {
            addCriterion("priceprev1 is null");
            return (Criteria) this;
        }

        public Criteria andPriceprev1IsNotNull() {
            addCriterion("priceprev1 is not null");
            return (Criteria) this;
        }

        public Criteria andPriceprev1EqualTo(BigDecimal value) {
            addCriterion("priceprev1 =", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1NotEqualTo(BigDecimal value) {
            addCriterion("priceprev1 <>", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1GreaterThan(BigDecimal value) {
            addCriterion("priceprev1 >", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("priceprev1 >=", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1LessThan(BigDecimal value) {
            addCriterion("priceprev1 <", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("priceprev1 <=", value, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1In(List<BigDecimal> values) {
            addCriterion("priceprev1 in", values, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1NotIn(List<BigDecimal> values) {
            addCriterion("priceprev1 not in", values, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("priceprev1 between", value1, value2, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("priceprev1 not between", value1, value2, "priceprev1");
            return (Criteria) this;
        }

        public Criteria andPriceprev2IsNull() {
            addCriterion("priceprev2 is null");
            return (Criteria) this;
        }

        public Criteria andPriceprev2IsNotNull() {
            addCriterion("priceprev2 is not null");
            return (Criteria) this;
        }

        public Criteria andPriceprev2EqualTo(BigDecimal value) {
            addCriterion("priceprev2 =", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2NotEqualTo(BigDecimal value) {
            addCriterion("priceprev2 <>", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2GreaterThan(BigDecimal value) {
            addCriterion("priceprev2 >", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("priceprev2 >=", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2LessThan(BigDecimal value) {
            addCriterion("priceprev2 <", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("priceprev2 <=", value, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2In(List<BigDecimal> values) {
            addCriterion("priceprev2 in", values, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2NotIn(List<BigDecimal> values) {
            addCriterion("priceprev2 not in", values, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("priceprev2 between", value1, value2, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andPriceprev2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("priceprev2 not between", value1, value2, "priceprev2");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingIsNull() {
            addCriterion("quantity_remaining is null");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingIsNotNull() {
            addCriterion("quantity_remaining is not null");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingEqualTo(Integer value) {
            addCriterion("quantity_remaining =", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingNotEqualTo(Integer value) {
            addCriterion("quantity_remaining <>", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingGreaterThan(Integer value) {
            addCriterion("quantity_remaining >", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity_remaining >=", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingLessThan(Integer value) {
            addCriterion("quantity_remaining <", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingLessThanOrEqualTo(Integer value) {
            addCriterion("quantity_remaining <=", value, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingIn(List<Integer> values) {
            addCriterion("quantity_remaining in", values, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingNotIn(List<Integer> values) {
            addCriterion("quantity_remaining not in", values, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingBetween(Integer value1, Integer value2) {
            addCriterion("quantity_remaining between", value1, value2, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andQuantity_remainingNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity_remaining not between", value1, value2, "quantity_remaining");
            return (Criteria) this;
        }

        public Criteria andSales_volumeIsNull() {
            addCriterion("sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andSales_volumeIsNotNull() {
            addCriterion("sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSales_volumeEqualTo(Integer value) {
            addCriterion("sales_volume =", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeNotEqualTo(Integer value) {
            addCriterion("sales_volume <>", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeGreaterThan(Integer value) {
            addCriterion("sales_volume >", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_volume >=", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeLessThan(Integer value) {
            addCriterion("sales_volume <", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeLessThanOrEqualTo(Integer value) {
            addCriterion("sales_volume <=", value, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeIn(List<Integer> values) {
            addCriterion("sales_volume in", values, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeNotIn(List<Integer> values) {
            addCriterion("sales_volume not in", values, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeBetween(Integer value1, Integer value2) {
            addCriterion("sales_volume between", value1, value2, "sales_volume");
            return (Criteria) this;
        }

        public Criteria andSales_volumeNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_volume not between", value1, value2, "sales_volume");
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

        public Criteria andUpdate_dateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateEqualTo(Date value) {
            addCriterion("update_date =", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateGreaterThan(Date value) {
            addCriterion("update_date >", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateLessThan(Date value) {
            addCriterion("update_date <", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateIn(List<Date> values) {
            addCriterion("update_date in", values, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "update_date");
            return (Criteria) this;
        }

        public Criteria andUpdate_dateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "update_date");
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