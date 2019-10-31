package com.example.demo

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity
import org.grails.datastore.mapping.model.types.OneToMany
import org.hibernate.FetchMode
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

@ToString(includes = "name")
@Entity
class Author implements GormEntity<Author> {
    //@LazyCollection(LazyCollectionOption.FALSE)
    Set<Book> books
    String name

    static hasMany = [
            books : Book
    ]

    static mapping = {
        books lazy: false //, fetch: FetchMode.EAGER
    }
}
