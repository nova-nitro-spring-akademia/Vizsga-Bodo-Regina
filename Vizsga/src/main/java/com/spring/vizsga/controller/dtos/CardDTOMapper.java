package com.spring.vizsga.controller.dtos;

import com.spring.vizsga.data.CardEntity;
import com.spring.vizsga.service.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardDTOMapper {

    CardDTO cardToCardDTO(Card card);

    Card cardDTOToCard(CardDTO cardDTO);

    List<CardDTO> cardListToCardDTOList(List<Card> cards);

    List<Card> cardDTOListToCardList(List<CardDTO> cardDTOs);

}
