package com.spring.vizsga.service;

import com.spring.vizsga.data.entities.CardEntity;
import com.spring.vizsga.data.entities.CardEntityMapper;
import com.spring.vizsga.data.CardEntityRepository;
import com.spring.vizsga.service.domain.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private CardEntityRepository repository;

    private CardEntityMapper mapper;

    public CardService(CardEntityRepository repository, CardEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Card saveCard(Card card){
        return mapper.cardEntityToCard(
                repository.save(
                        mapper.cardToCardEntity(card)
                ));
    }

    public List<Card> getAllCards(){
        return mapper.cardEntityListToCardList(
                repository.findAll());
    }

    public Card getOneCard( int id){
        return mapper.cardEntityToCard(
                repository.findById(id).get());
    }

    public Card deleteOneCard(int id){
        CardEntity deletedCardEntity = repository.findById(id).get();
        repository.deleteById(id);
        return mapper.cardEntityToCard(deletedCardEntity);
    }

    public Card putOneCard(Card newCard,int oldsId) {
        CardEntity oldCardEntity = repository.findById(oldsId).get();
        newCard.setId(oldsId);
        repository.save(
                mapper.cardToCardEntity(newCard));
        return mapper.cardEntityToCard(oldCardEntity);
    }

    public List<Card> findByRarityGreaterThan(int value){
        return mapper.cardEntityListToCardList(
                repository.findByRarityGreaterThan(value));
    }

}
