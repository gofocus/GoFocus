package cn.itcast.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuctionExample() {
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

        public Criteria andGearIsNull() {
            addCriterion("gear is null");
            return (Criteria) this;
        }

        public Criteria andGearIsNotNull() {
            addCriterion("gear is not null");
            return (Criteria) this;
        }

        public Criteria andGearEqualTo(String value) {
            addCriterion("gear =", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotEqualTo(String value) {
            addCriterion("gear <>", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThan(String value) {
            addCriterion("gear >", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThanOrEqualTo(String value) {
            addCriterion("gear >=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThan(String value) {
            addCriterion("gear <", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThanOrEqualTo(String value) {
            addCriterion("gear <=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLike(String value) {
            addCriterion("gear like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotLike(String value) {
            addCriterion("gear not like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearIn(List<String> values) {
            addCriterion("gear in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotIn(List<String> values) {
            addCriterion("gear not in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearBetween(String value1, String value2) {
            addCriterion("gear between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotBetween(String value1, String value2) {
            addCriterion("gear not between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andAuctioneerIsNull() {
            addCriterion("auctioneer is null");
            return (Criteria) this;
        }

        public Criteria andAuctioneerIsNotNull() {
            addCriterion("auctioneer is not null");
            return (Criteria) this;
        }

        public Criteria andAuctioneerEqualTo(String value) {
            addCriterion("auctioneer =", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerNotEqualTo(String value) {
            addCriterion("auctioneer <>", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerGreaterThan(String value) {
            addCriterion("auctioneer >", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerGreaterThanOrEqualTo(String value) {
            addCriterion("auctioneer >=", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerLessThan(String value) {
            addCriterion("auctioneer <", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerLessThanOrEqualTo(String value) {
            addCriterion("auctioneer <=", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerLike(String value) {
            addCriterion("auctioneer like", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerNotLike(String value) {
            addCriterion("auctioneer not like", value, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerIn(List<String> values) {
            addCriterion("auctioneer in", values, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerNotIn(List<String> values) {
            addCriterion("auctioneer not in", values, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerBetween(String value1, String value2) {
            addCriterion("auctioneer between", value1, value2, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andAuctioneerNotBetween(String value1, String value2) {
            addCriterion("auctioneer not between", value1, value2, "auctioneer");
            return (Criteria) this;
        }

        public Criteria andHighestBidIsNull() {
            addCriterion("highest_bid is null");
            return (Criteria) this;
        }

        public Criteria andHighestBidIsNotNull() {
            addCriterion("highest_bid is not null");
            return (Criteria) this;
        }

        public Criteria andHighestBidEqualTo(Integer value) {
            addCriterion("highest_bid =", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotEqualTo(Integer value) {
            addCriterion("highest_bid <>", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidGreaterThan(Integer value) {
            addCriterion("highest_bid >", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("highest_bid >=", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidLessThan(Integer value) {
            addCriterion("highest_bid <", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidLessThanOrEqualTo(Integer value) {
            addCriterion("highest_bid <=", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidIn(List<Integer> values) {
            addCriterion("highest_bid in", values, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotIn(List<Integer> values) {
            addCriterion("highest_bid not in", values, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidBetween(Integer value1, Integer value2) {
            addCriterion("highest_bid between", value1, value2, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotBetween(Integer value1, Integer value2) {
            addCriterion("highest_bid not between", value1, value2, "highestBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidIsNull() {
            addCriterion("second_bid is null");
            return (Criteria) this;
        }

        public Criteria andSecondBidIsNotNull() {
            addCriterion("second_bid is not null");
            return (Criteria) this;
        }

        public Criteria andSecondBidEqualTo(Integer value) {
            addCriterion("second_bid =", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidNotEqualTo(Integer value) {
            addCriterion("second_bid <>", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidGreaterThan(Integer value) {
            addCriterion("second_bid >", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_bid >=", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidLessThan(Integer value) {
            addCriterion("second_bid <", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidLessThanOrEqualTo(Integer value) {
            addCriterion("second_bid <=", value, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidIn(List<Integer> values) {
            addCriterion("second_bid in", values, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidNotIn(List<Integer> values) {
            addCriterion("second_bid not in", values, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidBetween(Integer value1, Integer value2) {
            addCriterion("second_bid between", value1, value2, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSecondBidNotBetween(Integer value1, Integer value2) {
            addCriterion("second_bid not between", value1, value2, "secondBid");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderIsNull() {
            addCriterion("successful_bidder is null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderIsNotNull() {
            addCriterion("successful_bidder is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderEqualTo(String value) {
            addCriterion("successful_bidder =", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderNotEqualTo(String value) {
            addCriterion("successful_bidder <>", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderGreaterThan(String value) {
            addCriterion("successful_bidder >", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderGreaterThanOrEqualTo(String value) {
            addCriterion("successful_bidder >=", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderLessThan(String value) {
            addCriterion("successful_bidder <", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderLessThanOrEqualTo(String value) {
            addCriterion("successful_bidder <=", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderLike(String value) {
            addCriterion("successful_bidder like", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderNotLike(String value) {
            addCriterion("successful_bidder not like", value, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderIn(List<String> values) {
            addCriterion("successful_bidder in", values, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderNotIn(List<String> values) {
            addCriterion("successful_bidder not in", values, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderBetween(String value1, String value2) {
            addCriterion("successful_bidder between", value1, value2, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBidderNotBetween(String value1, String value2) {
            addCriterion("successful_bidder not between", value1, value2, "successfulBidder");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeIsNull() {
            addCriterion("auction_time is null");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeIsNotNull() {
            addCriterion("auction_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeEqualTo(Date value) {
            addCriterion("auction_time =", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeNotEqualTo(Date value) {
            addCriterion("auction_time <>", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeGreaterThan(Date value) {
            addCriterion("auction_time >", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auction_time >=", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeLessThan(Date value) {
            addCriterion("auction_time <", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeLessThanOrEqualTo(Date value) {
            addCriterion("auction_time <=", value, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeIn(List<Date> values) {
            addCriterion("auction_time in", values, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeNotIn(List<Date> values) {
            addCriterion("auction_time not in", values, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeBetween(Date value1, Date value2) {
            addCriterion("auction_time between", value1, value2, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andAuctionTimeNotBetween(Date value1, Date value2) {
            addCriterion("auction_time not between", value1, value2, "auctionTime");
            return (Criteria) this;
        }

        public Criteria andGuildIdIsNull() {
            addCriterion("guild_id is null");
            return (Criteria) this;
        }

        public Criteria andGuildIdIsNotNull() {
            addCriterion("guild_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuildIdEqualTo(Integer value) {
            addCriterion("guild_id =", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdNotEqualTo(Integer value) {
            addCriterion("guild_id <>", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdGreaterThan(Integer value) {
            addCriterion("guild_id >", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guild_id >=", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdLessThan(Integer value) {
            addCriterion("guild_id <", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdLessThanOrEqualTo(Integer value) {
            addCriterion("guild_id <=", value, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdIn(List<Integer> values) {
            addCriterion("guild_id in", values, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdNotIn(List<Integer> values) {
            addCriterion("guild_id not in", values, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdBetween(Integer value1, Integer value2) {
            addCriterion("guild_id between", value1, value2, "guildId");
            return (Criteria) this;
        }

        public Criteria andGuildIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guild_id not between", value1, value2, "guildId");
            return (Criteria) this;
        }

        public Criteria andBottomPointIsNull() {
            addCriterion("bottom_point is null");
            return (Criteria) this;
        }

        public Criteria andBottomPointIsNotNull() {
            addCriterion("bottom_point is not null");
            return (Criteria) this;
        }

        public Criteria andBottomPointEqualTo(String value) {
            addCriterion("bottom_point =", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointNotEqualTo(String value) {
            addCriterion("bottom_point <>", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointGreaterThan(String value) {
            addCriterion("bottom_point >", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointGreaterThanOrEqualTo(String value) {
            addCriterion("bottom_point >=", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointLessThan(String value) {
            addCriterion("bottom_point <", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointLessThanOrEqualTo(String value) {
            addCriterion("bottom_point <=", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointLike(String value) {
            addCriterion("bottom_point like", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointNotLike(String value) {
            addCriterion("bottom_point not like", value, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointIn(List<String> values) {
            addCriterion("bottom_point in", values, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointNotIn(List<String> values) {
            addCriterion("bottom_point not in", values, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointBetween(String value1, String value2) {
            addCriterion("bottom_point between", value1, value2, "bottomPoint");
            return (Criteria) this;
        }

        public Criteria andBottomPointNotBetween(String value1, String value2) {
            addCriterion("bottom_point not between", value1, value2, "bottomPoint");
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