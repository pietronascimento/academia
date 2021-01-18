package br.com.bodysportacademia.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.util.ui.UIWindowInternal;

public class ViewInit extends VerticalLayout {
	private static final long serialVersionUID = 5020666670584099662L;
	
	public ViewInit() {		
		super.setSizeFull();
		
		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSizeFull();	
		super.addComponent(h_layout);
		super.setExpandRatio(h_layout, 1F);
		
		UIWindowInternal u_internal = new UIWindowInternal("Menu");
		((VerticalLayout) u_internal.getLayout()).setMargin(false);
		((VerticalLayout) u_internal.getLayout()).addComponent(new ViewInitMenu(ViewInit.this));
		((VerticalLayout) u_internal.getLayout()).setSizeFull();
		u_internal.setWidth("200px");
		u_internal.setHeightFull();
		h_layout.addComponent(u_internal);	
		
		u_panel = new UIPanel();
		h_layout.addComponent(u_panel);
		h_layout.setExpandRatio(u_panel, 1F);
	}

	public void addView(Component component) {
		((VerticalLayout) u_panel.getLayout()).removeAllComponents();
		((VerticalLayout) u_panel.getLayout()).addComponent(component);
		((VerticalLayout) u_panel.getLayout()).setSizeFull();
	}
	
	private UIPanel u_panel;
}
