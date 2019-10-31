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

    long saveAuthor() {
        Author author = new Author(name: "Kafka").save(flush: true)
        new Book(author: author, title: "The castle").save(flush: true)
        new Book(author: author, title: "The process").save(flush: true)
        return author.id

    }

    String findByName() {
        Author author = Author.findByName("Kafka")
        logger.info("Is initialized: " + GrailsHibernateUtil.isInitialized(author, "books"))

        author.discard()

        author.books.join(",")
    }

    String findById(Long id) {
        Author author = Author.findById(id)
        logger.info("Is initialized: " + GrailsHibernateUtil.isInitialized(author, "books"))

        author.discard()

        author.books.join(",")
    }

}