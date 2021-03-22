package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] tab = {12,15,14,20,3,2,89,58,7,412,36,45,123,1,25,65,3,214,26,47};
        //When
        double average = ArrayOperations.getAverage(tab);
        //Then
        assertEquals(60.85,average);
    }
}
