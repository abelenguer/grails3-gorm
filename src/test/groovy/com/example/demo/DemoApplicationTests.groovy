package com.example.demo

import grails.testing.mixin.integration.Integration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@Integration
@Rollback
class DemoApplicationTests {

	@Test
	void contextLoads() {
		when:
		Book book = new Book(title: "EL proceso").save(flush: true)

		and:
		Book.withSession {it.clear()}

		then:
		Book.findByTitle("EL proceso")
	}

}
