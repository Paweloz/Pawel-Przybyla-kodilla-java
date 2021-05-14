package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class LibraryTestSuite {

    private Library shallowCopyLibrary;
    private Library deepCopyLibrary;

    @Test
    void testGetBook() {
        //Given
        Library library = new Library("Local Library");
        Book book1 = new Book("Ogniem i mieczem", "Henryk Sienkiewicz",
                LocalDate.of(1884,10,24));
        Book book2 = new Book("Wiedzmin", "Andrzej Sapkowski",
                LocalDate.of(1986,5,25));
        Book book3 = new Book("Potega podswiadomosci","Joseph Murphy",
                LocalDate.of(2007,10,23));
        Book book4 = new Book("Potop", "Henryk Sienkiewicz",
                LocalDate.of(1886,3,30));
        Book book5 = new Book("Wesele", "Stanislaw Wyspianski",
                LocalDate.of(1901,11,21));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        try {
            shallowCopyLibrary = library.shallowCopy();
            deepCopyLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        shallowCopyLibrary.getBooks().remove(book1);
        shallowCopyLibrary.setName("Shallow Copy Library");
        deepCopyLibrary.setName("Deep Copy Library");

        //Then
        System.out.println(library + "\n" + shallowCopyLibrary + "\n" + deepCopyLibrary);
        assertEquals(4, shallowCopyLibrary.getBooks().size());
        assertEquals(4, library.getBooks().size());
        assertEquals(5, deepCopyLibrary.getBooks().size());
    }
}
