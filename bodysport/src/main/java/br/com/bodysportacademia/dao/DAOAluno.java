/**
 * @(#) DAOAluno.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.dao;

import java.util.List;

import br.com.bodysportacademia.entity.EntityAluno;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
public class DAOAluno extends DAO<EntityAluno> {
	
	public int salvar(EntityAluno e_aluno) {
		if (super.merge(e_aluno) != null) {
			return 1;
		}
		return super.persist(e_aluno);
	}

	public int excluir(EntityAluno e_aluno) {
		return super.remove(e_aluno);
	}

	public EntityAluno pesquisarPorCpf(String cpf) {
		return super.find(
				EntityAluno.class, 
				"from EntityAluno a where a.cpf = :cpf", 
				"cpf", cpf);		
	}

	public List<EntityAluno> pesquisarPorNome(String nome) {
		return super.findAll(
				EntityAluno.class, 
				"from EntityAluno a where a.nome like :nome",
				"nome", nome + "%");
	}

	public List<EntityAluno> listarTodos() {
		return super.findAll(EntityAluno.class);
	}
}
