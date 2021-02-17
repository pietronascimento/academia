/**
 * @(#) DAOAcesso.java 1.0 11/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import javax.persistence.NoResultException;

import br.com.bodysportacademia.entity.EntityAcesso;
import br.com.bodysportacademia.util.UtilConnection;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
public class DAOAcesso extends DAO<EntityAcesso> {
	
	public DAOAcesso() {
	}
	
	public EntityAcesso doLogin(String username, String password) {
		try {
			return UtilConnection.getEntityManager()
				.createQuery(
						"from EntityAcesso a "
						+ "where a.email=:username "
						+ "and a.senha=:password", 
						EntityAcesso.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
		} catch (NoResultException ex) {
			System.err.println("DAOAcesso: doLogin -> " + ex);
			return null;
		}
	}
}
