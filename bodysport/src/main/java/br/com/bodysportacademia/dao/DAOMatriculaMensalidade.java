/**
 * @(#) DAOMatriculaMensalidade.java 1.0 20/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.bodysportacademia.entity.EntityMatriculaMensalidade;

/**
 * @version 1.0 20/01/2021
 * @author Pietro do Nascimento
 */
public class DAOMatriculaMensalidade extends DAO<EntityMatriculaMensalidade> {
	
	public DAOMatriculaMensalidade() {
	}
	
	public EntityMatriculaMensalidade pesquisarPorCpf(String cpf) {
		return super.find(EntityMatriculaMensalidade.class,
				"from EntityMatriculaMensalidade m " 
				+ "where m.matricula.aluno.cpf = :cpf",
				"cpf", cpf);
	}

	public List<EntityMatriculaMensalidade> pesquisarPorNome(String nome) {
		return super.findAll(EntityMatriculaMensalidade.class, 
				"from EntityMatriculaMensalidade m " 
				+ "where m.matricula.aluno.nome like :nome",
				"nome", nome + "%");
	}
	
	public List<EntityMatriculaMensalidade> listarMensalidadesNaoPagas() {
		return super.findAll(
				EntityMatriculaMensalidade.class, 
				"from EntityMatriculaMensalidade m "
				+ "where m.dataVencimento between '" 
				+ LocalDate.of(
						LocalDate.now().getYear(), 
						LocalDate.now().getMonthValue(), 1) 
				+ "' and '" 
				+ LocalDate.of(
						LocalDate.now().getYear(), 
						LocalDate.now().getMonthValue(), 
						LocalDate.now().lengthOfMonth()) 
				+ "' and m.paga = false");
	}
}
