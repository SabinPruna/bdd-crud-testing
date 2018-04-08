package facultate.bdd.tema2.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="\"Buyers\"")
public class Buyer {

	@Id
	@GeneratedValue
	@Column(name="\"id\"")
	private Integer id;
	
	@Column(name="\"name\"")
	private String name;
	
	@Column(name="\"age\"")
	private Integer age;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, 
	        mappedBy = "buyer", orphanRemoval = true)
	private List<Order> orders = new ArrayList<Order>(); // EAGER

	// constructors
	public Buyer() {
	}

	public Buyer(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	// getters and setters
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	
	
}
