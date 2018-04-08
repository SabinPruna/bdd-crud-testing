package facultate.bdd.tema2.entities;

import javax.persistence.*;

@Entity
@Table(name="\"OrderEntries\"")
public class OrderEntry {
	//properties
	@Id
	@GeneratedValue
	@Column(name="\"id\"")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Order order; //LAZY
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Book book; //EAGER
	
	@Column(name="\"quantity\"")
	private Integer quantity;
	
	//constructors
	public OrderEntry() {
		super();
	}
	
	public OrderEntry(Order order, Book book) {
		this.order = order;
		this.book = book;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	

	
}
