package com.spring.vizsga.controller;

import com.spring.vizsga.data.CardEntity;
import com.spring.vizsga.data.CardEntityRepository;
import com.spring.vizsga.service.CardService;
import com.spring.vizsga.service.domain.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private CardService cardService;

    public ViewController(CardService cardService) {
        this.cardService = cardService;
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


}
