package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {
    private final static Set<BookA> booksA = new HashSet<>();

    @BeforeAll
    static void setup() {
        booksA.add(new BookA("Author1", "Title1", 1995, "1111111111"));
        booksA.add(new BookA("Author2", "Title2", 1998, "1111111112"));
        booksA.add(new BookA("Author3", "Title3", 2010, "1111111113"));
        booksA.add(new BookA("Author4", "Title4", 2005, "1111111114"));
        booksA.add(new BookA("Author5", "Title5", 2001, "1111111115"));
        booksA.add(new BookA("Author6", "Title6", 1999, "1111111116"));
        booksA.add(new BookA("Author7", "Title7", 1853, "1111111117"));
        booksA.add(new BookA("Author8", "Title8", 2020, "1111111118"));
        booksA.add(new BookA("Author9", "Title9", 1958, "1111111119"));
    }

    @Test
    void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(booksA);
        System.out.println(median);
        //Then
        assertEquals(1999, median);


    }

}