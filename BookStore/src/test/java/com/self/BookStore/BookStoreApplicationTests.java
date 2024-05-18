package com.self.BookStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class BookStoreApplicationTests {

	@Autowired
	private BookService bookservice;
	
	
	@MockBean
	private BookRepo bookRepo;
	
    
	@Test
	public void getAllBookDetails() {
		when(bookRepo.findAll());
		assertEquals(1,bookservice.fetchbooks().size());
	}

}
