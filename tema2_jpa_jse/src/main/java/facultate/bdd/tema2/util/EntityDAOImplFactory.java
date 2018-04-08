package facultate.bdd.tema2.util;

import facultate.bdd.tema2.dao.impl.BookDAOImpl;
import facultate.bdd.tema2.dao.impl.BuyerDAOImpl;
import facultate.bdd.tema2.dao.impl.GenreDAOImpl;
import facultate.bdd.tema2.dao.impl.OrderDAOImpl;
import facultate.bdd.tema2.dao.impl.OrderEntryDAOImpl;
import facultate.bdd.tema2.dao.interfaces.BookDAO;
import facultate.bdd.tema2.dao.interfaces.BuyerDAO;
import facultate.bdd.tema2.dao.interfaces.GenreDAO;
import facultate.bdd.tema2.dao.interfaces.OrderDAO;
import facultate.bdd.tema2.dao.interfaces.OrderEntryDAO;

public class EntityDAOImplFactory {
	
	public static BookDAO createNewBookDAOImpl(String persistenceUnitName) {
		return new BookDAOImpl(persistenceUnitName);
	}
	
	public static BuyerDAO createNewBuyerDAOImpl(String persistenceUnitName) {
		return new BuyerDAOImpl(persistenceUnitName);
	}
	
	public static GenreDAO createNewGenreDAOImpl(String persistenceUnitName) {
		return new GenreDAOImpl(persistenceUnitName);
	}
	
	public static OrderDAO createNewOrderDAOImpl(String persistenceUnitName) {
		return new OrderDAOImpl(persistenceUnitName);
	}
	
	public static OrderEntryDAO createNewOrderEntryDAOImpl(String persistenceUnitName) {
		return new OrderEntryDAOImpl(persistenceUnitName);
	}
}