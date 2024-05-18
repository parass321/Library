package com.self.BookStore;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	public List<Book> findByPrice(Double price);
	
	//calling stored procedure, Native query
	@Query(nativeQuery = true,value = "Call getExpensiveBooks(:price)")
	public List<Book> getBooksWithPriceCondition(@Param("price") Double price);
	
	//JPQL  query 
	@Query("Select b from  Book b where b.bookname =:bk and b.price =:p")
	public List<Book> findByBookNameAndPrice(@Param("bk")String bookname,@Param("p")Double price);

	//Native Query
	@Query(value = "Select * from Book",nativeQuery = true)
	public List<Book> findAllBooks();
	
	//Native Query
	@Query(value = "Select * from Book where Book_Name like 'h%'",nativeQuery = true)
	public List<Book> findBooksByWord(String bookname);
	
	
}