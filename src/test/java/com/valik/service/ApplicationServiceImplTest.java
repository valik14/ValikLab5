package com.valik.service;

import com.valik.domain.Book;
import com.valik.domain.BookRepository;
import com.valik.domain.BookRepositoryImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by ����� on 03.06.2015.
 */
public class ApplicationServiceImplTest {

    @Test
    public void testRemoveBooksWithKNames() throws Exception {
        List<Book> list = new LinkedList<>();
        Date date = new Date();
        list.add(new Book("NAME","description",100,"AUTOR",date));
        list.add(new Book("dZD","description",100,"AUTOR",date));
        list.add(new Book("kdas","description",100,"AUTOR",date));
        list.add(new Book("KNAME","description",100,"AUTOR",date));
        list.add(new Book("as","description",100,"AUTOR",date));

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBooksWithKNames();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository).removeBook(new Book("KNAME","description",100,"AUTOR",date));
    }
    public void testRemoveBooksWithKNamesWithEmptyRepository() throws Exception {
        List<Book> list = new LinkedList<>();

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBooksWithKNames();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository,never()).removeBook(any());
    }
    public void testRemoveBooksWithKNamesNoKNames() throws Exception {
        List<Book> list = new LinkedList<>();
        Date date = new Date();
        list.add(new Book("NAME","description",100,"AUTOR",date));
        list.add(new Book("dZD","description",100,"AUTOR",date));
        list.add(new Book("kdas","description",100,"AUTOR",date));
        list.add(new Book("1KNAME","description",100,"AUTOR",date));
        list.add(new Book("as","description",100,"AUTOR",date));

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBooksWithKNames();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository,never()).removeBook(any());
    }

    @Test
    public void testRemoveBoksIdNotFibanachi() throws Exception {
        List<Book> list = new LinkedList<>();
        Date date = new Date();
        list.add(new Book(0,"NAME","description",100,"AUTOR",date));
        list.add(new Book(1,"dZD","description",100,"AUTOR",date));
        list.add(new Book(2,"kdas","description",100,"AUTOR",date));
        list.add(new Book(3,"KNAME","description",100,"AUTOR",date));
        list.add(new Book(4,"as","description",100,"AUTOR",date));
        list.add(new Book(5,"NAME","description",100,"AUTOR",date));
        list.add(new Book(6,"dZD","description",100,"AUTOR",date));
        list.add(new Book(7,"kdas","description",100,"AUTOR",date));
        list.add(new Book(8,"KNAME","description",100,"AUTOR",date));
        list.add(new Book(9,"as","description",100,"AUTOR",date));

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBoksIdNotFibanachi();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository).removeBook(new Book(4,"as","description",100,"AUTOR",date));
        verify(bookRepository).removeBook(new Book(6,"dZD","description",100,"AUTOR",date));
        verify(bookRepository).removeBook(new Book(7,"kdas","description",100,"AUTOR",date));
        verify(bookRepository).removeBook(new Book(9,"as","description",100,"AUTOR",date));

    }
    @Test
    public void testRemoveBoksIdNotFibanachiEmptyRepository() throws Exception {
        List<Book> list = new LinkedList<>();
        Date date = new Date();

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBoksIdNotFibanachi();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository,never()).removeBook(any());
    }
    @Test
    public void testRemoveBoksIdNotFibanachiAllIdFibanachi() throws Exception {
        List<Book> list = new LinkedList<>();
        Date date = new Date();
        list.add(new Book(0,"NAME","description",100,"AUTOR",date));
        list.add(new Book(1,"dZD","description",100,"AUTOR",date));
        list.add(new Book(2,"kdas","description",100,"AUTOR",date));
        list.add(new Book(3,"KNAME","description",100,"AUTOR",date));
        list.add(new Book(5,"NAME","description",100,"AUTOR",date));
        list.add(new Book(8,"KNAME","description",100,"AUTOR",date));

        BookRepository bookRepository = mock(BookRepositoryImpl.class);
        when(bookRepository.getAllBooks()).thenReturn(list);
        ApplicationService aplicationService = new ApplicationServiceImpl(bookRepository);
        aplicationService.removeBoksIdNotFibanachi();
        verify(bookRepository,times(1)).getAllBooks();
        verify(bookRepository,never()).removeBook(any());
    }
}