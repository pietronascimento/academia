/**
 * @(#) UIMenu.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util.ui;

import com.vaadin.server.Resource;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UIMenu extends VerticalLayout {
	private static final long serialVersionUID = 4047894542103779962L;

    public UIMenu() {
        super.setMargin(false);
        super.setSpacing(false);
        super.setWidth("100%");
    }

    public UILabel addItem(String str) {
        UILabel u_label = new UILabel(str);
        u_label.setStyleName("menu-item");
        super.addComponent(u_label);
        return u_label;
    }

    public UILabel addItem(Resource icon, String str) {
        UILabel u_label = new UILabel(icon, str);
        u_label.setStyleName("menu-item");
        super.addComponent(u_label);
        return u_label;
    }

    public void setSelectedItem(int index) {
        Object object = super.getComponent(index);
        if (object instanceof Label) {
            ((UILabel) object).setStyleName("menu-item-selected");
        }
    }

    public void setNotSelectedItem(int index) {
        Object object = super.getComponent(index);
        if (object instanceof UILabel) {
            ((UILabel) object).setStyleName("menu-item-not-selected");
        }
    }
    
    public String getCaption(int index) {
        Object object = super.getComponent(index);
        if (object instanceof UILabel) {
            return ((UILabel) object).getLabel().getValue();
        }
        return "";
    }

    public void clearSelected() {
        for (int index = 0; index < super.getComponentCount(); index++) {
            setNotSelectedItem(index);
        }
    }
}
