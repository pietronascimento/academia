/**
 * @(#) DAOFuncionario.java 1.0 12/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import java.util.List;

import br.com.bodysportacademia.entity.EntityFuncionario;

/**
 * @version 1.0 12/02/2021
 * @author Pietro do Nascimento
 */
public class DAOFuncionario extends DAO<EntityFuncionario> {

	public int salvar(EntityFuncionario e_funcionario) {
		if (super.merge(e_funcionario) != null) {
			return 1;
		}
		return super.persist(e_funcionario);
	}

	public int excluir(EntityFuncionario e_funcionario) {
		return super.remove(e_funcionario);
	}
	
	public EntityFuncionario pesquisarPorCpf(String cpf) {
		return super.find(
				EntityFuncionario.class, 
				"from EntityFuncionario f where f.cpf = :cpf", 
				"cpf", cpf);		
	}

	public List<EntityFuncionario> pesquisarPorNome(String nome) {
		return super.findAll(
				EntityFuncionario.class, 
				"from EntityFuncionario f where f.nome like :nome",
				"nome", nome + "%");
	}

	public List<EntityFuncionario> listarTodos() {
		return super.findAll(EntityFuncionario.class);
	}
}
