package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        clonedLibrary.books.addAll(books);

        return clonedLibrary;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        String booksList = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
        return "\nLibrary :" + name + "\n"+ booksList;
    }
}