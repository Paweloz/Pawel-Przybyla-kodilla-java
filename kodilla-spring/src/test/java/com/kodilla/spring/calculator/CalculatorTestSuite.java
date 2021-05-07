package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        // Given
        //do nothing
        //When
        double resultAdd = calculator.add(2,5);
        double resultSub = calculator.sub(7,3);
        double resultMul = calculator.mul(2,7);
        double resultDiv = calculator.div(21,3);
        //Then
        Assertions.assertEquals(7, resultAdd);
        Assertions.assertEquals(4, resultSub);
        Assertions.assertEquals(14, resultMul);
        Assertions.assertEquals(7, resultDiv);
    }
}
