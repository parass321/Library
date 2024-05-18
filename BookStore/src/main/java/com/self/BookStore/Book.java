package com.self.BookStore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "book")
@ApiModel(value = "This is Book Model")
public class Book implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes = "This is book Id",required = true,value = "12")
	@Column(name="Book_Id")
	private int bookid;
	
	@Column(name="Book_Name")
	@ApiModelProperty(notes = "This is BookName",required = true,value = "HarryPotter")
	private String bookname;
	
	
	@Column(name="Book_Price")
	@ApiModelProperty(notes = "This is Book Price",required = true,value = "500.00")
	private double price;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookid, String bookname, double price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", price=" + price + "]";
	}
	
		
}
