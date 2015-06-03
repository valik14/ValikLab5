package com.valik.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by валик on 02.06.2015.
 */
public class BookRepositoryImpl implements BookRepository{
    static final Logger logger = LoggerFactory.getLogger(BookRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void createBook(List<Book> books) {
        Session session=sessionFactory.getCurrentSession();
        for(Book book:books)session.save(book);

    }

    @Override
    public Book getBook(long id) {
        logger.trace("getBoo method begin with id = {}",id);
        logger.trace("getBoo method end");
        return (Book)sessionFactory.getCurrentSession().get(Book.class,id);
    }

    @Override
    public void editBook(Book updatedBook) {
        logger.trace("updatedBook method begin with updatedBook = {}",updatedBook);
        sessionFactory.getCurrentSession().update(updatedBook);
        logger.trace("updatedBook method end");
    }

    @Override
    public void removeBook(Book remotedBook) {
        logger.trace("removeBook method begin with removeBook = {}",remotedBook);
        sessionFactory.getCurrentSession().delete(remotedBook);
        logger.trace("remotedBook method end");
    }

    @Override
    public List<Book> getAllBooks() {
        logger.trace("getAllBooks method begin");
        logger.trace("getAllBooks method end");
        return sessionFactory.getCurrentSession().createQuery( "FROM Book" ).list();
    }
}