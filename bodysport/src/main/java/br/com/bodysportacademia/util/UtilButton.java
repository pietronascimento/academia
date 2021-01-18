package br.com.bodysportacademia.util;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class UtilButton extends HorizontalLayout {
	private static final long serialVersionUID = -801995900563843535L;

	public UtilButton(Resource icon, String caption) {
		super.addStyleName("utilbutton-h");
		super.setSpacing(false);
		
		super.addComponent(getButton(icon));
		Label label = new Label(caption, ContentMode.HTML);
		label.addStyleName("utilbutton-l");
		label.setWidthFull();
		super.addComponent(label);
		super.setExpandRatio(label, 1F);
		
		//super.setWidth("100%");
		super.setHeight("30px");
	}
	
	private Button getButton(Resource icon) {
		Button button = new Button(icon);
		button.setWidth("30px");
		button.setHeight("30px");
		button.setPrimaryStyleName("utilbutton-b");
		return button;
	}
}
