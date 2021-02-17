/**
 * @(#) Main.java 1.0 05/01/2021
 *
  * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.view.ViewInit;
import br.com.bodysportacademia.view.ViewLogin;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
@Theme("psoftwares-style-bodysport")
public class Main extends UI {
	private static final long serialVersionUID = 3153597453503324804L;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = Main.class, productionMode = false)
	public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = -6111465768698353377L;
		@Override
		protected void servletInitialized() throws ServletException {
			super.servletInitialized();
			getService().addSessionInitListener(new ValoThemeSessionInitListener());
		}
	}
	
	@Override
	protected void init(VaadinRequest request) {
		super.getPage().setTitle("BodySport v0.2");
		super.setSizeFull();
		
		v_layout = new VerticalLayout();
		v_layout.setMargin(true);
		v_layout.setSizeFull();
		super.setContent(v_layout);
		
		viewLogin();
	}
	
	public void viewLogin() {
		v_layout.removeAllComponents();
		v_layout.addComponent(new ViewLogin(Main.this));
	}
	
	public void viewInit() {
		v_layout.removeAllComponents();
		v_layout.addComponent(new ViewInit(Main.this));
	}
	
	private VerticalLayout v_layout;
}
