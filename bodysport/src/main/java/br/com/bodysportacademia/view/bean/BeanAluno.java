/**
 * @(#) BeanAluno.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.bean;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class BeanAluno {

	public BeanAluno() {
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

	public ModelSexo getSexo() {
		return sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha1() {
		return senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
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

	public ModelEstado getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
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

	public void setSexo(ModelSexo sexo) {
		this.sexo = sexo;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public void setEstado(ModelEstado estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	private Integer codigo;
	@NotEmpty(message = "O campo cpf deve ser preenchido!")
	private String cpf;
	@NotEmpty(message = "O campo nome deve ser preenchido!")
	private String nome;
	@NotNull(message = "O campo sexo deve ser preenchido!")
	private ModelSexo sexo;
	@NotNull(message = "O campo data nascimento deve ser preenchido!")
	private LocalDate dataNascimento;
	private String filiacao;

	@NotEmpty(message = "O campo email deve ser preenchido!")
	@Email(message = "O email digitado não é valido!")
	private String email;
	@NotEmpty(message = "O campo senha deve ser preenchido!")
	private String senha1;
	@NotEmpty(message = "O campo confirmar senha deve ser preenchido!")
	private String senha2;

	private String telefone;
	@NotEmpty(message = "O campo celular deve ser preenchido!")
	private String celular;

	@NotEmpty(message = "O campo logradouro deve ser preenchido!")
	private String logradouro;
	private String complemento;
	@NotEmpty(message = "O campo bairro deve ser preenchido!")
	private String bairro;
	@NotEmpty(message = "O campo cidade deve ser preenchido!")
	private String cidade;
	@NotNull(message = "O campo uf deve ser preenchido!")
	private ModelEstado estado;
	private String cep;
}
