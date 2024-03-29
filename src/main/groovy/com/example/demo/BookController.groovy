package com.example.demo

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
class BookController {

    @Autowired
    BookService bookService

    @RequestMapping
    String index() {
        Long authorId  = bookService.saveAuthor()
        bookService.findById(authorId)
        //bookService.findByName()
    }


}
