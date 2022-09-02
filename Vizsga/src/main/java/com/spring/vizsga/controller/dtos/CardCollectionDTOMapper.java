package com.spring.vizsga.controller.dtos;

import com.spring.vizsga.service.domain.Card;
import com.spring.vizsga.service.domain.CardCollection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CardDTOMapper.class})
public interface CardCollectionDTOMapper {

    CardCollectionDTO cardCollectionToCardCollectionDTO(CardCollection cardCollection);

    CardCollection cardCollectionDTOToCardCollection(CardCollectionDTO cardCollectionDTO);

    List<CardCollectionDTO> cardCollectionListToCardCollectionDTOList(List<CardCollection> cardCollections);

    List<CardCollection> cardCollectionDTOListToCardCollectionList(List<CardCollectionDTO> cardCollectionDTOs);

}
