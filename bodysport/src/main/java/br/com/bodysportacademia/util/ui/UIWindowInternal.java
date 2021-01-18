/**
 * @(#) UIWindowInternal.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UIWindowInternal extends UIPanel {
	private static final long serialVersionUID = 4206728534904012130L;
	
	public UIWindowInternal(String title) {
		this(title, new VerticalLayout());
	}
	
	public UIWindowInternal(String title, Component component) {
		super(title, component);
		super.addStyleName(ValoTheme.PANEL_WELL);
	}

    public Component getLayout() {
        return super.getLayout();
    }
}
