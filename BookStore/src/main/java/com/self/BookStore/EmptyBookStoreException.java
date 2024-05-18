package com.self.BookStore;

public class EmptyBookStoreException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String message;
	
	
	public EmptyBookStoreException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmptyBookStoreException(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
}
