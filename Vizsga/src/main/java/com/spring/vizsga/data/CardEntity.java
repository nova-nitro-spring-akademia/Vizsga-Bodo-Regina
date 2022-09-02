package com.spring.vizsga.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    private String type;

    private int showupPercent;

    private int pricePayed;

    private int yearAcquired;

    private int printYear;

    private int originalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getShowupPercent() {
        return showupPercent;
    }

    public void setShowupPercent(int showupPercent) {
        this.showupPercent = showupPercent;
    }

    public int getPricePayed() {
        return pricePayed;
    }

    public void setPricePayed(int pricePayed) {
        this.pricePayed = pricePayed;
    }

    public int getYearAcquired() {
        return yearAcquired;
    }

    public void setYearAcquired(int yearAcquired) {
        this.yearAcquired = yearAcquired;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
