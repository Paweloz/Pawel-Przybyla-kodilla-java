package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclassifier.librarya.Book> bookSet) {
        Map<BookSignature, Book> booksMap = bookSet.stream()
                .collect(Collectors.toMap(
                        book -> new BookSignature(book.getSignature()),
                        book -> new Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()))
                );
        return medianPublicationYear(booksMap);
    }
}
