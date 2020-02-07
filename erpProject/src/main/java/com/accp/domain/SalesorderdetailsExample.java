package com.accp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalesorderdetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesorderdetailsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLinenoIsNull() {
            addCriterion("LineNo is null");
            return (Criteria) this;
        }

        public Criteria andLinenoIsNotNull() {
            addCriterion("LineNo is not null");
            return (Criteria) this;
        }

        public Criteria andLinenoEqualTo(Integer value) {
            addCriterion("LineNo =", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoNotEqualTo(Integer value) {
            addCriterion("LineNo <>", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoGreaterThan(Integer value) {
            addCriterion("LineNo >", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("LineNo >=", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoLessThan(Integer value) {
            addCriterion("LineNo <", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoLessThanOrEqualTo(Integer value) {
            addCriterion("LineNo <=", value, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoIn(List<Integer> values) {
            addCriterion("LineNo in", values, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoNotIn(List<Integer> values) {
            addCriterion("LineNo not in", values, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoBetween(Integer value1, Integer value2) {
            addCriterion("LineNo between", value1, value2, "lineno");
            return (Criteria) this;
        }

        public Criteria andLinenoNotBetween(Integer value1, Integer value2) {
            addCriterion("LineNo not between", value1, value2, "lineno");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNull() {
            addCriterion("BillNo is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("BillNo is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("BillNo =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("BillNo <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("BillNo >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("BillNo >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("BillNo <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("BillNo <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("BillNo like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("BillNo not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("BillNo in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("BillNo not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("BillNo between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("BillNo not between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andProdidIsNull() {
            addCriterion("ProdID is null");
            return (Criteria) this;
        }

        public Criteria andProdidIsNotNull() {
            addCriterion("ProdID is not null");
            return (Criteria) this;
        }

        public Criteria andProdidEqualTo(String value) {
            addCriterion("ProdID =", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotEqualTo(String value) {
            addCriterion("ProdID <>", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThan(String value) {
            addCriterion("ProdID >", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThanOrEqualTo(String value) {
            addCriterion("ProdID >=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThan(String value) {
            addCriterion("ProdID <", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThanOrEqualTo(String value) {
            addCriterion("ProdID <=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLike(String value) {
            addCriterion("ProdID like", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotLike(String value) {
            addCriterion("ProdID not like", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidIn(List<String> values) {
            addCriterion("ProdID in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotIn(List<String> values) {
            addCriterion("ProdID not in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidBetween(String value1, String value2) {
            addCriterion("ProdID between", value1, value2, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotBetween(String value1, String value2) {
            addCriterion("ProdID not between", value1, value2, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdnameIsNull() {
            addCriterion("ProdName is null");
            return (Criteria) this;
        }

        public Criteria andProdnameIsNotNull() {
            addCriterion("ProdName is not null");
            return (Criteria) this;
        }

        public Criteria andProdnameEqualTo(String value) {
            addCriterion("ProdName =", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotEqualTo(String value) {
            addCriterion("ProdName <>", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThan(String value) {
            addCriterion("ProdName >", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProdName >=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThan(String value) {
            addCriterion("ProdName <", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThanOrEqualTo(String value) {
            addCriterion("ProdName <=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLike(String value) {
            addCriterion("ProdName like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotLike(String value) {
            addCriterion("ProdName not like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameIn(List<String> values) {
            addCriterion("ProdName in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotIn(List<String> values) {
            addCriterion("ProdName not in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameBetween(String value1, String value2) {
            addCriterion("ProdName between", value1, value2, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotBetween(String value1, String value2) {
            addCriterion("ProdName not between", value1, value2, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdsizeIsNull() {
            addCriterion("ProdSize is null");
            return (Criteria) this;
        }

        public Criteria andProdsizeIsNotNull() {
            addCriterion("ProdSize is not null");
            return (Criteria) this;
        }

        public Criteria andProdsizeEqualTo(String value) {
            addCriterion("ProdSize =", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeNotEqualTo(String value) {
            addCriterion("ProdSize <>", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeGreaterThan(String value) {
            addCriterion("ProdSize >", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeGreaterThanOrEqualTo(String value) {
            addCriterion("ProdSize >=", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeLessThan(String value) {
            addCriterion("ProdSize <", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeLessThanOrEqualTo(String value) {
            addCriterion("ProdSize <=", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeLike(String value) {
            addCriterion("ProdSize like", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeNotLike(String value) {
            addCriterion("ProdSize not like", value, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeIn(List<String> values) {
            addCriterion("ProdSize in", values, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeNotIn(List<String> values) {
            addCriterion("ProdSize not in", values, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeBetween(String value1, String value2) {
            addCriterion("ProdSize between", value1, value2, "prodsize");
            return (Criteria) this;
        }

        public Criteria andProdsizeNotBetween(String value1, String value2) {
            addCriterion("ProdSize not between", value1, value2, "prodsize");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNull() {
            addCriterion("UnitName is null");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNotNull() {
            addCriterion("UnitName is not null");
            return (Criteria) this;
        }

        public Criteria andUnitnameEqualTo(String value) {
            addCriterion("UnitName =", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotEqualTo(String value) {
            addCriterion("UnitName <>", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThan(String value) {
            addCriterion("UnitName >", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThanOrEqualTo(String value) {
            addCriterion("UnitName >=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThan(String value) {
            addCriterion("UnitName <", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThanOrEqualTo(String value) {
            addCriterion("UnitName <=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLike(String value) {
            addCriterion("UnitName like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotLike(String value) {
            addCriterion("UnitName not like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameIn(List<String> values) {
            addCriterion("UnitName in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotIn(List<String> values) {
            addCriterion("UnitName not in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameBetween(String value1, String value2) {
            addCriterion("UnitName between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotBetween(String value1, String value2) {
            addCriterion("UnitName not between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andSquantityIsNull() {
            addCriterion("sQuantity is null");
            return (Criteria) this;
        }

        public Criteria andSquantityIsNotNull() {
            addCriterion("sQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andSquantityEqualTo(Integer value) {
            addCriterion("sQuantity =", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityNotEqualTo(Integer value) {
            addCriterion("sQuantity <>", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityGreaterThan(Integer value) {
            addCriterion("sQuantity >", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sQuantity >=", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityLessThan(Integer value) {
            addCriterion("sQuantity <", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityLessThanOrEqualTo(Integer value) {
            addCriterion("sQuantity <=", value, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityIn(List<Integer> values) {
            addCriterion("sQuantity in", values, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityNotIn(List<Integer> values) {
            addCriterion("sQuantity not in", values, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityBetween(Integer value1, Integer value2) {
            addCriterion("sQuantity between", value1, value2, "squantity");
            return (Criteria) this;
        }

        public Criteria andSquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("sQuantity not between", value1, value2, "squantity");
            return (Criteria) this;
        }

        public Criteria andOldpriceIsNull() {
            addCriterion("OldPrice is null");
            return (Criteria) this;
        }

        public Criteria andOldpriceIsNotNull() {
            addCriterion("OldPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOldpriceEqualTo(Double value) {
            addCriterion("OldPrice =", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotEqualTo(Double value) {
            addCriterion("OldPrice <>", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceGreaterThan(Double value) {
            addCriterion("OldPrice >", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("OldPrice >=", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceLessThan(Double value) {
            addCriterion("OldPrice <", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceLessThanOrEqualTo(Double value) {
            addCriterion("OldPrice <=", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceIn(List<Double> values) {
            addCriterion("OldPrice in", values, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotIn(List<Double> values) {
            addCriterion("OldPrice not in", values, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceBetween(Double value1, Double value2) {
            addCriterion("OldPrice between", value1, value2, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotBetween(Double value1, Double value2) {
            addCriterion("OldPrice not between", value1, value2, "oldprice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("Discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("Discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("Discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("Discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("Discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("Discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("Discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("Discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("Discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("Discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("Discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("Discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNull() {
            addCriterion("sPrice is null");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNotNull() {
            addCriterion("sPrice is not null");
            return (Criteria) this;
        }

        public Criteria andSpriceEqualTo(Double value) {
            addCriterion("sPrice =", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotEqualTo(Double value) {
            addCriterion("sPrice <>", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThan(Double value) {
            addCriterion("sPrice >", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("sPrice >=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThan(Double value) {
            addCriterion("sPrice <", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThanOrEqualTo(Double value) {
            addCriterion("sPrice <=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceIn(List<Double> values) {
            addCriterion("sPrice in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotIn(List<Double> values) {
            addCriterion("sPrice not in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceBetween(Double value1, Double value2) {
            addCriterion("sPrice between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotBetween(Double value1, Double value2) {
            addCriterion("sPrice not between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("Amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("Amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("Amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("Amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("Amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("Amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("Amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("Amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("Amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("Amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("Amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("Amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNull() {
            addCriterion("TaxRate is null");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNotNull() {
            addCriterion("TaxRate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrateEqualTo(Double value) {
            addCriterion("TaxRate =", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotEqualTo(Double value) {
            addCriterion("TaxRate <>", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThan(Double value) {
            addCriterion("TaxRate >", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThanOrEqualTo(Double value) {
            addCriterion("TaxRate >=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThan(Double value) {
            addCriterion("TaxRate <", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThanOrEqualTo(Double value) {
            addCriterion("TaxRate <=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateIn(List<Double> values) {
            addCriterion("TaxRate in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotIn(List<Double> values) {
            addCriterion("TaxRate not in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateBetween(Double value1, Double value2) {
            addCriterion("TaxRate between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotBetween(Double value1, Double value2) {
            addCriterion("TaxRate not between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxamtIsNull() {
            addCriterion("TaxAmt is null");
            return (Criteria) this;
        }

        public Criteria andTaxamtIsNotNull() {
            addCriterion("TaxAmt is not null");
            return (Criteria) this;
        }

        public Criteria andTaxamtEqualTo(Double value) {
            addCriterion("TaxAmt =", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtNotEqualTo(Double value) {
            addCriterion("TaxAmt <>", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtGreaterThan(Double value) {
            addCriterion("TaxAmt >", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtGreaterThanOrEqualTo(Double value) {
            addCriterion("TaxAmt >=", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtLessThan(Double value) {
            addCriterion("TaxAmt <", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtLessThanOrEqualTo(Double value) {
            addCriterion("TaxAmt <=", value, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtIn(List<Double> values) {
            addCriterion("TaxAmt in", values, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtNotIn(List<Double> values) {
            addCriterion("TaxAmt not in", values, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtBetween(Double value1, Double value2) {
            addCriterion("TaxAmt between", value1, value2, "taxamt");
            return (Criteria) this;
        }

        public Criteria andTaxamtNotBetween(Double value1, Double value2) {
            addCriterion("TaxAmt not between", value1, value2, "taxamt");
            return (Criteria) this;
        }

        public Criteria andVftotalIsNull() {
            addCriterion("VFTotal is null");
            return (Criteria) this;
        }

        public Criteria andVftotalIsNotNull() {
            addCriterion("VFTotal is not null");
            return (Criteria) this;
        }

        public Criteria andVftotalEqualTo(Double value) {
            addCriterion("VFTotal =", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalNotEqualTo(Double value) {
            addCriterion("VFTotal <>", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalGreaterThan(Double value) {
            addCriterion("VFTotal >", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalGreaterThanOrEqualTo(Double value) {
            addCriterion("VFTotal >=", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalLessThan(Double value) {
            addCriterion("VFTotal <", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalLessThanOrEqualTo(Double value) {
            addCriterion("VFTotal <=", value, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalIn(List<Double> values) {
            addCriterion("VFTotal in", values, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalNotIn(List<Double> values) {
            addCriterion("VFTotal not in", values, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalBetween(Double value1, Double value2) {
            addCriterion("VFTotal between", value1, value2, "vftotal");
            return (Criteria) this;
        }

        public Criteria andVftotalNotBetween(Double value1, Double value2) {
            addCriterion("VFTotal not between", value1, value2, "vftotal");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityIsNull() {
            addCriterion("HasThsQuantity is null");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityIsNotNull() {
            addCriterion("HasThsQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityEqualTo(Integer value) {
            addCriterion("HasThsQuantity =", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityNotEqualTo(Integer value) {
            addCriterion("HasThsQuantity <>", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityGreaterThan(Integer value) {
            addCriterion("HasThsQuantity >", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("HasThsQuantity >=", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityLessThan(Integer value) {
            addCriterion("HasThsQuantity <", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityLessThanOrEqualTo(Integer value) {
            addCriterion("HasThsQuantity <=", value, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityIn(List<Integer> values) {
            addCriterion("HasThsQuantity in", values, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityNotIn(List<Integer> values) {
            addCriterion("HasThsQuantity not in", values, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityBetween(Integer value1, Integer value2) {
            addCriterion("HasThsQuantity between", value1, value2, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andHasthsquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("HasThsQuantity not between", value1, value2, "hasthsquantity");
            return (Criteria) this;
        }

        public Criteria andPreindateIsNull() {
            addCriterion("PreInDate is null");
            return (Criteria) this;
        }

        public Criteria andPreindateIsNotNull() {
            addCriterion("PreInDate is not null");
            return (Criteria) this;
        }

        public Criteria andPreindateEqualTo(Date value) {
            addCriterionForJDBCDate("PreInDate =", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PreInDate <>", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateGreaterThan(Date value) {
            addCriterionForJDBCDate("PreInDate >", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PreInDate >=", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateLessThan(Date value) {
            addCriterionForJDBCDate("PreInDate <", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PreInDate <=", value, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateIn(List<Date> values) {
            addCriterionForJDBCDate("PreInDate in", values, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PreInDate not in", values, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PreInDate between", value1, value2, "preindate");
            return (Criteria) this;
        }

        public Criteria andPreindateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PreInDate not between", value1, value2, "preindate");
            return (Criteria) this;
        }

        public Criteria andQtyremainIsNull() {
            addCriterion("QtyRemain is null");
            return (Criteria) this;
        }

        public Criteria andQtyremainIsNotNull() {
            addCriterion("QtyRemain is not null");
            return (Criteria) this;
        }

        public Criteria andQtyremainEqualTo(Integer value) {
            addCriterion("QtyRemain =", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainNotEqualTo(Integer value) {
            addCriterion("QtyRemain <>", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainGreaterThan(Integer value) {
            addCriterion("QtyRemain >", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainGreaterThanOrEqualTo(Integer value) {
            addCriterion("QtyRemain >=", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainLessThan(Integer value) {
            addCriterion("QtyRemain <", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainLessThanOrEqualTo(Integer value) {
            addCriterion("QtyRemain <=", value, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainIn(List<Integer> values) {
            addCriterion("QtyRemain in", values, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainNotIn(List<Integer> values) {
            addCriterion("QtyRemain not in", values, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainBetween(Integer value1, Integer value2) {
            addCriterion("QtyRemain between", value1, value2, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andQtyremainNotBetween(Integer value1, Integer value2) {
            addCriterion("QtyRemain not between", value1, value2, "qtyremain");
            return (Criteria) this;
        }

        public Criteria andIsgiftIsNull() {
            addCriterion("IsGift is null");
            return (Criteria) this;
        }

        public Criteria andIsgiftIsNotNull() {
            addCriterion("IsGift is not null");
            return (Criteria) this;
        }

        public Criteria andIsgiftEqualTo(Integer value) {
            addCriterion("IsGift =", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftNotEqualTo(Integer value) {
            addCriterion("IsGift <>", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftGreaterThan(Integer value) {
            addCriterion("IsGift >", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsGift >=", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftLessThan(Integer value) {
            addCriterion("IsGift <", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftLessThanOrEqualTo(Integer value) {
            addCriterion("IsGift <=", value, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftIn(List<Integer> values) {
            addCriterion("IsGift in", values, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftNotIn(List<Integer> values) {
            addCriterion("IsGift not in", values, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftBetween(Integer value1, Integer value2) {
            addCriterion("IsGift between", value1, value2, "isgift");
            return (Criteria) this;
        }

        public Criteria andIsgiftNotBetween(Integer value1, Integer value2) {
            addCriterion("IsGift not between", value1, value2, "isgift");
            return (Criteria) this;
        }

        public Criteria andTrantypeIsNull() {
            addCriterion("TranType is null");
            return (Criteria) this;
        }

        public Criteria andTrantypeIsNotNull() {
            addCriterion("TranType is not null");
            return (Criteria) this;
        }

        public Criteria andTrantypeEqualTo(String value) {
            addCriterion("TranType =", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeNotEqualTo(String value) {
            addCriterion("TranType <>", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeGreaterThan(String value) {
            addCriterion("TranType >", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeGreaterThanOrEqualTo(String value) {
            addCriterion("TranType >=", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeLessThan(String value) {
            addCriterion("TranType <", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeLessThanOrEqualTo(String value) {
            addCriterion("TranType <=", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeLike(String value) {
            addCriterion("TranType like", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeNotLike(String value) {
            addCriterion("TranType not like", value, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeIn(List<String> values) {
            addCriterion("TranType in", values, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeNotIn(List<String> values) {
            addCriterion("TranType not in", values, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeBetween(String value1, String value2) {
            addCriterion("TranType between", value1, value2, "trantype");
            return (Criteria) this;
        }

        public Criteria andTrantypeNotBetween(String value1, String value2) {
            addCriterion("TranType not between", value1, value2, "trantype");
            return (Criteria) this;
        }

        public Criteria andFromnoIsNull() {
            addCriterion("FromNo is null");
            return (Criteria) this;
        }

        public Criteria andFromnoIsNotNull() {
            addCriterion("FromNo is not null");
            return (Criteria) this;
        }

        public Criteria andFromnoEqualTo(String value) {
            addCriterion("FromNo =", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoNotEqualTo(String value) {
            addCriterion("FromNo <>", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoGreaterThan(String value) {
            addCriterion("FromNo >", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoGreaterThanOrEqualTo(String value) {
            addCriterion("FromNo >=", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoLessThan(String value) {
            addCriterion("FromNo <", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoLessThanOrEqualTo(String value) {
            addCriterion("FromNo <=", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoLike(String value) {
            addCriterion("FromNo like", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoNotLike(String value) {
            addCriterion("FromNo not like", value, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoIn(List<String> values) {
            addCriterion("FromNo in", values, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoNotIn(List<String> values) {
            addCriterion("FromNo not in", values, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoBetween(String value1, String value2) {
            addCriterion("FromNo between", value1, value2, "fromno");
            return (Criteria) this;
        }

        public Criteria andFromnoNotBetween(String value1, String value2) {
            addCriterion("FromNo not between", value1, value2, "fromno");
            return (Criteria) this;
        }

        public Criteria andClientsIsNull() {
            addCriterion("Clients is null");
            return (Criteria) this;
        }

        public Criteria andClientsIsNotNull() {
            addCriterion("Clients is not null");
            return (Criteria) this;
        }

        public Criteria andClientsEqualTo(String value) {
            addCriterion("Clients =", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsNotEqualTo(String value) {
            addCriterion("Clients <>", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsGreaterThan(String value) {
            addCriterion("Clients >", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsGreaterThanOrEqualTo(String value) {
            addCriterion("Clients >=", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsLessThan(String value) {
            addCriterion("Clients <", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsLessThanOrEqualTo(String value) {
            addCriterion("Clients <=", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsLike(String value) {
            addCriterion("Clients like", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsNotLike(String value) {
            addCriterion("Clients not like", value, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsIn(List<String> values) {
            addCriterion("Clients in", values, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsNotIn(List<String> values) {
            addCriterion("Clients not in", values, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsBetween(String value1, String value2) {
            addCriterion("Clients between", value1, value2, "clients");
            return (Criteria) this;
        }

        public Criteria andClientsNotBetween(String value1, String value2) {
            addCriterion("Clients not between", value1, value2, "clients");
            return (Criteria) this;
        }

        public Criteria andGatheringdateIsNull() {
            addCriterion("GatheringDate is null");
            return (Criteria) this;
        }

        public Criteria andGatheringdateIsNotNull() {
            addCriterion("GatheringDate is not null");
            return (Criteria) this;
        }

        public Criteria andGatheringdateEqualTo(Date value) {
            addCriterionForJDBCDate("GatheringDate =", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("GatheringDate <>", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateGreaterThan(Date value) {
            addCriterionForJDBCDate("GatheringDate >", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GatheringDate >=", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateLessThan(Date value) {
            addCriterionForJDBCDate("GatheringDate <", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GatheringDate <=", value, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateIn(List<Date> values) {
            addCriterionForJDBCDate("GatheringDate in", values, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("GatheringDate not in", values, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GatheringDate between", value1, value2, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GatheringDate not between", value1, value2, "gatheringdate");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionIsNull() {
            addCriterion("GatheringCondition is null");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionIsNotNull() {
            addCriterion("GatheringCondition is not null");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionEqualTo(Integer value) {
            addCriterion("GatheringCondition =", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionNotEqualTo(Integer value) {
            addCriterion("GatheringCondition <>", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionGreaterThan(Integer value) {
            addCriterion("GatheringCondition >", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("GatheringCondition >=", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionLessThan(Integer value) {
            addCriterion("GatheringCondition <", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionLessThanOrEqualTo(Integer value) {
            addCriterion("GatheringCondition <=", value, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionIn(List<Integer> values) {
            addCriterion("GatheringCondition in", values, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionNotIn(List<Integer> values) {
            addCriterion("GatheringCondition not in", values, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionBetween(Integer value1, Integer value2) {
            addCriterion("GatheringCondition between", value1, value2, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringconditionNotBetween(Integer value1, Integer value2) {
            addCriterion("GatheringCondition not between", value1, value2, "gatheringcondition");
            return (Criteria) this;
        }

        public Criteria andGatheringtIsNull() {
            addCriterion("Gatheringt is null");
            return (Criteria) this;
        }

        public Criteria andGatheringtIsNotNull() {
            addCriterion("Gatheringt is not null");
            return (Criteria) this;
        }

        public Criteria andGatheringtEqualTo(Integer value) {
            addCriterion("Gatheringt =", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtNotEqualTo(Integer value) {
            addCriterion("Gatheringt <>", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtGreaterThan(Integer value) {
            addCriterion("Gatheringt >", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Gatheringt >=", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtLessThan(Integer value) {
            addCriterion("Gatheringt <", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtLessThanOrEqualTo(Integer value) {
            addCriterion("Gatheringt <=", value, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtIn(List<Integer> values) {
            addCriterion("Gatheringt in", values, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtNotIn(List<Integer> values) {
            addCriterion("Gatheringt not in", values, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtBetween(Integer value1, Integer value2) {
            addCriterion("Gatheringt between", value1, value2, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtNotBetween(Integer value1, Integer value2) {
            addCriterion("Gatheringt not between", value1, value2, "gatheringt");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayIsNull() {
            addCriterion("Gatheringtday is null");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayIsNotNull() {
            addCriterion("Gatheringtday is not null");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayEqualTo(Integer value) {
            addCriterion("Gatheringtday =", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayNotEqualTo(Integer value) {
            addCriterion("Gatheringtday <>", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayGreaterThan(Integer value) {
            addCriterion("Gatheringtday >", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("Gatheringtday >=", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayLessThan(Integer value) {
            addCriterion("Gatheringtday <", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayLessThanOrEqualTo(Integer value) {
            addCriterion("Gatheringtday <=", value, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayIn(List<Integer> values) {
            addCriterion("Gatheringtday in", values, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayNotIn(List<Integer> values) {
            addCriterion("Gatheringtday not in", values, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayBetween(Integer value1, Integer value2) {
            addCriterion("Gatheringtday between", value1, value2, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andGatheringtdayNotBetween(Integer value1, Integer value2) {
            addCriterion("Gatheringtday not between", value1, value2, "gatheringtday");
            return (Criteria) this;
        }

        public Criteria andItemremarkIsNull() {
            addCriterion("ItemRemark is null");
            return (Criteria) this;
        }

        public Criteria andItemremarkIsNotNull() {
            addCriterion("ItemRemark is not null");
            return (Criteria) this;
        }

        public Criteria andItemremarkEqualTo(Integer value) {
            addCriterion("ItemRemark =", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkNotEqualTo(Integer value) {
            addCriterion("ItemRemark <>", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkGreaterThan(Integer value) {
            addCriterion("ItemRemark >", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("ItemRemark >=", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkLessThan(Integer value) {
            addCriterion("ItemRemark <", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkLessThanOrEqualTo(Integer value) {
            addCriterion("ItemRemark <=", value, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkIn(List<Integer> values) {
            addCriterion("ItemRemark in", values, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkNotIn(List<Integer> values) {
            addCriterion("ItemRemark not in", values, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkBetween(Integer value1, Integer value2) {
            addCriterion("ItemRemark between", value1, value2, "itemremark");
            return (Criteria) this;
        }

        public Criteria andItemremarkNotBetween(Integer value1, Integer value2) {
            addCriterion("ItemRemark not between", value1, value2, "itemremark");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("State not between", value1, value2, "state");
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