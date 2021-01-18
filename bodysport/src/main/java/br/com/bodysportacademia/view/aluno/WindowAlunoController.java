/**
 * @(#) WindowAlunoController.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

import br.com.bodysportacademia.dao.DAOAluno;
import br.com.bodysportacademia.entity.EntityAcesso;
import br.com.bodysportacademia.entity.EntityAluno;
import br.com.bodysportacademia.entity.EntityContato;
import br.com.bodysportacademia.entity.EntityEndereco;
import br.com.bodysportacademia.view.bean.BeanAluno;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class WindowAlunoController {

	public WindowAlunoController(WindowAluno w_aluno) {
		this.w_aluno = w_aluno;
	}

	protected void salvar() {
		BeanAluno b_aluno = w_aluno.getDataPanel();
		if (b_aluno != null) {			
			EntityAluno e_aluno = new EntityAluno();
			e_aluno.setCodigo(b_aluno.getCodigo());
			e_aluno.setCpf(b_aluno.getCpf());
			e_aluno.setNome(b_aluno.getNome());
			e_aluno.setSexo(b_aluno.getSexo().getSelected());
			e_aluno.setDataNascimento(b_aluno.getDataNascimento());
			e_aluno.setFiliacao(b_aluno.getFiliacao());

			EntityAcesso e_acesso = new EntityAcesso();
			e_acesso.setAtivo(true);
			e_acesso.setEmail(b_aluno.getEmail());
			e_acesso.setSenha(b_aluno.getSenha1());
			e_aluno.setAcesso(e_acesso);

			EntityContato e_contato = new EntityContato();
			e_contato.setTelefone(b_aluno.getTelefone());
			e_contato.setCelular(b_aluno.getCelular());
			e_aluno.setContato(e_contato);

			EntityEndereco e_endereco = new EntityEndereco();
			e_endereco.setLogradouro(b_aluno.getLogradouro());
			e_endereco.setComplemento(b_aluno.getComplemento());
			e_endereco.setBairro(b_aluno.getBairro());
			e_endereco.setCidade(b_aluno.getCidade());
			e_endereco.setEstado(b_aluno.getEstado().getSelected());
			e_endereco.setCep(b_aluno.getCep());
			e_aluno.setEndereco(e_endereco);
			
			if (new DAOAluno().salvar(e_aluno) == 1) {
				w_aluno.close();
			} else {
				//Erro ao realizar está operação.....
			}
		}
	}

	private WindowAluno w_aluno;
}
