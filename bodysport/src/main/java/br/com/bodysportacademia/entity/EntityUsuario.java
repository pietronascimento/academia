/**
 * @(#) EntityUsuario.java 1.0 11/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @version 1.0 11/01/2021
 * @author Pietro do Nascimento
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class EntityUsuario {
	
	public EntityUsuario() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Integer getSexo() {
		return sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public EntityAcesso getAcesso() {
		return acesso;
	}

	public EntityContato getContato() {
		return contato;
	}

	public EntityEndereco getEndereco() {
		return endereco;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}
	
	public void setAcesso(EntityAcesso acesso) {
		this.acesso = acesso;
	}

	public void setContato(EntityContato contato) {
		this.contato = contato;
	}

	public void setEndereco(EntityEndereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "ModelUsuario ["
				+ "cpf=" + cpf 
				+ ", nome=" + nome 
				+ ", sexo=" + sexo
				+ ", dataNascimento=" + dataNascimento 
				+ ", filiacao=" + filiacao + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id", nullable = false)
	private Integer codigo;
	@Column(name = "cpf", nullable = false, unique = true, length = 14)
	private String cpf;
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	@Column(name = "sexo", nullable = false)
	private Integer sexo;
	@Column(name = "dataNascimento", nullable = false)
	private LocalDate dataNascimento;
	@Column(name = "filiacao", nullable = false)
	private String filiacao;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	EntityAcesso acesso;
	@OneToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	EntityContato contato;
	@OneToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)	
	EntityEndereco endereco;
}
