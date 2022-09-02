package com.spring.vizsga.data;

import com.spring.vizsga.service.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {


    CardEntity cardToCardEntity(Card card);

    Card cardEntityToCard(CardEntity cardEntity);

    List<CardEntity> cardListToCardEntityList(List<Card> cards);

    List<Card> cardEntityListToCardList(List<CardEntity> cardEntities);

}
