package com.spring.vizsga.controller;

import com.spring.vizsga.data.CardEntity;
import com.spring.vizsga.data.CardEntityRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController {

    private CardEntityRepository repository;

    public CardController(CardEntityRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/saveCard")
    public CardEntity saveCard(@Valid @RequestBody CardEntity cardEntity){
       return repository.save(cardEntity);
    }

    @GetMapping("/getAll")
    public List<CardEntity> getAllCards(){
        return repository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public CardEntity getOneCard(@PathVariable int id){
        return repository.findById(id).get();
    }

    @DeleteMapping("/deleteOne/{id}")
    public CardEntity deleteOneCard(@PathVariable int id){
        CardEntity deletedCardEntity = repository.findById(id).get();
        repository.deleteById(id);
        return deletedCardEntity;
    }

    @PutMapping("/putOne/{oldsId}")
    public CardEntity putOneCard(@Valid @RequestBody CardEntity newCardEntity,@PathVariable int oldsId){
        CardEntity oldCardEntity = repository.findById(oldsId).get();
        newCardEntity.setId(oldsId);
        repository.save(newCardEntity);
        return oldCardEntity;
    }


}
