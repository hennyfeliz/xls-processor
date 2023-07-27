package com.security.domain.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Finantial {
    private Long id;
    private String segment;
    private String country;
    private String product;
    private String discountBand;
    private int unitsSold;
    private double manufactoring;
    private double salePrice;
    private double grossSale;
    private double discounts;
    private double sales;
    private double cogs;
    private double profit;
    private Timestamp proccessDate;
    private int monthNumber;
    private String monthName;
    private int proccessYear;

    public Finantial(Long id, String segment, String country, String product, String discountBand, int unitsSold, double manufactoring, double salePrice, double grossSale, double discounts, double sales, double cogs, double profit, Timestamp proccessDate, int monthNumber, String monthName, int proccessYear) {
        this.id = id;
        this.segment = segment;
        this.country = country;
        this.product = product;
        this.discountBand = discountBand;
        this.unitsSold = unitsSold;
        this.manufactoring = manufactoring;
        this.salePrice = salePrice;
        this.grossSale = grossSale;
        this.discounts = discounts;
        this.sales = sales;
        this.cogs = cogs;
        this.profit = profit;
        this.proccessDate = proccessDate;
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.proccessYear = proccessYear;
    }

    public Finantial() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDiscountBand() {
        return discountBand;
    }

    public void setDiscountBand(String discountBand) {
        this.discountBand = discountBand;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public double getManufactoring() {
        return manufactoring;
    }

    public void setManufactoring(double manufactoring) {
        this.manufactoring = manufactoring;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getCogs() {
        return cogs;
    }

    public void setCogs(double cogs) {
        this.cogs = cogs;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Timestamp getProccessDate() {
        return proccessDate;
    }

    public void setProccessDate(Timestamp proccessDate) {
        this.proccessDate = proccessDate;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getProccessYear() {
        return proccessYear;
    }

    public void setProccessYear(int proccessYear) {
        this.proccessYear = proccessYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finantial finantial = (Finantial) o;
        return unitsSold == finantial.unitsSold && Double.compare(finantial.manufactoring, manufactoring) == 0 && Double.compare(finantial.salePrice, salePrice) == 0 && Double.compare(finantial.grossSale, grossSale) == 0 && Double.compare(finantial.discounts, discounts) == 0 && Double.compare(finantial.sales, sales) == 0 && Double.compare(finantial.cogs, cogs) == 0 && Double.compare(finantial.profit, profit) == 0 && monthNumber == finantial.monthNumber && proccessYear == finantial.proccessYear && Objects.equals(id, finantial.id) && Objects.equals(segment, finantial.segment) && Objects.equals(country, finantial.country) && Objects.equals(product, finantial.product) && Objects.equals(discountBand, finantial.discountBand) && Objects.equals(proccessDate, finantial.proccessDate) && Objects.equals(monthName, finantial.monthName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, segment, country, product, discountBand, unitsSold, manufactoring, salePrice, grossSale, discounts, sales, cogs, profit, proccessDate, monthNumber, monthName, proccessYear);
    }

    @Override
    public String toString() {
        return "Finantial{" +
                "id=" + id +
                ", segment='" + segment + '\'' +
                ", country='" + country + '\'' +
                ", product='" + product + '\'' +
                ", discountBand='" + discountBand + '\'' +
                ", unitsSold=" + unitsSold +
                ", manufactoring=" + manufactoring +
                ", salePrice=" + salePrice +
                ", grossSale=" + grossSale +
                ", discounts=" + discounts +
                ", sales=" + sales +
                ", cogs=" + cogs +
                ", profit=" + profit +
                ", proccessDate=" + proccessDate +
                ", monthNumber=" + monthNumber +
                ", monthName='" + monthName + '\'' +
                ", proccessYear=" + proccessYear +
                '}';
    }
}
