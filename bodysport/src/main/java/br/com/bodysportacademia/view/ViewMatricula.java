/**
 * @(#) ViewMatricula.java 1.0 13/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.view;

import java.util.List;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.dao.DAOMatricula;
import br.com.bodysportacademia.entity.EntityMatricula;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.util.ui.mask.MaskNumberCPF;
import br.com.bodysportacademia.view.grid.GridMatricula;
import br.com.bodysportacademia.window.WindowMatricula;

/**
 * @version 1.0 13/02/2021
 * @author Pietro do Nascimento
 */
public class ViewMatricula extends UIPanel {
	private static final long serialVersionUID = -2105315683412086214L;
	
	public ViewMatricula() {
		super("Matrícula");
		super.addStyleName("well");
		
		VerticalLayout v_layout = (VerticalLayout) super.getLayout();
		v_layout.setSizeFull();
		
		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		v_layout.addComponent(h_layout);
		
		cpf = new MaskNumberCPF("Cpf", e -> pesquisarPorCpf(e.getValue()));
		cpf.setWidth("120px");
		h_layout.addComponent(cpf);		
		nome = new TextField("Nome", e -> pesquisarPorNome(e.getValue()));
		nome.setWidthFull();
		h_layout.addComponent(nome);
		h_layout.setExpandRatio(nome, 1F);	
		cadastrar = new Button(UtilFontIcon.PLUS, e -> showWindow());
		cadastrar.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		cadastrar.setDescription("cadastrar", ContentMode.HTML);
		h_layout.addComponent(cadastrar);
		h_layout.setComponentAlignment(cadastrar, Alignment.BOTTOM_CENTER);
		pesquisar = new Button(UtilFontIcon.SEARCH, e -> listarTodos());
		pesquisar.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		pesquisar.setDescription("Pesquisar Todos", ContentMode.HTML);
		h_layout.addComponent(pesquisar);
		h_layout.setComponentAlignment(pesquisar, Alignment.BOTTOM_CENTER);	
		
		g_layout = new GridMatricula();
		g_layout.setSizeFull();
		v_layout.addComponent(g_layout);
		v_layout.setExpandRatio(g_layout, 1F);
	}
	
	private void pesquisarPorCpf(String str) {
		g_layout.removeAll();
		EntityMatricula e_matricula 
			= new DAOMatricula().pesquisarPorCpf(str);
		if (e_matricula != null) {
			g_layout.addItem(e_matricula);
		} else {
		}
	}
	
	private void pesquisarPorNome(String str) {
		g_layout.removeAll();
		List<EntityMatricula> list 
			= new DAOMatricula().pesquisarPorNome(str);
		if (!list.isEmpty()) {	
			g_layout.setItems(list);
		} else {			
		}
	}
	
	private void listarTodos() {
		g_layout.removeAll();
		List<EntityMatricula> list 
			= new DAOMatricula().listarTodos();
		if (!list.isEmpty()) {	
			g_layout.setItems(list);
		} else {			
		}
	}
	
	private void showWindow() {
		WindowMatricula e_matricula = new WindowMatricula();
		e_matricula.setDataPanel(new EntityMatricula());
		UI.getCurrent().addWindow(e_matricula);
	}
	
	private TextField cpf;
	private TextField nome;
	private Button cadastrar;
	private Button pesquisar;
	private GridMatricula g_layout;
}
