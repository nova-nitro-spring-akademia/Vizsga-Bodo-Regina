package com.spring.vizsga.service.domain;

import java.time.LocalDate;

public class Card {

    private int id;

    private String name;

    private String type;

    private int rarity;

    private int pricePayed;

    private int yearAcquired;

    private int printYear;

    private int originalPrice;

    private int cardCollectionId;

    public double estimatedValue(){
        return (originalPrice * (LocalDate.now().getYear()-printYear) * 1.1);
    }

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
