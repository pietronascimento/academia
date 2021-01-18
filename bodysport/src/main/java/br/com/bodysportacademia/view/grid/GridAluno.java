/**
 * @(#) GridAluno.java 1.0 12/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.grid;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.view.aluno.WindowAluno;
import br.com.bodysportacademia.view.bean.BeanAluno;

/**
 * @version 1.0 12/01/2021
 * @author Pietro do Nascimento
 */
public class GridAluno extends Grid<BeanAluno> {
	private static final long serialVersionUID = -4513471891422149695L;

	public GridAluno() {
		super.setItems(new ArrayList<BeanAluno>());		
		super.addColumn(a -> a.getCpf())
			.setCaption("CPF")
			.setWidth(120);			
		super.addColumn(a -> a.getNome())
			.setCaption("Nome")
			.setExpandRatio(1);	
		super.addColumn(a -> a.getCelular())
			.setCaption("Celular")
			.setWidth(120);	
		super.addComponentColumn(a -> showWindowUpdate(a))
			.setWidth(50);
	}
	
	public boolean exists(BeanAluno b_aluno) {
		for (BeanAluno a : getAlunos()) {
			if (a.getCpf().equals(b_aluno.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	public void addItem(BeanAluno b_aluno) {
		ListDataProvider<BeanAluno> l_dataProvider = listDataProvider();
		l_dataProvider.getItems().add(b_aluno);
		l_dataProvider.refreshAll();
	}
	
	public void setItem(BeanAluno b_aluno) {
		listDataProvider().getItems().remove(b_aluno);
		listDataProvider().getItems().add(b_aluno);
		listDataProvider().refreshAll();
	}
	
	public List<BeanAluno> getAlunos() {
		return new ArrayList<>(listDataProvider().getItems());
	}
	
	public void removeItem(BeanAluno b_aluno) {
		ListDataProvider<BeanAluno> l_dataProvider = listDataProvider();
		l_dataProvider.getItems().remove(b_aluno);
		l_dataProvider.refreshAll();
	}
	
	public void removeAll() {
		listDataProvider().getItems().clear();
		listDataProvider().refreshAll();
	}
	
	@SuppressWarnings("unchecked")
	private ListDataProvider<BeanAluno> listDataProvider() {
		return (ListDataProvider<BeanAluno>) super.getDataProvider();
	}
	
	private Button showWindowUpdate(BeanAluno b_aluno) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(b_aluno));		
		return button;
	}
	
	private void window(BeanAluno b_aluno) {
		WindowAluno w_aluno = new WindowAluno();
		w_aluno.setDataPanel(b_aluno);
		w_aluno.addCloseListener(e -> setItem(b_aluno));
		UI.getCurrent().addWindow(w_aluno);
	}
}
