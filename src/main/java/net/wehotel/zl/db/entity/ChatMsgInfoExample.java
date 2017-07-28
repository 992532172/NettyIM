package net.wehotel.zl.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMsgInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitSize;

    public ChatMsgInfoExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitSize(Integer limitSize) {
        this.limitSize=limitSize;
    }

    public Integer getLimitSize() {
        return limitSize;
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

        public Criteria andMsgtypeIsNull() {
            addCriterion("msgtype is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("msgtype is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("msgtype =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("msgtype <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("msgtype >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("msgtype >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("msgtype <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("msgtype <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("msgtype like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("msgtype not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("msgtype in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("msgtype not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("msgtype between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("msgtype not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIsNull() {
            addCriterion("speakerid is null");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIsNotNull() {
            addCriterion("speakerid is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakeridEqualTo(String value) {
            addCriterion("speakerid =", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotEqualTo(String value) {
            addCriterion("speakerid <>", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridGreaterThan(String value) {
            addCriterion("speakerid >", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridGreaterThanOrEqualTo(String value) {
            addCriterion("speakerid >=", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridLessThan(String value) {
            addCriterion("speakerid <", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridLessThanOrEqualTo(String value) {
            addCriterion("speakerid <=", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridLike(String value) {
            addCriterion("speakerid like", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotLike(String value) {
            addCriterion("speakerid not like", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIn(List<String> values) {
            addCriterion("speakerid in", values, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotIn(List<String> values) {
            addCriterion("speakerid not in", values, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridBetween(String value1, String value2) {
            addCriterion("speakerid between", value1, value2, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotBetween(String value1, String value2) {
            addCriterion("speakerid not between", value1, value2, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNull() {
            addCriterion("senderid is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderid is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(String value) {
            addCriterion("senderid =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(String value) {
            addCriterion("senderid <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(String value) {
            addCriterion("senderid >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(String value) {
            addCriterion("senderid >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(String value) {
            addCriterion("senderid <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(String value) {
            addCriterion("senderid <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLike(String value) {
            addCriterion("senderid like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotLike(String value) {
            addCriterion("senderid not like", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<String> values) {
            addCriterion("senderid in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<String> values) {
            addCriterion("senderid not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(String value1, String value2) {
            addCriterion("senderid between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(String value1, String value2) {
            addCriterion("senderid not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("receiverid is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("receiverid is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(String value) {
            addCriterion("receiverid =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(String value) {
            addCriterion("receiverid <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(String value) {
            addCriterion("receiverid >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(String value) {
            addCriterion("receiverid >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(String value) {
            addCriterion("receiverid <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(String value) {
            addCriterion("receiverid <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLike(String value) {
            addCriterion("receiverid like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotLike(String value) {
            addCriterion("receiverid not like", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<String> values) {
            addCriterion("receiverid in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<String> values) {
            addCriterion("receiverid not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(String value1, String value2) {
            addCriterion("receiverid between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(String value1, String value2) {
            addCriterion("receiverid not between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
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