package com.spring.vizsga.controller;

import com.spring.vizsga.controller.dtos.CardDTO;
import com.spring.vizsga.controller.dtos.CardDTOMapper;
import com.spring.vizsga.data.CardEntity;
import com.spring.vizsga.data.CardEntityRepository;
import com.spring.vizsga.service.CardService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {

    private CardService service;

    private CardDTOMapper mapper;

    public CardController(CardService service, CardDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/saveCard")
    public CardDTO saveCard(@Valid @RequestBody CardDTO cardDTO){
       return mapper.cardToCardDTO(
                service.saveCard(
                       mapper.cardDTOToCard(cardDTO)
                ));
    }

    @GetMapping("/getAll")
    public List<CardDTO> getAllCards(){
        return mapper.cardListToCardDTOList(
                service.getAllCards());
    }

    @GetMapping("/getOne/{id}")
    public CardDTO getOneCard(@PathVariable int id){
        return mapper.cardToCardDTO(
                service.getOneCard(id));
    }

    @DeleteMapping("/deleteOne/{id}")
    public CardDTO deleteOneCard(@PathVariable int id){
        return mapper.cardToCardDTO(
                service.deleteOneCard(id));
    }

    @PutMapping("/putOne/{oldsId}")
    public CardDTO putOneCard(@Valid @RequestBody CardDTO newCardDTO,@PathVariable int oldsId){
        return mapper.cardToCardDTO(
                    service.putOneCard(
                        mapper.cardDTOToCard(newCardDTO),oldsId ));
    }


}
