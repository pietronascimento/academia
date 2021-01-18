/**
 * @(#) ViewAluno.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.view.grid.GridAluno;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public class ViewAluno extends UIPanel {
	private static final long serialVersionUID = 5383832651567065247L;
	
	public ViewAluno() {
		super("Aluno", new VerticalLayout());
		super.addStyleName("well");
		
		VerticalLayout v_layout = (VerticalLayout) super.getLayout();
		v_layout.setSizeFull();
		
		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		v_layout.addComponent(h_layout);
		
		cpf = new TextField("Cpf");
		cpf.setWidth("120px");
		h_layout.addComponent(cpf);		
		nome = new TextField("Nome");
		nome.setWidthFull();
		h_layout.addComponent(nome);
		h_layout.setExpandRatio(nome, 1F);		
		cadastrar = new Button(UtilFontIcon.PLUS);
		cadastrar.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		cadastrar.setDescription("cadastrar", ContentMode.HTML);
		h_layout.addComponent(cadastrar);
		h_layout.setComponentAlignment(cadastrar, Alignment.BOTTOM_CENTER);
		
		g_layout = new GridAluno();
		g_layout.setSizeFull();
		v_layout.addComponent(g_layout);
		v_layout.setExpandRatio(g_layout, 1F);
		
		new ViewAlunoHandle(ViewAluno.this);
	}
	
	protected TextField cpf;
	protected TextField nome;
	protected Button cadastrar;
	protected GridAluno g_layout;
}
