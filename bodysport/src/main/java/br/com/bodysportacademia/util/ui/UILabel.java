/**
 * @(#) UILabel.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util.ui;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UILabel extends HorizontalLayout {
	private static final long serialVersionUID = -1150382700026716916L;

    public UILabel() {
        this("");
    }

    public UILabel(String str) {
        super.setSpacing(true);
        super.setWidth("100%");    
        label = new Label(str, ContentMode.HTML);
        label.setSizeFull();
        super.addComponent(label);
    }  

    public UILabel(Resource icon, String str) {
        super.setSpacing(true);
        super.setWidth("100%");     
        
        Button u_button = new Button(icon);
        u_button.addStyleName(ValoTheme.BUTTON_LINK);
        u_button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        u_button.setEnabled(false);
        super.addComponent(u_button);
        super.setComponentAlignment(u_button, Alignment.MIDDLE_CENTER);
        
        label = new Label(str, ContentMode.HTML);
        super.addComponent(label);
        super.setExpandRatio(label, 1F);
        //super.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
    }
    
    public void setValue(String str) {
        label.setValue(str);
    }
      
    public Label getLabel() {
        return label;
    }
    
    private Label label = null;
}
