package com.spring.vizsga.controller.dtos;

import com.spring.vizsga.service.domain.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardDTOMapper {

    CardDTO cardToCardDTO(Card card);

    Card cardDTOToCard(CardDTO cardDTO);

    List<CardDTO> cardListToCardDTOList(List<Card> cards);

    List<Card> cardDTOListToCardList(List<CardDTO> cardDTOs);

}
