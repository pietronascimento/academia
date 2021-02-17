/**
 * @(#) EntityMatriculaMensalidade.java 1.0 26/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @version 1.0 26/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario_aluno_matricula_mensalidade")
public class EntityMatriculaMensalidade {

	public EntityMatriculaMensalidade() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public Boolean getPaga() {
		return paga;
	}
	
	public EntityMatriculaPlano getPlano() {
		return plano;
	}
	
	public EntityMatricula getMatricula() {
		return matricula;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	public void setPlano(EntityMatriculaPlano plano) {
		this.plano = plano;
	}

	public void setMatricula(EntityMatricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "EntityMatriculaMensalidade ["
				+ "dataVencimento=" + dataVencimento 
				+ ", dataPagamento=" + dataPagamento 
				+ ", paga=" + paga 
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mensalidade_id", nullable = false)
	private Integer codigo;
	@NotNull(message = "O campo data vencimento deve ser preenchido!")
	@Column(name = "dataVencimento", nullable = false)
	private LocalDate dataVencimento;
	@Column(name = "dataPagamento")
	private LocalDate dataPagamento;
	@Column(name = "paga", nullable = false)
	private Boolean paga;	
	
	@NotNull(message = "O campo plano deve ser preenchido!")
	@OneToOne(fetch = FetchType.EAGER)
	private EntityMatriculaPlano plano;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matricula_id")
	private EntityMatricula matricula;
}
