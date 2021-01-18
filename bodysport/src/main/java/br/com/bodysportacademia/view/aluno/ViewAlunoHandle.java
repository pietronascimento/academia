/**
 * @(#) ViewAlunoHandle.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class ViewAlunoHandle {

	public ViewAlunoHandle(ViewAluno w_aluno) {
		this.w_aluno = w_aluno;
		this.c_aluno = new ViewAlunoController(w_aluno);
		
		eventField();
		eventButton();
	}
	
	private void eventField() {
		w_aluno.cpf.addValueChangeListener(e 
				-> c_aluno.pesquisarPorCpf(e.getValue()));
		w_aluno.nome.addValueChangeListener(e 
				-> c_aluno.pesquisarPorNome(e.getValue()));
	}
	
	private void eventButton() {
		w_aluno.cadastrar.addClickListener(e 
				-> c_aluno.showWindow());
	}
	
	private ViewAluno w_aluno;
	private ViewAlunoController c_aluno;
}
