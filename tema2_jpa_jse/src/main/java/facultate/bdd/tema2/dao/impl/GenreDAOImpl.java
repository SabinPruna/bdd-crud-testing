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
import facultate.bdd.tema2.entities.Genre;

public class GenreDAOImpl implements facultate.bdd.tema2.dao.interfaces.GenreDAO {
	public EntityManagerFactory emFactory;
	public EntityManager entityManager;

	public GenreDAOImpl(String persistenceUnitName) {
		emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	
	@Override
	public void close() {
		emFactory.close();
	}

	@Override
	public Genre createOrUpdate(Genre entity) {
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

	@Override
	public Genre findById(int id) {
		try {
			entityManager = emFactory.createEntityManager();
			return entityManager.find(Genre.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Genre update(Genre entity) {
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
	public void delete(Genre entity) {
		try {
			entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entity=entityManager.find(Genre.class, entity.getId());
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
			for(Genre g: readAll()) {
				delete(g);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public List<Genre> readAll() {
		try {
			entityManager = emFactory.createEntityManager();
			return entityManager.createQuery("from Genre", Genre.class).getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}

}
