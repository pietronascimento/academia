/**
 * @(#) ViewAlunoController.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

import com.vaadin.ui.UI;

import br.com.bodysportacademia.dao.DAOAluno;
import br.com.bodysportacademia.entity.EntityAluno;
import br.com.bodysportacademia.view.bean.BeanAluno;
import br.com.bodysportacademia.view.bean.ModelEstado;
import br.com.bodysportacademia.view.bean.ModelSexo;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class ViewAlunoController {

	public ViewAlunoController(ViewAluno w_aluno) {
		this.w_aluno = w_aluno;
	}

	protected void pesquisarPorCpf(String str) {
		w_aluno.g_layout.removeAll();
		EntityAluno e_aluno = new DAOAluno().pesquisarPorCpf(str);
		if (e_aluno != null) {
			w_aluno.g_layout.addItem(getAluno(e_aluno));
		}
	}

	protected void pesquisarPorNome(String str) {
		w_aluno.g_layout.removeAll();
		new DAOAluno().pesquisarPorNome(str)
			.forEach(e_aluno -> w_aluno.g_layout.addItem(getAluno(e_aluno)));
	}

	protected void listarTodos() {
		w_aluno.g_layout.removeAll();
		new DAOAluno().listarTodos()
			.forEach(e_aluno -> w_aluno.g_layout.addItem(getAluno(e_aluno)));
	}
	
	protected void showWindow() {
		WindowAluno w_aluno = new WindowAluno();
		w_aluno.setDataPanel(new BeanAluno());
		UI.getCurrent().addWindow(w_aluno);
	}

	private BeanAluno getAluno(EntityAluno e_aluno) {
		BeanAluno b_aluno = new BeanAluno();
		b_aluno.setCodigo(e_aluno.getCodigo());
		b_aluno.setCpf(e_aluno.getCpf());
		b_aluno.setNome(e_aluno.getNome());
		b_aluno.setSexo(e_aluno.getSexo() == 1 ? ModelSexo.Masculino : ModelSexo.Feminino);
		b_aluno.setDataNascimento(e_aluno.getDataNascimento());
		b_aluno.setFiliacao(e_aluno.getFiliacao());
		b_aluno.setEmail(e_aluno.getAcesso().getEmail());
		b_aluno.setSenha1(e_aluno.getAcesso().getSenha());
		b_aluno.setTelefone(e_aluno.getContato().getTelefone());
		b_aluno.setCelular(e_aluno.getContato().getCelular());
		b_aluno.setLogradouro(e_aluno.getEndereco().getLogradouro());
		b_aluno.setComplemento(e_aluno.getEndereco().getComplemento());
		b_aluno.setBairro(e_aluno.getEndereco().getBairro());
		b_aluno.setCidade(e_aluno.getEndereco().getCidade());
		b_aluno.setEstado(ModelEstado.valueOf(e_aluno.getEndereco().getEstado()));
		b_aluno.setCep(e_aluno.getEndereco().getCep());
		return b_aluno;
	}

	private ViewAluno w_aluno;
}
