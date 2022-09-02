package com.spring.vizsga.data;

import com.spring.vizsga.data.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CardEntityRepository extends JpaRepository<CardEntity, Integer> {

    List<CardEntity> findByRarityGreaterThan(int value);

}
