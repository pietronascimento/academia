/**
 * @(#) EntityContato.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario_contato")
public class EntityContato {

	public EntityContato() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "ModelContato ["
				+ "telefone=" + telefone 
				+ ", celular=" + celular + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contato_id")
	private Integer codigo;
	@Column(name = "telefone", nullable = true, length = 14)
	private String telefone;
	@Column(name = "celular", nullable = false, length = 15) // (28) 99886-9655
	private String celular;
}
