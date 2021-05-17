package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {
    @Test
    void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigMacBulider()
                .Bun(Bun.SEASAM)
                .Ingredients(Ingredient.BACONE)
                .Ingredients(Ingredient.CHEESE)
                .Sauce(Sauce.STANDARD)
                .Burgers(1)
                .Ingredients(Ingredient.CHILLI)
                .build();

        //When
        String bun = bigMac.getBun().getBunType();
        String sauce = bigMac.getSauce().getSauce();
        int burgers = bigMac.getBurgers();
        List<String> ingredients = bigMac.getIngridients();
        System.out.println(bigMac);

        //Then
        assertEquals("SEASAM", bun);
        assertEquals("STANDARD", sauce);
        assertEquals(1, burgers);
        assertEquals(3, ingredients.size());
    }
}
