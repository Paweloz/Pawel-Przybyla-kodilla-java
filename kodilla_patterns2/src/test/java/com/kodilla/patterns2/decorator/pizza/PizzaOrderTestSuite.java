package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    void testPizzaOrderDecorator() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new Pepperoni(pizzaOrder);
        pizzaOrder = new ExtraCheese(pizzaOrder);
        pizzaOrder = new Mushrooms(pizzaOrder);
        pizzaOrder = new Arugula(pizzaOrder);

        //When
        BigDecimal totalCost = pizzaOrder.getCost();
        String ingredientsList = pizzaOrder.getIngredients();
        String expectedList = "Tomato souce + Cheese + Pepperoni + Extra cheese + Mushrooms + Arugula";

        //Then
        assertEquals(new BigDecimal("24"), totalCost);
        assertEquals(expectedList, ingredientsList);
        System.out.println("Pizza ingredients : " + ingredientsList + "\n" + "Pizza cost : " + totalCost);
    }
}
