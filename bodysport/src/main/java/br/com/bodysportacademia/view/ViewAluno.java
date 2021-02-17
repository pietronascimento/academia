/**
 * @(#) ViewAluno.java 1.0 13/01/2021
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

import br.com.bodysportacademia.dao.DAOAluno;
import br.com.bodysportacademia.entity.EntityAluno;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.util.ui.mask.MaskNumberCPF;
import br.com.bodysportacademia.view.grid.GridAluno;
import br.com.bodysportacademia.window.WindowAluno;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class ViewAluno extends UIPanel {
	private static final long serialVersionUID = 5383832651567065247L;
	
	public ViewAluno() {
		super("Aluno");
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
		cadastrar.setDescription("Cadastrar", ContentMode.HTML);
		h_layout.addComponent(cadastrar);
		h_layout.setComponentAlignment(cadastrar, Alignment.BOTTOM_CENTER);
		pesquisar = new Button(UtilFontIcon.SEARCH, e -> listarTodos());
		pesquisar.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		pesquisar.setDescription("Pesquisar Todos", ContentMode.HTML);
		h_layout.addComponent(pesquisar);
		h_layout.setComponentAlignment(pesquisar, Alignment.BOTTOM_CENTER);	
		
		g_layout = new GridAluno();
		g_layout.setSizeFull();
		v_layout.addComponent(g_layout);
		v_layout.setExpandRatio(g_layout, 1F);
	}
	
	private void pesquisarPorCpf(String str) {
		g_layout.removeAll();
		EntityAluno e_aluno = new DAOAluno().pesquisarPorCpf(str);
		if (e_aluno != null) {
			g_layout.addItem(e_aluno);
		} else {			
		}
	}

	private void pesquisarPorNome(String str) {
		g_layout.removeAll();
		List<EntityAluno> list 
			= new DAOAluno().pesquisarPorNome(str);
		if (!list.isEmpty()) {
			g_layout.setItems(list);
		} else {			
		}
	}

	private void listarTodos() {
		g_layout.removeAll();
		List<EntityAluno> list 
			= new DAOAluno().listarTodos();
		if (!list.isEmpty()) {
			g_layout.setItems(list);
		} else {
		}
	}
	
	private void showWindow() {
		UI.getCurrent().addWindow(new WindowAluno());
	}
	
	private TextField cpf;
	private TextField nome;
	private Button cadastrar;
	private Button pesquisar;
	private GridAluno g_layout;
}
