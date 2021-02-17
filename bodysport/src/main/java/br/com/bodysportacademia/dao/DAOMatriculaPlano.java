/**
 * @(#) DAOMatriculaPlano.java 1.0 20/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import java.util.List;

import br.com.bodysportacademia.entity.EntityMatriculaPlano;
/**
 * @version 1.0 20/01/2021
 * @author Pietro do Nascimento
 */
public class DAOMatriculaPlano extends DAO<EntityMatriculaPlano> {

	public int salvar(EntityMatriculaPlano e_plano) {
		if (super.merge(e_plano) != null) {
			return 1;
		}
		return super.persist(e_plano);
	}

	public int excluir(EntityMatriculaPlano e_plano) {
		return super.remove(e_plano);
	}
	
	public List<EntityMatriculaPlano> pesquisarPorNome(String nome) {
		return super.findAll(
				EntityMatriculaPlano.class, 
				"from EntityMatriculaPlano p where p.nome like :nome",
				"nome", nome + "%");
	}

	public List<EntityMatriculaPlano> listarTodos() {
		return super.findAll(EntityMatriculaPlano.class);
	}
}
