package com.spring.vizsga.controller.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CardDTO {

    private int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    private String type;

    @Min(1)
    @Max(100)
    private int rarity;

    @Positive
    private int pricePayed;

    @Positive
    private int yearAcquired;

    @Positive
    private int printYear;

    @Positive
    private int originalPrice;

    private int cardCollectionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
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

    public int getCardCollectionId() {
        return cardCollectionId;
    }
    public void setCardCollectionId(int cardCollectionId) {
        this.cardCollectionId = cardCollectionId;
    }
}
