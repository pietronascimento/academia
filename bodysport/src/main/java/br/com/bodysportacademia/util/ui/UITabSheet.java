/**
 * @(#) UITabSheet.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util.ui;

import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class UITabSheet extends TabSheet {
	private static final long serialVersionUID = 909152266291113926L;

	public UITabSheet() {
        super.addStyleName(ValoTheme .TABSHEET_FRAMED);
        super.addStyleName(ValoTheme.TABSHEET_COMPACT_TABBAR);
        super.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        super.setSizeFull();
    }

	@Override
    public Tab addTab(Component component, String caption) {
        return this.addTab(component, caption, null);
    }
    
    @Override
    public Tab addTab(Component component, String caption, Resource icon) {
        return super.addTab(new UIPanel(component), caption, icon);
    }
}
