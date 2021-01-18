/**
 * @(#) ViewInitMenu.java 1.0 05/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;

import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIMenu;
import br.com.bodysportacademia.view.aluno.ViewAluno;

/**
 * @version 1.0 05/01/2021
 * @author Pietro do Nascimento
 */
public class ViewInitMenu extends Accordion {
	private static final long serialVersionUID = -1258886314997353627L;

	public ViewInitMenu(ViewInit v_init) {
		this.v_init = v_init;
		
		super.addTab(
				createMenuAluno(), 
				"Aluno", 
				UtilFontIcon.ACADEMY_CAP);
		super.addTab(
				createMenuProfessor(), 
				"Professor", 
				UtilFontIcon.DIPLOMA_SCROLL);   
		super.addTab(
				createMenuFuncionario(), 
				"Funcionário", 
				UtilFontIcon.TOOLS); 
		super.setSizeFull();
	}
	
	private UIMenu createMenuAluno() {
		UIMenu u_menu = new UIMenu();
        u_menu.addItem("Cadastro/Pesquisar/Alterar");
        u_menu.addLayoutClickListener(e -> {
        	if (getClickMenu(u_menu, e.getChildComponent()) == 0) {
        		v_init.addView(new ViewAluno());
        	}
        });
        return u_menu;
	}
	
	private UIMenu createMenuProfessor() {
		UIMenu u_menu = new UIMenu();
        u_menu.addItem("Cadastro/Pesquisar/Alterar");
        return u_menu;
	}
	
	private UIMenu createMenuFuncionario() {
		UIMenu u_menu = new UIMenu();
        u_menu.addItem("Cadastro/Pesquisar/Alterar");
        return u_menu;
	}
	
    private int getClickMenu(UIMenu u_menu, Component comp) {
        u_menu.clearSelected();
        int index = u_menu.getComponentIndex(comp);
        u_menu.setSelectedItem(index);
        return index;
    }
	
	private ViewInit v_init;
}
