package com.valik.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by валик on 02.06.2015.
 */
public class BookRepositoryImpl implements BookRepository{

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
        return (Book)sessionFactory.getCurrentSession().get(Book.class,id);
    }

    @Override
    public void editBook(Book updatedBook) {
        sessionFactory.getCurrentSession().update(updatedBook);
    }

    @Override
    public void removeBook(Book remotedBook) {
        sessionFactory.getCurrentSession().delete(remotedBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return sessionFactory.getCurrentSession().createQuery( "FROM Book" ).list();
    }
}