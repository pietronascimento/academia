/**
 * @(#) GridMatriculaPlano.java 1.0 15/02/2021
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

import br.com.bodysportacademia.entity.EntityMatriculaPlano;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.Utilities;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowMatriculaPlano;

/**
 * @version 1.0 15/02/2021
 * @author Pietro do Nascimento
 */
public class GridMatriculaPlano extends UIGrid<EntityMatriculaPlano> {
	private static final long serialVersionUID = -4542838978431258230L;

	public GridMatriculaPlano() {
		super.setItems(new ArrayList<EntityMatriculaPlano>());
		super.addColumn(p -> p.getNome())
			.setCaption("Nome")
			.setWidth(100);
		super.addColumn(p -> p.getDescricao())
			.setCaption("Descrição")
			.setExpandRatio(1);
		super.addColumn(p -> p.getPeriodo())
			.setCaption("Periodo")
			.setWidth(60);
		super.addColumn(p -> Utilities.formatNumber(p.getValor()))
			.setCaption("Valor")
			.setWidth(100);
		super.addComponentColumn(p -> showWindow(p))
			.setWidth(50);
	}
	
	private Button showWindow(EntityMatriculaPlano e_plano) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(e_plano));		
		return button;
	}
	
	private void window(EntityMatriculaPlano e_plano) {
		WindowMatriculaPlano w_plano = new WindowMatriculaPlano();
		w_plano.setDataPanel(e_plano);
		w_plano.addCloseListener(e -> setItem(e_plano));
		UI.getCurrent().addWindow(w_plano);
	}
}
