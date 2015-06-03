package com.valik;

import com.valik.domain.BookRepository;
import com.valik.service.ApplicationService;
import com.valik.service.ApplicationServiceImpl;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by валик on 02.06.2015.
 */
public class Main {
    private static final Logger LOGGER =  LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("APP begin");
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        BookRepository bookRepository = (BookRepository)context.getBean("bookRepository");

        ApplicationService applicationService = (ApplicationService)context.getBean("service");

        try {
            System.out.print(applicationService.getAllBooks());
        }catch (Exception e){
            LOGGER.error("error in getAllBooks mess = {}",e);
        }

        try {
            System.out.print(applicationService.removeBooksWithKNames());
        }catch (Exception e){
            LOGGER.error("error in removeBooksWithKNames mess = {}",e);
        }

        try {
            System.out.print(applicationService.getAllBooks());
        }catch (Exception e){
            LOGGER.error("error in getAllBooks mess = {}",e);
        }

        try {
            System.out.print(applicationService.removeBoksIdNotFibanachi());
        }catch (Exception e){
            LOGGER.error("error in getAllBooks mess = {}",e);
        }
        LOGGER.info("APP end");
    }
}
