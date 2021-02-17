/**
 * @(#) EntityAcesso.java 1.0 11/01/2021
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario_acesso")
public class EntityAcesso {

	public EntityAcesso() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 */
	@Override
	public String toString() {
		return "ModelAcesso ["
				+ "email=" + email 
				+ ", senha=" + senha 
				+ ", ativo=" + ativo + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acesso_id", nullable = false)
	private Integer codigo;
	@Email(message = "E-Mail inválido!")
	@NotEmpty(message = "O Campo EMail deve ser preenchido!")
	@Column(name = "email", nullable = false, length = 150)
	private String email;
	@NotEmpty(message = "O Campo Senha deve ser preenchido!")
	@Column(name = "senha", nullable = false, length = 8)
	private String senha;
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
}
