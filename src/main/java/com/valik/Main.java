package com.valik;

import com.valik.domain.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by валик on 02.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        BookRepository bookRepository = (BookRepository)context.getBean("bookRepository");


    }
}
