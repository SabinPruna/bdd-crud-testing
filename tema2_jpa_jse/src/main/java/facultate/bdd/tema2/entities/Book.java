package facultate.bdd.tema2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/** TODO: Transform this class into a JPA entity **/
public class Book {
	
	//properties
	private Integer id;
	private String name;
	private String author;
	
	private List<Genre> genres = new ArrayList<Genre>(); //EAGER
	
	private Double price;
		
	//constructors
	public Book() {}
	
	public Book(String name, String author, Double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}
