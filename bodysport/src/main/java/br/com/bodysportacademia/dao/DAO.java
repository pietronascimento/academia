/**
 * @(#) DAO.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bodysportacademia.util.UtilConnection;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
public class DAO<T> {

	/**
	 */
	public int persist(T entity) {
		EntityManager entityManager = null;
		try {
			entityManager = UtilConnection.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.err.println("DAO: persist -> " + ex);
			return -1;
		}
	}
	
	/**
	 */
	@SuppressWarnings("hiding")
	public <T> T merge(T entity) {
		EntityManager entityManager = null;
		try {
			entityManager = UtilConnection.getEntityManager();
			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.err.println("DAO: merge -> " + ex);
			return null;
		}
	}
	
	/**
	 */
	public int remove(T entity) {
		EntityManager entityManager = null;
		try {
			entityManager = UtilConnection.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.err.println("DAO: delete -> " + ex);
			return -1;
		}
	}
	
	/**
	 */
	@SuppressWarnings("hiding")
	public <T> T findById(Class<T> entity, Long id) {
		try {
			return UtilConnection.getEntityManager().find(entity, id);
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	/**
	 */
	@SuppressWarnings("hiding")
	public <T> T find(
			Class<T> entity, 
			String query, 
			String paramenter1, 
			Object paramenter2) {
		try {
			return UtilConnection.getEntityManager()
				.createQuery(query, entity)
				.setParameter(paramenter1, paramenter2)
				.getSingleResult();
		} catch (NoResultException ex) {
			System.err.println("DAO: find -> " + ex);
			return null;
		}
	}
	
	/**
	 */
	public List<T> findAll(
			Class<T> entity, 
			String query, 
			String paramenter1, 
			Object paramenter2) {
		try {
			return UtilConnection.getEntityManager()
				.createQuery(query, entity)
				.setParameter(paramenter1, paramenter2)
				.getResultList();
		} catch (NoResultException ex) {
			System.err.println("DAO: findAll -> " + ex);
			return new ArrayList<T>();
		}
	}
	
	/**
	 */
	public List<T> findAll(Class<T> entity) {
		try {
			return UtilConnection.getEntityManager()
				.createQuery("from " + entity.getName(), entity)
				.getResultList();
		} catch (NoResultException ex) {
			return new ArrayList<T>();
		}
	}
}
