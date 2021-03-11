package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case : begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case : end");
    }

    @DisplayName("when create OddNumbersExterminator with empty list" +
            "then exterminate() should return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> testList = new LinkedList<>();
        List<Integer> compareList;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        compareList = oddNumbersExterminator.exterminate(testList);
        //Then
        Assertions.assertNull(compareList);
    }

    @DisplayName("when create OddNumbersExterminator with normal list" +
            "then exterminate() should return list with even numbers")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        Integer[] tab = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Integer[] compareTab = {2,4,6,8,10,12,14,16};
        List<Integer> compareList;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        compareList = oddNumbersExterminator.exterminate(Arrays.asList(tab));
        //Then
        Assertions.assertEquals(Arrays.asList(compareTab),compareList);
    }
}
