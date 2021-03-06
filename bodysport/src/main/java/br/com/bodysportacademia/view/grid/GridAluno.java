/**
 * @(#) GridAluno.java 1.0 12/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.view.grid;

import java.util.ArrayList;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.entity.EntityAluno;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowAluno;

/**
 * @version 1.0 12/01/2021
 * @author Pietro do Nascimento
 */
public class GridAluno extends UIGrid<EntityAluno> {
	private static final long serialVersionUID = -4513471891422149695L;

	public GridAluno() {
		super.setItems(new ArrayList<EntityAluno>());		
		super.addColumn(a -> a.getCpf())
			.setCaption("CPF")
			.setWidth(120);			
		super.addColumn(a -> a.getNome())
			.setCaption("Nome")
			.setExpandRatio(1);	
		super.addColumn(a -> a.getContato().getCelular())
			.setCaption("Celular")
			.setWidth(120);	
		super.addComponentColumn(a -> showWindow(a))
			.setWidth(50);
	}
	
	public boolean exists(EntityAluno e_aluno) {
		for (EntityAluno a : super.getItems()) {
			if (a.getCpf().equals(e_aluno.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	private Button showWindow(EntityAluno e_aluno) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(e_aluno));		
		return button;
	}
	
	private void window(EntityAluno e_aluno) {
		WindowAluno w_aluno = new WindowAluno(e_aluno);
		w_aluno.addCloseListener(e -> setItem(e_aluno));
		UI.getCurrent().addWindow(w_aluno);
	}
}
