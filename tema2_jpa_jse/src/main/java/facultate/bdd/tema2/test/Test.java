package facultate.bdd.tema2.test;

import facultate.bdd.tema2.dao.impl.OrderDAOImpl;
import facultate.bdd.tema2.dao.interfaces.OrderDAO;
import facultate.bdd.tema2.entities.Order;

public class Test {

	public static void main(String[] args) {
		OrderDAO o = new OrderDAOImpl("bookstore");
		o.deleteAll();
		o.createOrUpdate(new Order());
		o.deleteAll();
	}
}