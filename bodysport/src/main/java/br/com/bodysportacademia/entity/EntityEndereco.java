/**
 * @(#) EntityEndereco.java 1.0 11/01/2021
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
@Table(name = "usuario_endereco")
public class EntityEndereco {

	public EntityEndereco() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "ModelEndereco ["
				+ "logradouro=" + logradouro 
				+ ", complemento=" + complemento 
				+ ", bairro=" + bairro
				+ ", cidade=" + cidade 
				+ ", estado=" + estado 
				+ ", cep=" + cep + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id", nullable = false)
	private Integer codigo;
	@Column(name = "logradouro", nullable = false, length = 255)
	private String logradouro;
	@Column(name = "complemento", nullable = true, length = 255)
	private String complemento;
	@Column(name = "bairro", nullable = false, length = 255)
	private String bairro;
	@Column(name = "cidade", nullable = false, length = 150)
	private String cidade;
	@Column(name = "estado", nullable = false, length = 2)
	private String estado;
	@Column(name = "cep", nullable = true, length = 10)
	private String cep;
}
