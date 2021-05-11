package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    public void testLoadFromDb() {
        //Given
        //When
        library.loadFromDb();
        //Then
        //do nothing
    }

    @Test
    public void testSaveToDb() {
        //Given
        //When
        library.saveToDb();
        //Then
        //do nothing
    }

    @Test
    void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        String[] beans = context.getBeanDefinitionNames();
        //When
        System.out.println("=============== Bean List =================");
        Arrays.stream(beans)
                .forEach(System.out::println);
        System.out.println("=============== Bean List =================");
        //Then
    }
}