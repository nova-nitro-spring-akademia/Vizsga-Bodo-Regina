package com.spring.vizsga.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CardEntityRepository extends JpaRepository<CardEntity, Integer> {

    List<CardEntity> findByRarityGreaterThan(int value);

}
