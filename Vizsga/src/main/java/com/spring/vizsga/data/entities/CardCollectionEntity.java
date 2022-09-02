package com.spring.vizsga.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class CardCollectionEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany
    private List<CardEntity> cards;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
