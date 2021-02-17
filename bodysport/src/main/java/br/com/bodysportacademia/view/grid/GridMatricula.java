/**
 * @(#) GridMatricula.java 1.0 21/01/2021
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

import br.com.bodysportacademia.entity.EntityMatricula;
import br.com.bodysportacademia.util.UtilDate;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowMatricula;

/**
 * @version 1.0 21/01/2021
 * @author Pietro do Nascimento
 */
public class GridMatricula extends UIGrid<EntityMatricula> {
	private static final long serialVersionUID = 9158213659941245534L;
	
	public GridMatricula() {
		super.setItems(new ArrayList<EntityMatricula>());
		super.addColumn(m -> UtilDate.format(m.getData()))
			.setCaption("Data Matrícula")
			.setWidth(100);
		super.addColumn(m -> m.getAluno().getNome())
			.setCaption("Aluno")
			.setExpandRatio(1);
		super.addComponentColumn(m ->showWindow(m))
			.setWidth(100);
	}
	
	private Button showWindow(EntityMatricula b_matricula) {		
		Button button = new Button("Detelhes", e -> window(b_matricula));
		button.addStyleName(ValoTheme.BUTTON_LINK);		
		return button;
	}
	
	private void window(EntityMatricula b_matricula) {
		WindowMatricula w_matricula = new WindowMatricula();
		w_matricula.setDataPanel(b_matricula);
		w_matricula.addCloseListener(e -> setItem(b_matricula));
		UI.getCurrent().addWindow(w_matricula);
	}
}
