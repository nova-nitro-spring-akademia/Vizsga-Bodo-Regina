package com.spring.vizsga.data.entities;

import com.spring.vizsga.service.domain.Card;
import com.spring.vizsga.service.domain.CardCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CardEntityMapper.class)
public interface CardCollectionEntityMapper {


    CardCollectionEntity cardCollectionToCardCollectionEntity(CardCollection cardCollection);


    CardCollection cardCollectionEntityToCardCollection(CardCollectionEntity cardCollectionEntity);


    List<CardCollectionEntity> cardCollectionListToCardCollectionEntityList(List<CardCollection> cardCollections);


    List<CardCollection> cardCollectionEntityListToCardCollectionList(List<CardCollectionEntity> cardCollectionEntities);


}
