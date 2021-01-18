/**
 * @(#) EntityProfessor.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
@Table(name = "usuario_professor")
public class EntityProfessor extends EntityUsuario {

	public EntityProfessor() {
	}
}
