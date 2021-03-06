package com.food.model;

import java.util.ArrayList;
import java.util.List;

public class ImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImgExample() {
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

        public Criteria andFile_nameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFile_nameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFile_nameEqualTo(String value) {
            addCriterion("file_name =", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameGreaterThan(String value) {
            addCriterion("file_name >", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameLessThan(String value) {
            addCriterion("file_name <", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameLike(String value) {
            addCriterion("file_name like", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameNotLike(String value) {
            addCriterion("file_name not like", value, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameIn(List<String> values) {
            addCriterion("file_name in", values, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "file_name");
            return (Criteria) this;
        }

        public Criteria andFile_nameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "file_name");
            return (Criteria) this;
        }

        public Criteria andFull_urlIsNull() {
            addCriterion("full_url is null");
            return (Criteria) this;
        }

        public Criteria andFull_urlIsNotNull() {
            addCriterion("full_url is not null");
            return (Criteria) this;
        }

        public Criteria andFull_urlEqualTo(String value) {
            addCriterion("full_url =", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlNotEqualTo(String value) {
            addCriterion("full_url <>", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlGreaterThan(String value) {
            addCriterion("full_url >", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlGreaterThanOrEqualTo(String value) {
            addCriterion("full_url >=", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlLessThan(String value) {
            addCriterion("full_url <", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlLessThanOrEqualTo(String value) {
            addCriterion("full_url <=", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlLike(String value) {
            addCriterion("full_url like", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlNotLike(String value) {
            addCriterion("full_url not like", value, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlIn(List<String> values) {
            addCriterion("full_url in", values, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlNotIn(List<String> values) {
            addCriterion("full_url not in", values, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlBetween(String value1, String value2) {
            addCriterion("full_url between", value1, value2, "full_url");
            return (Criteria) this;
        }

        public Criteria andFull_urlNotBetween(String value1, String value2) {
            addCriterion("full_url not between", value1, value2, "full_url");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andThumbnail_widthIsNull() {
            addCriterion("thumbnail_width is null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthIsNotNull() {
            addCriterion("thumbnail_width is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthEqualTo(Float value) {
            addCriterion("thumbnail_width =", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthNotEqualTo(Float value) {
            addCriterion("thumbnail_width <>", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthGreaterThan(Float value) {
            addCriterion("thumbnail_width >", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthGreaterThanOrEqualTo(Float value) {
            addCriterion("thumbnail_width >=", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthLessThan(Float value) {
            addCriterion("thumbnail_width <", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthLessThanOrEqualTo(Float value) {
            addCriterion("thumbnail_width <=", value, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthIn(List<Float> values) {
            addCriterion("thumbnail_width in", values, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthNotIn(List<Float> values) {
            addCriterion("thumbnail_width not in", values, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthBetween(Float value1, Float value2) {
            addCriterion("thumbnail_width between", value1, value2, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_widthNotBetween(Float value1, Float value2) {
            addCriterion("thumbnail_width not between", value1, value2, "thumbnail_width");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightIsNull() {
            addCriterion("thumbnail_height is null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightIsNotNull() {
            addCriterion("thumbnail_height is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightEqualTo(Float value) {
            addCriterion("thumbnail_height =", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightNotEqualTo(Float value) {
            addCriterion("thumbnail_height <>", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightGreaterThan(Float value) {
            addCriterion("thumbnail_height >", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightGreaterThanOrEqualTo(Float value) {
            addCriterion("thumbnail_height >=", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightLessThan(Float value) {
            addCriterion("thumbnail_height <", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightLessThanOrEqualTo(Float value) {
            addCriterion("thumbnail_height <=", value, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightIn(List<Float> values) {
            addCriterion("thumbnail_height in", values, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightNotIn(List<Float> values) {
            addCriterion("thumbnail_height not in", values, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightBetween(Float value1, Float value2) {
            addCriterion("thumbnail_height between", value1, value2, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andThumbnail_heightNotBetween(Float value1, Float value2) {
            addCriterion("thumbnail_height not between", value1, value2, "thumbnail_height");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Float value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Float value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Float value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Float value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Float value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Float value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Float> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Float> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Float value1, Float value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Float value1, Float value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Float value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Float value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Float value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Float value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Float value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Float value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Float> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Float> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Float value1, Float value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Float value1, Float value2) {
            addCriterion("height not between", value1, value2, "height");
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