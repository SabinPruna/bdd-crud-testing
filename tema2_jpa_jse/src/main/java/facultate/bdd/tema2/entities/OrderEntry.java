package facultate.bdd.tema2.entities;

import javax.persistence.Entity;

/** TODO: Transform this class into a JPA entity **/
public class OrderEntry {
	//properties
	private int id;
	private Order order; //LAZY
	private Book book; //EAGER
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
