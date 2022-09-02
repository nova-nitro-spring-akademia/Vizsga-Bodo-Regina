package com.spring.vizsga.controller;

import com.spring.vizsga.service.CardCollectionService;
import com.spring.vizsga.service.CardService;
import com.spring.vizsga.service.domain.Card;
import com.spring.vizsga.service.domain.CardCollection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private CardService cardService;

    private CardCollectionService collectionService;

    public ViewController(CardService cardService, CardCollectionService collectionService) {
        this.cardService = cardService;
        this.collectionService = collectionService;
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

}
