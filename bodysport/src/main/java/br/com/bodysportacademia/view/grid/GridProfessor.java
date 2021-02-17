/**
 * @(#) GridProfessor.java 1.0 12/02/2021
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

import br.com.bodysportacademia.entity.EntityProfessor;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowProfessor;

/**
 * @version 1.0 12/02/2021
 * @author Pietro do Nascimento
 */
public class GridProfessor extends UIGrid<EntityProfessor> {
	private static final long serialVersionUID = 5755334649290085098L;

	public GridProfessor() {
		super.setItems(new ArrayList<EntityProfessor>());		
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
	
	public boolean exists(EntityProfessor e_professor) {
		for (EntityProfessor p : super.getItems()) {
			if (p.getCpf().equals(e_professor.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	private Button showWindow(EntityProfessor e_professor) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(e_professor));		
		return button;
	}
	
	private void window(EntityProfessor e_professor) {
		WindowProfessor w_professor = new WindowProfessor(e_professor);
		w_professor.addCloseListener(e -> setItem(e_professor));
		UI.getCurrent().addWindow(w_professor);
	}
}
