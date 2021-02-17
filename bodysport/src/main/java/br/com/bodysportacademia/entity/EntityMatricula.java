/**
 * @(#) EntityMatricula.java 1.0 26/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @version 1.0 26/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario_aluno_matricula")
public class EntityMatricula {
	
	public EntityMatricula() {
		this.setCodigo(0);
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public LocalDate getData() {
		return data;
	}
	
	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getDesconto() {
		return desconto;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public EntityAluno getAluno() {
		return aluno;
	}

	public List<EntityMatriculaMensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setAluno(EntityAluno aluno) {
		this.aluno = aluno;
	}

	public void setMensalidades(List<EntityMatriculaMensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	@Override
	public String toString() {
		return "EntityMatricula ["
				+ "date=" + data 
				+ ", diavencimento=" + diaVencimento
				+ ", valor=" + valor 
				+ ", desconto=" + desconto 
				+ ", ativo=" + ativo 
				+ ", aluno=" + aluno
				+ ", mensalidade=" + mensalidades 
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula_id", unique = false)
	private Integer codigo;
	@NotNull(message = "O campo data deve ser preenchido!")
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@NotNull(message = "O campo dia vencimento deve ser preenchido!")
	@Column(name = "diaVencimento", nullable = false)
	private Integer diaVencimento;
	@NotNull(message = "O campo valor deve ser preenchido")
	@Column(name = "valor", nullable = false)
	private Double valor;
	@Column(name = "desconto", nullable = false)
	private Integer desconto;
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@NotNull(message = "O campo aluno deve ser preenchido!")
	@OneToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EntityAluno aluno;		
	@OneToMany(mappedBy = "matricula", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<EntityMatriculaMensalidade> mensalidades;
}
