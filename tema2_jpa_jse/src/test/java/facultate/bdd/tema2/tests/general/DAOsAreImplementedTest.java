package facultate.bdd.tema2.tests.general;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Test;

import facultate.bdd.tema2.dao.interfaces.BookDAO;
import facultate.bdd.tema2.dao.interfaces.BuyerDAO;
import facultate.bdd.tema2.dao.interfaces.GenreDAO;
import facultate.bdd.tema2.dao.interfaces.OrderDAO;
import facultate.bdd.tema2.dao.interfaces.OrderEntryDAO;
import facultate.bdd.tema2.util.EntityDAOImplFactory;

public class DAOsAreImplementedTest {
	
	private static final String PERSISTANCE_UNIT_NAME = "bookstore";
	
	private static BookDAO bookDAO = EntityDAOImplFactory.createNewBookDAOImpl(PERSISTANCE_UNIT_NAME);
	private static BuyerDAO buyerDAO = EntityDAOImplFactory.createNewBuyerDAOImpl(PERSISTANCE_UNIT_NAME);
	private static GenreDAO genreDAO = EntityDAOImplFactory.createNewGenreDAOImpl(PERSISTANCE_UNIT_NAME);
	private static OrderDAO orderDAO = EntityDAOImplFactory.createNewOrderDAOImpl(PERSISTANCE_UNIT_NAME);
	private static OrderEntryDAO orderEntryDAO = EntityDAOImplFactory.createNewOrderEntryDAOImpl(PERSISTANCE_UNIT_NAME);

	@Test
	public void bookDAOImplTest() {
		assertNotNull(bookDAO);
	}

	@Test
	public void buyerDAOImplTest() {
		assertNotNull(buyerDAO);
	}

	@Test
	public void genreDAOImplTest() {
		assertNotNull(genreDAO);
	}

	@Test
	public void orderDAOImplTest() {
		assertNotNull(orderDAO);
	}

	@Test
	public void orderEntryDAOImplTest() {
		assertNotNull(orderEntryDAO);
	}
	
	@AfterClass
	public static void cleanup() {
		if (bookDAO != null) bookDAO.close();
		if (buyerDAO != null) buyerDAO.close();
		if (genreDAO != null) genreDAO.close();
		if (orderDAO != null) orderDAO.close();
		if (orderEntryDAO != null) orderEntryDAO.close();
	}

}
