/**
 * @(#) UIPanel.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UIPanel extends Panel {
	private static final long serialVersionUID = 792375545802875572L;

    public UIPanel() {
        this(new VerticalLayout());
    }
    
    public UIPanel(Component component) {
        this(null, component);
    }

    public UIPanel(String title, Component component) {
        super(title, new Panel(component));            
        ((Panel) super.getContent()).setPrimaryStyleName("ps-panel-layout"); 
        ((Panel) super.getContent()).setSizeFull();
        super.setSizeFull();
    }

    public Component getLayout() {
        return ((Panel) super.getContent()).getContent();
    }
}
