package com.spring.vizsga.controller;

import com.spring.vizsga.controller.dtos.CardDTO;
import com.spring.vizsga.controller.dtos.CardDTOMapper;
import com.spring.vizsga.service.CardCollectionService;
import com.spring.vizsga.service.CardService;
import com.spring.vizsga.service.domain.Card;
import com.spring.vizsga.service.domain.CardCollection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private CardService cardService;

    private CardCollectionService collectionService;

    private CardDTOMapper cardMapper;

    public ViewController(CardService cardService, CardCollectionService collectionService, CardDTOMapper cardMapper) {
        this.cardService = cardService;
        this.collectionService = collectionService;
        this.cardMapper = cardMapper;
    }

    @GetMapping("/")
    public String indexPage(){
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("cards",cardService.getAllCards());
        return "list";
    }

    @GetMapping("/createCardPage")
    public String createCardPage(Model model){
        model.addAttribute("card", new Card());
        return "create";
    }

    @PostMapping("/createCard")
    public String createCard(Card card){
        cardService.saveCard(card);
        return "redirect:/list";
    }

    @GetMapping("/custom")
    public String custom(){
        return "customQuery";
    }

    @PostMapping("/customList")
    public String showCustomlist(@RequestParam int value, Model model){
        model.addAttribute("cards",cardService.findByRarityGreaterThan(value));
        return "customList";
    }

    @GetMapping("/newCollection")
    public String newCollectionPage(){
        return "createCollection";
    }
    @PostMapping("/createCollection")
    public String newCollection(@RequestParam String name){
        CardCollection cardCollection = new CardCollection();
        cardCollection.setName(name);
        collectionService.saveCardCollection(cardCollection);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editCard(@PathVariable int id, Model model){

        model.addAttribute("card", cardMapper.cardToCardDTO(
                                                cardService.getOneCard(id)));
        model.addAttribute("collections",collectionService.getAllCardCollections());
        return "cardData";
    }

    //todo azt biztosítani hogy ez tényleg fellírás legyen
    @PostMapping("/editCard")
    public String editCard(CardDTO cardDTO){
        CardCollection collection = collectionService.getOneCardCollection(cardDTO.getCardCollectionId());
        Card card = cardMapper.cardDTOToCard(cardDTO);

        cardService.saveCard(card);

        collection.addCard(card);
        collectionService.saveCardCollection(collection);

        return "redirect:/list";
    }

}
