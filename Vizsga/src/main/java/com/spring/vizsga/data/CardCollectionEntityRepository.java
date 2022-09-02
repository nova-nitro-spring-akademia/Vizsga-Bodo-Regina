package com.spring.vizsga.data;

import com.spring.vizsga.data.entities.CardCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardCollectionEntityRepository extends JpaRepository<CardCollectionEntity,Integer> {
}
