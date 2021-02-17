/**
 * @(#) EntityFuncionario.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "usuario_funcionario")
public class EntityFuncionario extends EntityUsuario {

	public EntityFuncionario() {
		setAcesso(new EntityAcesso());
		setContato(new EntityContato());
		setEndereco(new EntityEndereco());
	}
}
