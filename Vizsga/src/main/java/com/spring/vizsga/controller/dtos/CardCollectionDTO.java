package com.spring.vizsga.controller.dtos;

import com.spring.vizsga.data.entities.CardEntity;

import java.util.List;

public class CardCollectionDTO {

    private int id;

    private String name;

    private List<CardDTO> cards;

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

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }
}
