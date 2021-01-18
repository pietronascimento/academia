/**
 * @(#) UtilConnection.java 1.0 12/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @version 1.0 12/01/2021
 * @author Pietro do Nascimento
 */
public class UtilConnection implements Serializable {
	private static final long serialVersionUID = 3341909323556215885L;

	private static EntityManager buildManagerFactory() {
		return Persistence
				.createEntityManagerFactory("bodysport_database")
				.createEntityManager();		
	}
	
    public static EntityManager getEntityManager() {
        return entityManager;
    }
    
    private static final EntityManager entityManager = buildManagerFactory();
}
