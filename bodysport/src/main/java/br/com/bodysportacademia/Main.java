/**
 * @(#) Main.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import br.com.bodysportacademia.view.ViewInit;

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
		}
	}
	
	@Override
	protected void init(VaadinRequest request) {
		super.getPage().setTitle("BodySport v0.2");
		super.setSizeFull();				
		super.setContent(new ViewInit());
	}
}
