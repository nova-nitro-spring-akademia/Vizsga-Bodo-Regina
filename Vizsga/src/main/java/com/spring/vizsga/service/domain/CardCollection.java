package com.spring.vizsga.service.domain;

import com.spring.vizsga.data.entities.CardEntity;

import javax.persistence.OneToMany;
import java.util.List;

public class CardCollection {

    private int id;

    private String name;

    private List<Card> cards;

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
