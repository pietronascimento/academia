/**
 * @(#) ViewMatriculaMensalidade.java 1.0 16/02/2021
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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.dao.DAOMatriculaMensalidade;
import br.com.bodysportacademia.entity.EntityMatriculaMensalidade;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.util.ui.mask.MaskNumberCPF;
import br.com.bodysportacademia.view.grid.GridMatriculaMensalidade;

/**
 * @version 1.0 16/02/2021
 * @author Pietro do Nascimento
 */
public class ViewMatriculaMensalidade extends UIPanel {
	private static final long serialVersionUID = -8232496980964030269L;

	public ViewMatriculaMensalidade() {
		super("Mensalidades", new VerticalLayout());
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
		pesquisar = new Button(UtilFontIcon.SEARCH, e -> listarTodos());
		pesquisar.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		pesquisar.setDescription("Pesquisar Todos", ContentMode.HTML);
		h_layout.addComponent(pesquisar);
		h_layout.setComponentAlignment(pesquisar, Alignment.BOTTOM_CENTER);	

		g_layout = new GridMatriculaMensalidade();
		g_layout.setItems(new DAOMatriculaMensalidade().listarMensalidadesNaoPagas());
		g_layout.setSizeFull();
		v_layout.addComponent(g_layout);
		v_layout.setExpandRatio(g_layout, 1F);
	}
	
	private void pesquisarPorCpf(String str) {
		g_layout.removeAll();		
		if (!str.isEmpty()) {
			EntityMatriculaMensalidade e_mensalidade 
				= new DAOMatriculaMensalidade().pesquisarPorCpf(str);
			if (e_mensalidade != null) {
				g_layout.addItem(e_mensalidade);
			} else {
			}
		} else {
			g_layout.setItems(new DAOMatriculaMensalidade().listarMensalidadesNaoPagas());
		}
	}
	
	private void pesquisarPorNome(String str) {
		g_layout.removeAll();		
		if (!str.isEmpty()) {
			List<EntityMatriculaMensalidade> list 
				= new DAOMatriculaMensalidade().pesquisarPorNome(str);
			if (!list.isEmpty()) {	
				g_layout.setItems(list);
			} else {			
			}
		} else {
			g_layout.setItems(new DAOMatriculaMensalidade().listarMensalidadesNaoPagas());
		}
	}
	
	private void listarTodos() {
		g_layout.removeAll();
		g_layout.setItems(new DAOMatriculaMensalidade().listarMensalidadesNaoPagas());
	}

	private TextField cpf;
	private TextField nome;
	private Button pesquisar;
	private GridMatriculaMensalidade g_layout;
}
