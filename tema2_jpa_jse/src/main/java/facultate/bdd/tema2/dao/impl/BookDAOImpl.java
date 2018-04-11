package facultate.bdd.tema2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import facultate.bdd.tema2.entities.Book;

public class BookDAOImpl implements facultate.bdd.tema2.dao.interfaces.BookDAO {
	public EntityManagerFactory emFactory;
	public EntityManager entityManager;

	public BookDAOImpl(String persistenceUnitName) {
		emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	@Override
	public void close() {
		emFactory.close();
	}

	@Override
	public Book createOrUpdate(Book entity) {
		
		  try {
	            entityManager = emFactory.createEntityManager();
	            try {
	                entityManager.getTransaction().begin();
	                entityManager.persist(entity);
	                entityManager.getTransaction().commit();
	            } catch(Exception ex) {
	                entityManager.getTransaction().rollback();
	                entityManager.getTransaction().begin();
	                entity = entityManager.merge(entity);
	                entityManager.getTransaction().commit();
	            }
	            return entity;
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	            entityManager.getTransaction().rollback();
	            return null;
	        } finally {
	            entityManager.close();
	        }
	}
	
		/*try {
			entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();

			entityManager.persist(entity);

			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();

			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return null;
		} finally {
			entityManager.close();
		}
	}
*/
	@Override
	public Book findById(int id) {
		try {
			entityManager = emFactory.createEntityManager();
			return entityManager.find(Book.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Book update(Book entity) {
		try {
			entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();

			entityManager.merge(entity);

			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Book entity) {
		try {
			entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();

			entity = entityManager.find(Book.class, entity.getId());
			entityManager.remove(entity);

			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void deleteAll() {
		try {
			for (Book book : readAll()) {
				delete(book);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public List<Book> readAll() {
		try {
			entityManager = emFactory.createEntityManager();

			return entityManager.createQuery("from Book", Book.class).getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}

}
