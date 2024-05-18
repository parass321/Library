package com.self.BookStore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

	
	@ApiOperation(value = "fetch All Books",response = Iterable.class)
	@GetMapping("/getbooks")
	public List<Book> GetBook()
	{
		System.out.println("Htting controller");
		return bookservice.fetchbooks();
	}
	
	@ApiOperation(value = "fetch All Books by Price",response = Iterable.class)
	@GetMapping("/price/{price}")
	public List<Book> getBookByPrice(@PathVariable Double price){
		return bookservice.fetchByPrice(price);
		
	}

	@ApiOperation(value = "fetch All Books by id",response = Iterable.class)
	@GetMapping("/getbookbyid/{id}")
	public Optional<Book> getBookById(@PathVariable int id)
	{
		return bookservice.fetchbook(id);
	}
	
	@ApiOperation(value = "Delete All Books by Id",response = Iterable.class)
	@DeleteMapping("/deletebook/{id}")
	public String DeleteBookbyid(@PathVariable int id)
	{
		return bookservice.deleteBook(id);
	}
	
	
	@ApiOperation(value = "Insert All Books")
	@PostMapping("/savebook")
	public String SaveBook(@RequestBody Book book)
	{
		return bookservice.saveBook(book);
	}
		
	@ApiOperation(value = "fetch All Books",response = Iterable.class)
	@PutMapping("/updatebookprice")
	public Book UpdateBook(@RequestBody Book book)
	{
		return bookservice.updateBook(book);
	}
	
	@GetMapping("/bookNameAndprice/{bookname}/{price}")
	public List<Book> getBookNameAndPrice(@PathVariable("bookname")String bookname, @PathVariable("price")Double price)
	{
		return bookservice.getBookNameAndPrice(bookname, price);
	}
	
	@GetMapping("/getBookByWord/{bookname}")
	public List<Book> getBooksByWord(@PathVariable("bookname")String bookname)
	{
		return bookservice.findBookByWord(bookname);
	}
	
	@GetMapping("/getBooksBySubName/{str}/")
	public List<Book> getBookBySubName(@PathVariable String str)
	{
		return bookservice.getBooksByName(str);
	}
	
	@GetMapping("/getPriceList")
	public List<Double> getPriceList()
	{
		return bookservice.getPriceList();
	}
	
	@GetMapping("/getSum")
	public double getSum()
	{
		return bookservice.getSum();
	}
	
	@GetMapping("/getExpensiveBook/{price}/")
	public List<Book> getBooksWithPriceCondition(@PathVariable double price)
	{
		return bookservice.getBooksWithPriceCondition(price);
	}
	
}
