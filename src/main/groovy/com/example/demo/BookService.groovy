package com.example.demo

import com.sun.org.apache.xpath.internal.operations.Bool
import grails.gorm.services.Service
import org.grails.orm.hibernate.cfg.GrailsHibernateUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
@Service(Book)
@Transactional
public class BookService {

    Logger logger = LoggerFactory.getLogger(BookService.class);

    void save(String title) {
        Author author = Author.findById(1)
        logger.info("Is initialized: " + GrailsHibernateUtil.isInitialized(author, "books"))

        author.discard()

        author.books.each {print(it.title)}
    }

}