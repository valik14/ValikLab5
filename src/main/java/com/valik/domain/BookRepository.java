package com.valik.domain;

import java.util.List;

/**
 * Created by валик on 02.06.2015.
 */
public interface BookRepository {
    void createBook(Book book);
    void createBook(List<Book> book);
    Book getBook(long id);
    void editBook(Book updatedEntity);
    void removeBook(Book updatedEntity);
    List<Book> getAllBooks();
}
