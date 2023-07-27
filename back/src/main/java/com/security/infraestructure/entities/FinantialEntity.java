package com.security.infraestructure.entities;

import com.security.domain.model.Finantial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "finantial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinantialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "segment")
    private String segment;

    @Column(name = "country")
    private String country;

    @Column(name = "product")
    private String product;

    @Column(name = "discount_band")
    private String discountBand;

    @Column(name = "units_sold")
    private int unitsSold;

    @Column(name = "manufactoring")
    private double manufactoring;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "gross_sales")
    private double grossSale;

    @Column(name = "discounts")
    private double discounts;

    @Column(name = "sales")
    private double sales;

    @Column(name = "cogs")
    private double cogs;

    @Column(name = "profit")
    private double profit;

    @Column(name = "process_date")
    private Timestamp proccessDate;

    @Column(name = "month_number")
    private int monthNumber;

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "process_year")
    private int proccessYear;

    public static FinantialEntity fromDomainModel(Finantial finantial){
        return new FinantialEntity(finantial.getId(), finantial.getSegment(), finantial.getCountry(), finantial.getProduct(), finantial.getDiscountBand(), finantial.getUnitsSold(), finantial.getManufactoring(), finantial.getSalePrice(), finantial.getGrossSale(), finantial.getDiscounts(), finantial.getSales(), finantial.getCogs(), finantial.getProfit(), finantial.getProccessDate(), finantial.getMonthNumber(), finantial.getMonthName(), finantial.getProccessYear());
    }

    public Finantial toDomainModel(){
        return new Finantial(id, segment, country, product, discountBand, unitsSold, manufactoring, salePrice, grossSale, discounts, sales, cogs, profit, proccessDate, monthNumber, monthName, proccessYear);
    }
}
