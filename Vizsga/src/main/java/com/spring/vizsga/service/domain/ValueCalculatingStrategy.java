package com.spring.vizsga.service.domain;


import java.time.LocalDate;

public enum ValueCalculatingStrategy {

    BASIC {
        @Override
        public double calculate(Card card) {
            return card.getOriginalPrice() * (LocalDate.now().getYear()- card.getPrintYear()) * 1.1;
        }
    },

    INCLUDE_RARITY {
        @Override
        public double calculate(Card card) {
            //zárójelezés módosítva az eredetihez képest
            //castolás mert másképp nem kezelte jól a százalákká alakítást
            return (double)card.getOriginalPrice() * (double)(LocalDate.now().getYear()- card.getPrintYear()) * (1.0 + (1.0/100.0 * (100.0 - (double)card.getRarity())));
        }
    };

    public abstract double calculate(Card card);
}
