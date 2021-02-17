/**
 * @(#) DAOMatricula.java 1.0 20/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bodysportacademia.entity.EntityMatricula;
import br.com.bodysportacademia.entity.EntityMatriculaMensalidade;
import br.com.bodysportacademia.util.UtilConnection;

/**
 * @version 1.0 20/01/2021
 * @author Pietro do Nascimento
 */
public class DAOMatricula extends DAO<EntityMatricula> {
	
	public DAOMatricula() {
	}

	public int salve(EntityMatricula e_matricula) {
		if(e_matricula.getCodigo() > 0) {
			return merge(e_matricula) != null ? 1 : -1;
		}
		return persist(e_matricula);
	}
	
	public int persist(EntityMatricula e_matricula) {
		EntityManager entityManager = null;
		try {
			entityManager = UtilConnection.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(e_matricula);
			for (EntityMatriculaMensalidade e_mensalidade : e_matricula.getMensalidades()) {
				e_mensalidade.setMatricula(e_matricula);
				entityManager.persist(e_mensalidade);
			}
			entityManager.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
			System.err.println("DAOMatricula -> persist: " + ex);
			return -1;
		}
	}
	
	public EntityMatricula merge(EntityMatricula e_matricula) {
		EntityManager entityManager = null;
		try {	
			if (delete(e_matricula) == -1) {
				return null;
			}
			e_matricula.setCodigo(0);
			entityManager = UtilConnection.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(e_matricula);
			entityManager.refresh(e_matricula);
			for (EntityMatriculaMensalidade e_mensalidade : e_matricula.getMensalidades()) {
				e_mensalidade.setMatricula(e_matricula);
				entityManager.persist(e_mensalidade);
			}
			entityManager.getTransaction().commit();
			return e_matricula;
		} catch (Exception ex) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
			System.err.println("DAOMatricula -> merge: " + ex);
			return null;
		}
	}

	public int delete(EntityMatricula e_matricula) {
		return super.remove(e_matricula);
	}

	public EntityMatricula pesquisarPorCpf(String cpf) {
		return super.find(EntityMatricula.class,
				"from EntityMatricula m " 
				+ "where m.aluno.cpf = :cpf",
				"cpf", cpf);
	}

	public List<EntityMatricula> pesquisarPorNome(String nome) {
		return super.findAll(EntityMatricula.class, 
				"from EntityMatricula m " 
				+ "where m.aluno.nome like :nome",
				"nome", nome + "%");
	}

	public List<EntityMatricula> listarTodos() {
		return super.findAll(EntityMatricula.class);
	}
}
