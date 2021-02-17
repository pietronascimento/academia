/**
 * @(#) GridFuncionario.java 1.0 12/02/2021
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

import br.com.bodysportacademia.entity.EntityFuncionario;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowFuncionario;

/**
 * @version 1.0 12/02/2021
 * @author Pietro do Nascimento
 */
public class GridFuncionario extends UIGrid<EntityFuncionario> {
	private static final long serialVersionUID = 2450374437927544099L;

	public GridFuncionario() {
		super.setItems(new ArrayList<EntityFuncionario>());		
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
	
	public boolean exists(EntityFuncionario e_funcionario) {
		for (EntityFuncionario f : super.getItems()) {
			if (f.getCpf().equals(e_funcionario.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	private Button showWindow(EntityFuncionario e_funcionario) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(e_funcionario));		
		return button;
	}
	
	private void window(EntityFuncionario e_funcionario) {
		WindowFuncionario w_funcionario = new WindowFuncionario(e_funcionario);
		w_funcionario.addCloseListener(e -> setItem(e_funcionario));
		UI.getCurrent().addWindow(w_funcionario);
	}
}
