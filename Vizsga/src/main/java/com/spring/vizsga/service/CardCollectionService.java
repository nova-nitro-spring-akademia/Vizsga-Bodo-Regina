package com.spring.vizsga.service;

import com.spring.vizsga.data.CardCollectionEntityRepository;
import com.spring.vizsga.data.entities.CardCollectionEntityMapper;
import com.spring.vizsga.service.domain.Card;
import com.spring.vizsga.service.domain.CardCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardCollectionService {

    private CardCollectionEntityRepository repository;

    private CardCollectionEntityMapper mapper;

    public CardCollectionService(CardCollectionEntityRepository repository, CardCollectionEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CardCollection saveCardCollection(CardCollection cardCollection){
        return mapper.cardCollectionEntityToCardCollection(
                repository.save(
                        mapper.cardCollectionToCardCollectionEntity(cardCollection)
                ));
    }

    public List<CardCollection> getAllCardCollections(){
        return mapper.cardCollectionEntityListToCardCollectionList(
                repository.findAll());
    }

    public CardCollection getOneCardCollection( int id){
        return mapper.cardCollectionEntityToCardCollection(
                repository.findById(id).get());
    }
}
