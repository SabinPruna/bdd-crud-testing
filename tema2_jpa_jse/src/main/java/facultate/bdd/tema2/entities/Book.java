package facultate.bdd.tema2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="\"Books\"")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="\"id\"")
	private Integer id;
	
	@Column(name="\"name\"")
	private String name;
	
	@Column(name="\"author\"")
	private String author;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = 
        {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_genre",
        joinColumns = {
            @JoinColumn(
                name = "book_id", 
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "genre_id", 
                referencedColumnName = "id"
            )
        })
	@Column(name="\"genres\"")
	private List<Genre> genres = new ArrayList<Genre>(); //EAGER
	
	@Column(name="\"price\"")
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
