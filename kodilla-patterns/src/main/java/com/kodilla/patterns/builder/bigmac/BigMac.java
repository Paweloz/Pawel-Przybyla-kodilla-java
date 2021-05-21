package com.kodilla.patterns.builder.bigmac;

import java.util.LinkedList;
import java.util.List;

public class BigMac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<String> ingridients;

    private BigMac(Bun bun, int burgers, Sauce sauce, List<String> ingridients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingridients = ingridients;
    }

    public static class BigMacBulider {
        private  Bun bun;
        private  int burgers;
        private  Sauce sauce;
        private final List<String> ingridients = new LinkedList<>();

        public BigMacBulider Bun(String bunType) {
            this.bun = new Bun(bunType);
            return this;
        }

        public BigMacBulider Burgers(int burgersQuantity) {
            this.burgers = burgersQuantity;
            return this;
        }

        public BigMacBulider Sauce(String sauce) {
            this.sauce = new Sauce(sauce);
            return this;
        }

        public BigMacBulider Ingredients(String ingredient) {
            if(Ingredient.correctIngredient(ingredient)) {
                this.ingridients.add(ingredient);
            }
            return this;
        }

        public BigMac build() {
            if( bun == null ) {
                throw new IllegalStateException("You cannot create burger without bun");
            }
            return new BigMac(bun, burgers, sauce, ingridients);
        }
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<String> getIngridients() {
        return ingridients;
    }

    @Override
    public String toString() {
        String ingredients = String.join(" ", ingridients);
        return "BigMac : \n" +
                " Bun type : " + bun.getBunType() +
                "\n Burgers quantity : " + burgers +
                "\n Sauce type : " + sauce.getSauce() +
                "\n Ingridients : " + ingredients;
    }
}
