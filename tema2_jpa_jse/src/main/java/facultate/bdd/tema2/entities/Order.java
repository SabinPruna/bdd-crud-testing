package facultate.bdd.tema2.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="\"Orders\"")
public class Order {
	
	//properties
	@Id
	@GeneratedValue
	@Column(name="\"id\"")
	private Integer id;
	
	@Column(name="\"date\"")
	private Date date;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="\"buyer_id\"")
	private Buyer buyer; //EAGER
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, 
	        mappedBy = "order", orphanRemoval = true)
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