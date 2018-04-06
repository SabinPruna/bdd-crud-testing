package facultate.bdd.tema2.entities;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** TODO: Transform this class into a JPA entity **/
public class Order {
	
	//properties
	private Integer id;
	private Date date;
	private Buyer buyer; //EAGER
	private List<OrderEntry> orderEntries = new ArrayList<OrderEntry>(); //EAGER
	
	//constructors
	public Order() {}

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	public void setOrderEntries(List<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}
	
	
	
	
}
