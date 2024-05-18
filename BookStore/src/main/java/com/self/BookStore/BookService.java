package com.self.BookStore;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepo bookrepo;
	
	public List<Book> fetchbooks(){
	   List<Book> book = bookrepo.findAll();
	   
	   System.out.println("Data coming from mocikto : " + book);
	   if(book.isEmpty()) {
		   throw new EmptyBookStoreException("401", "Book not found");
	   }
		
		return bookrepo.findAll();
	}
	
	
	
	public List<Book> fetchByPrice(Double price){
		return bookrepo.findByPrice(price);
	}
	
	
	public String saveBook(Book book)
	{
		bookrepo.save(book);
		return "book saved with id "+"book.getBookid()";
	}
	
	public Optional<Book> fetchbook(int id){
		
		if(bookrepo.findById(id).isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return bookrepo.findById(id);
	}
	
	public String deleteBook(int id)
	{
		bookrepo.deleteById(id);
		return "Book with id="+id+"is deleted successfully";
	}
	
	public Book updateBook(Book book)
	{
	return bookrepo.save(book);
	}
	
//JPQL Query
	
	public List<Book> getBookNameAndPrice(String bookname, double price){
	
		return bookrepo.findByBookNameAndPrice(bookname, price);
	}
	
	public List<Book> findBookByWord(String bookname)
	{
		return bookrepo.findBooksByWord(bookname);
	}
	
	public List<Book> getBooksByName(String bookname)
	{
		List<Book> book= this.fetchbooks();
		List<Book> ans=book.stream().filter(b -> b.getBookname().contains(bookname)).collect(Collectors.toList());
		return ans;
	}
	
	public List<Double> getPriceList()
	{
		List<Book> book= this.fetchbooks();
		List<Double> ans=book.stream().map(b -> b.getPrice()).collect(Collectors.toList());
		return ans;
	}
	
	public double getSum()
	{
		List<Book> book= this.fetchbooks();
		double sum = book.stream().mapToDouble(b -> b.getPrice()).sum();
//		double ans2 = book.stream().map(b -> b.getPrice()).reduce(identity, accumulator);
		return sum;
	}
	
	public List<Book> getBooksWithPriceCondition(double price)
	{
		return bookrepo.getBooksWithPriceCondition(price);
	}

}
