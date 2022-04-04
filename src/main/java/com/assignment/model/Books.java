package com.assignment.model;

import javax.persistence.*;

@Entity
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="book_author")
	private String author;
	
	@Column
	private String Category;
	
	public Books(int id, String name, String author, String category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		Category = category;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", Category=" + Category + "]";
	}

}
