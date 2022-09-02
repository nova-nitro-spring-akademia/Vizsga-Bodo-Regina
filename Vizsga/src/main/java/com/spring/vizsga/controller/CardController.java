package com.spring.vizsga.controller;

import com.spring.vizsga.controller.dtos.CardDTO;
import com.spring.vizsga.controller.dtos.CardDTOMapper;
import com.spring.vizsga.service.CardService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController {

    private CardService service;

    private CardDTOMapper mapper;

    public CardController(CardService service, CardDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/cards")
    public CardDTO saveCard(@Valid @RequestBody CardDTO cardDTO){
       return mapper.cardToCardDTO(
                service.saveCard(
                       mapper.cardDTOToCard(cardDTO)
                ));
    }

    @GetMapping("/cards")
    public List<CardDTO> getAllCards(){
        return mapper.cardListToCardDTOList(
                service.getAllCards());
    }

    @GetMapping("/cards/{id}")
    public CardDTO getOneCard(@PathVariable int id){
        return mapper.cardToCardDTO(
                service.getOneCard(id));
    }

    @DeleteMapping("/cards/{id}")
    public CardDTO deleteOneCard(@PathVariable int id){
        return mapper.cardToCardDTO(
                service.deleteOneCard(id));
    }

    @PutMapping("/cards/{id}")
    public CardDTO putOneCard(@Valid @RequestBody CardDTO CardDTO,@PathVariable int id){
        return mapper.cardToCardDTO(
                    service.putOneCard(
                        mapper.cardDTOToCard(CardDTO),id ));
    }


}
