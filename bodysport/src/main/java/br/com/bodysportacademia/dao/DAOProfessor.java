/**
 * @(#) DAOProfessor.java 1.0 12/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import java.util.List;

import br.com.bodysportacademia.entity.EntityProfessor;

/**
 * @version 1.0 12/02/2021
 * @author Pietro do Nascimento
 */
public class DAOProfessor  extends DAO<EntityProfessor> {

	public int salvar(EntityProfessor e_professor) {
		if (super.merge(e_professor) != null) {
			return 1;
		}
		return super.persist(e_professor);
	}

	public int excluir(EntityProfessor e_professor) {
		return super.remove(e_professor);
	}
	
	public EntityProfessor pesquisarPorCpf(String cpf) {
		return super.find(
				EntityProfessor.class, 
				"from EntityProfessor p where p.cpf = :cpf", 
				"cpf", cpf);		
	}

	public List<EntityProfessor> pesquisarPorNome(String nome) {
		return super.findAll(
				EntityProfessor.class, 
				"from EntityProfessor p where p.nome like :nome",
				"nome", nome + "%");
	}

	public List<EntityProfessor> listarTodos() {
		return super.findAll(EntityProfessor.class);
	}
}
