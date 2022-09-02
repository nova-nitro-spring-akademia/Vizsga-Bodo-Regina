package com.spring.vizsga.controller;

import com.spring.vizsga.data.CardEntity;
import com.spring.vizsga.data.CardEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private CardEntityRepository repository;

    public ViewController(CardEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String indexPage(){
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("cards",repository.findAll());
        return "list";
    }

    @GetMapping("/createCardPage")
    public String createCardPage(Model model){
        model.addAttribute("card", new CardEntity());
        return "create";
    }

    @PostMapping("/createCard")
    public String createCard(CardEntity cardEntity){
        repository.save(cardEntity);
        return "redirect:/list";
    }


}
