/**
 * @(#) WindowAlunoHandle.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class WindowAlunoHandle {
	
	public WindowAlunoHandle(WindowAluno w_aluno) {
		this.w_aluno = w_aluno;
		this.c_aluno = new WindowAlunoController(w_aluno);
		
		eventButton();
	}
	
	private void eventButton() {
		w_aluno.cancelar.addClickListener(e 
				-> w_aluno.close());
		w_aluno.salvar.addClickListener(e 
				-> c_aluno.salvar());
	}

	private WindowAluno w_aluno;
	private WindowAlunoController c_aluno;
}
