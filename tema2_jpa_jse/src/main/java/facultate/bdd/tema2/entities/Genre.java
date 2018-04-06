package facultate.bdd.tema2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/** TODO: Transform this class into a JPA entity **/
public class Genre {
	
	//properties
	private Integer id;
	private String name;
	
	private List<Book> books = new ArrayList<Book>(); //LAZY
	
	//constructors
	public Genre() {}
	
	public Genre(String name) {
		this.name = name;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
