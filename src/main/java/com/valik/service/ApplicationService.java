package com.valik.service;

import com.valik.domain.Book;

import java.util.List;

/**
 * Created by валик on 02.06.2015.
 */
public interface ApplicationService {
    int removeBooksWithKNames();
    int removeBoksIdNotFibanachi();
    List<Book> getAllBooks();
}
