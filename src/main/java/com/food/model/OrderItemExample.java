package com.food.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
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

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andProduct_descIsNull() {
            addCriterion("product_desc is null");
            return (Criteria) this;
        }

        public Criteria andProduct_descIsNotNull() {
            addCriterion("product_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_descEqualTo(String value) {
            addCriterion("product_desc =", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descNotEqualTo(String value) {
            addCriterion("product_desc <>", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descGreaterThan(String value) {
            addCriterion("product_desc >", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descGreaterThanOrEqualTo(String value) {
            addCriterion("product_desc >=", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descLessThan(String value) {
            addCriterion("product_desc <", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descLessThanOrEqualTo(String value) {
            addCriterion("product_desc <=", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descLike(String value) {
            addCriterion("product_desc like", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descNotLike(String value) {
            addCriterion("product_desc not like", value, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descIn(List<String> values) {
            addCriterion("product_desc in", values, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descNotIn(List<String> values) {
            addCriterion("product_desc not in", values, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descBetween(String value1, String value2) {
            addCriterion("product_desc between", value1, value2, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_descNotBetween(String value1, String value2) {
            addCriterion("product_desc not between", value1, value2, "product_desc");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("product_name =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("product_name >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("product_name <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("product_name like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("product_name not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("product_name in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andSub_totalIsNull() {
            addCriterion("sub_total is null");
            return (Criteria) this;
        }

        public Criteria andSub_totalIsNotNull() {
            addCriterion("sub_total is not null");
            return (Criteria) this;
        }

        public Criteria andSub_totalEqualTo(BigDecimal value) {
            addCriterion("sub_total =", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalNotEqualTo(BigDecimal value) {
            addCriterion("sub_total <>", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalGreaterThan(BigDecimal value) {
            addCriterion("sub_total >", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sub_total >=", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalLessThan(BigDecimal value) {
            addCriterion("sub_total <", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sub_total <=", value, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalIn(List<BigDecimal> values) {
            addCriterion("sub_total in", values, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalNotIn(List<BigDecimal> values) {
            addCriterion("sub_total not in", values, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sub_total between", value1, value2, "sub_total");
            return (Criteria) this;
        }

        public Criteria andSub_totalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sub_total not between", value1, value2, "sub_total");
            return (Criteria) this;
        }

        public Criteria andUnipriceIsNull() {
            addCriterion("uniprice is null");
            return (Criteria) this;
        }

        public Criteria andUnipriceIsNotNull() {
            addCriterion("uniprice is not null");
            return (Criteria) this;
        }

        public Criteria andUnipriceEqualTo(BigDecimal value) {
            addCriterion("uniprice =", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceNotEqualTo(BigDecimal value) {
            addCriterion("uniprice <>", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceGreaterThan(BigDecimal value) {
            addCriterion("uniprice >", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("uniprice >=", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceLessThan(BigDecimal value) {
            addCriterion("uniprice <", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("uniprice <=", value, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceIn(List<BigDecimal> values) {
            addCriterion("uniprice in", values, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceNotIn(List<BigDecimal> values) {
            addCriterion("uniprice not in", values, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("uniprice between", value1, value2, "uniprice");
            return (Criteria) this;
        }

        public Criteria andUnipriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("uniprice not between", value1, value2, "uniprice");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlIsNull() {
            addCriterion("thumbnail_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlIsNotNull() {
            addCriterion("thumbnail_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlEqualTo(String value) {
            addCriterion("thumbnail_url =", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlNotEqualTo(String value) {
            addCriterion("thumbnail_url <>", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlGreaterThan(String value) {
            addCriterion("thumbnail_url >", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail_url >=", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlLessThan(String value) {
            addCriterion("thumbnail_url <", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlLessThanOrEqualTo(String value) {
            addCriterion("thumbnail_url <=", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlLike(String value) {
            addCriterion("thumbnail_url like", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlNotLike(String value) {
            addCriterion("thumbnail_url not like", value, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlIn(List<String> values) {
            addCriterion("thumbnail_url in", values, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlNotIn(List<String> values) {
            addCriterion("thumbnail_url not in", values, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlBetween(String value1, String value2) {
            addCriterion("thumbnail_url between", value1, value2, "thumbnail_url");
            return (Criteria) this;
        }

        public Criteria andThumbnail_urlNotBetween(String value1, String value2) {
            addCriterion("thumbnail_url not between", value1, value2, "thumbnail_url");
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