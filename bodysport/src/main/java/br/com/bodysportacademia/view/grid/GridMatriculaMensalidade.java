/**
 * @(#) GridMatriculaMensalidade.java 1.0 16/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.view.grid;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.entity.EntityMatriculaMensalidade;
import br.com.bodysportacademia.util.UtilDate;
import br.com.bodysportacademia.util.UtilFontIcon;
import br.com.bodysportacademia.util.ui.UIGrid;
import br.com.bodysportacademia.window.WindowMatriculaMensalidade;

/**
 * @version 1.0 16/02/2021
 * @author Pietro do Nascimento
 */
public class GridMatriculaMensalidade extends UIGrid<EntityMatriculaMensalidade> {
	private static final long serialVersionUID = 4680692680602319156L;
	
	public GridMatriculaMensalidade() {
		super.setItems(new ArrayList<EntityMatriculaMensalidade>());
		super.addColumn(m -> m.getPaga() ? "SIM" : "NÃO")
			.setStyleGenerator(m -> notifyAluno(m))
			.setCaption("Paga")
			.setWidth(50);
		super.addColumn(m -> m.getMatricula().getAluno().getNome())
			.setStyleGenerator(m -> notifyAluno(m))
		    .setCaption("Aluno")
			.setExpandRatio(1);	
		super.addColumn(m -> UtilDate.format(m.getDataVencimento()))
			.setStyleGenerator(m -> notifyAluno(m))
			.setCaption("Data Vencimento")
			.setWidth(100);	
		super.addColumn(m -> getNumeroDias(m))
			.setStyleGenerator(m -> notifyAluno(m))
			.setCaption("Dias Vencidos")
			.setWidth(100);
		super.addColumn(m -> (m.getDataPagamento() == null) ? "" : UtilDate.format(m.getDataPagamento()))
			.setStyleGenerator(m -> notifyAluno(m))
			.setCaption("Data Pagamento")
			.setWidth(100);	
		super.addComponentColumn(m -> showWindow(m))
			.setWidth(50);
	}
	
	private String notifyAluno(EntityMatriculaMensalidade b_mensalidade) {
		int dia = (int) Duration.between(
				LocalDateTime.of(LocalDate.now(), LocalTime.now()),
				LocalDateTime.of(b_mensalidade.getDataVencimento(), 
				LocalTime.now())).toDays();

		if (!b_mensalidade.getPaga()) {
			if (dia <= 5 && dia >= 0) {
				return "cell-yellow";
			} else if (dia < 0) {
				return "cell-red";
			}
		}		
		return "cell-green";
	}
	
	private String getNumeroDias(EntityMatriculaMensalidade b_mensalidade) {
		int dia = (int) Duration.between(
				LocalDateTime.of(LocalDate.now(), LocalTime.now()),
				LocalDateTime.of(b_mensalidade.getDataVencimento(), 
				LocalTime.now())).toDays();
		return dia < 0 ? "" + (dia * -1) : "";
    }
	
	private Button showWindow(EntityMatriculaMensalidade b_mensalidade) {		
		Button button = new Button(UtilFontIcon.REFRESH);
		button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		button.addClickListener(e -> window(b_mensalidade));		
		return button;
	}
	
	private void window(EntityMatriculaMensalidade e_mensalidade) {
		WindowMatriculaMensalidade w_mensalidade = new WindowMatriculaMensalidade();
		w_mensalidade.setDataPanel(e_mensalidade);
		w_mensalidade.addCloseListener(e -> setItem(e_mensalidade));
		UI.getCurrent().addWindow(w_mensalidade);
	}
}
