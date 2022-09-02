package com.spring.vizsga.data.entities;

import com.spring.vizsga.service.domain.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {


    CardEntity cardToCardEntity(Card card);

    Card cardEntityToCard(CardEntity cardEntity);

    List<CardEntity> cardListToCardEntityList(List<Card> cards);

    List<Card> cardEntityListToCardList(List<CardEntity> cardEntities);

}
