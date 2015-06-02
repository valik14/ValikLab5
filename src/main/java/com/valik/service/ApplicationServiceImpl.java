package com.valik.service;

import com.valik.domain.Book;
import com.valik.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * Created by валик on 02.06.2015.
 */
public class ApplicationServiceImpl implements AplicationService {
    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public int removeBooksWithKNames() {
        List<Book> list = bookRepository.getAllBooks();
        Iterator<Book> iterable =list.listIterator();
        while(iterable.hasNext()){    

        }
        return 0;
    }

    @Override
    @Transactional
    public int removeBoksIdNotFibanachi() {
        return 0;
    }
}
