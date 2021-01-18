/**
 * @(#) ModelMensalidade.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario_aluno_mensalidade")
public class EntityMensalidade {

	public EntityMensalidade() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public EntityMensalidadePlano getPlano() {
		return plano;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setPlano(EntityMensalidadePlano plano) {
		this.plano = plano;
	}

	@Override
	public String toString() {
		return "ModelMensalidade ["
				+ "dataVencimento=" + dataVencimento 
				+ ", ativo=" + ativo 
				+ ", plano=" + plano + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mensalidade_id", nullable = false)
	private Integer codigo;
	@Column(name = "dataVencimento", nullable = false)
	private LocalDate dataVencimento;
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@OneToOne
	private EntityMensalidadePlano plano;
}
