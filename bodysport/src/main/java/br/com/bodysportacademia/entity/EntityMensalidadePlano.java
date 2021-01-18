/**
 * @(#) EntityMensalidadePlano.java 1.0 11/01/2021
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
@Table(name = "usuario_aluno_mensalidade_plano")
public class EntityMensalidadePlano {

	public EntityMensalidadePlano() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public Double getValor() {
		return valor;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ModelMensalidadePlano ["
				+ "nome=" + nome 
				+ ", descricao=" + descricao 
				+ ", periodo=" + periodo 
				+ ", valor=" + valor + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plano_id", nullable = false)
	private Integer codigo;
	@Column(name = "nome", nullable = false, length = 150)
	private String nome;
	@Column(name = "descricao", nullable = true, length = 255)
	private String descricao;
	@Column(name = "periodo", nullable = false)
	private Integer periodo;
	@Column(name = "valor", nullable = false)
	private Double valor;
}
