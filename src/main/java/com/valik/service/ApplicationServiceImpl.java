package com.valik.service;

import com.valik.domain.Book;
import com.valik.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ����� on 02.06.2015.
 */
public class ApplicationServiceImpl implements ApplicationService {
    private static final Logger LOGGER =  LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public int removeBooksWithKNames() {
        LOGGER.debug("removeBooksWithKNames begin");
        List<Book> list = bookRepository.getAllBooks();
        int count = 0;
        for(Book book:list){
            if(book.getName().startsWith("K")){
                bookRepository.removeBook(book);
                count++;
            }
        }
        LOGGER.debug("removeBooksWithKNames end");
        return count;
    }
    @Override
    @Transactional
    public int removeBoksIdNotFibanachi() {
        LOGGER.debug("removeBoksIdNotFibanachi begin");
        List<Book> list = bookRepository.getAllBooks();
        LinkedList<Integer> fibanachi = new LinkedList<>();
        fibanachi.add(0);
        fibanachi.add(1);
        int count = 0;
        for(Book book:list){
            if(book.getId()>0){
                if(book.getId()==fibanachi.getLast()+fibanachi.get(fibanachi.size()-2)){
                    fibanachi.add(book.getId());
                }else{
                    bookRepository.removeBook(book);
                    count++;
                }
            }
        }
        LOGGER.debug("removeBoksIdNotFibanachi end");
        return count;
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.debug("getAllBooks begin");
        LOGGER.debug("getAllBooks end");

        return bookRepository.getAllBooks();
    }

    public ApplicationServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
