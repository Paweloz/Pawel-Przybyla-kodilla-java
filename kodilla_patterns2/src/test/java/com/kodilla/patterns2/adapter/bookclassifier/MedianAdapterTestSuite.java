package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {
    private final static Set<Book> books = new HashSet<>();

    @BeforeAll
    static void setup() {
        books.add(new Book("Author1", "Title1", 1995, "1111111111"));
        books.add(new Book("Author2", "Title2", 1998, "1111111112"));
        books.add(new Book("Author3", "Title3", 2010, "1111111113"));
        books.add(new Book("Author4", "Title4", 2005, "1111111114"));
        books.add(new Book("Author5", "Title5", 2001, "1111111115"));
        books.add(new Book("Author6", "Title6", 1999, "1111111116"));
        books.add(new Book("Author7", "Title7", 1853, "1111111117"));
        books.add(new Book("Author8", "Title8", 2020, "1111111118"));
        books.add(new Book("Author9", "Title9", 1958, "1111111119"));
    }

    @Test
    void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(books);
        System.out.println(median);
        //Then
        assertEquals(1999, median);


    }

}