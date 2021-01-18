package br.com.bodysportacademia.util.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UIWindow extends Window {
	private static final long serialVersionUID = -7736888945834596050L;

    public UIWindow() {
        this("");
    }
    
    public UIWindow(String title) {
        this(title, new UIPanel());
    }
    
    public UIWindow(String title, Component component) {
        super(title, component);
        component.setSizeFull();
        super.setSizeFull();
    }

    public Component getLayout() {
    	Component component = super.getContent();
    	if (component instanceof UIPanel) {
    		return ((UIPanel) super.getContent()).getLayout();
    	}
    	return component;
    }
}
