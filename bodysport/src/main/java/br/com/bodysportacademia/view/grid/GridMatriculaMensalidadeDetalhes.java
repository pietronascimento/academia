/**
 * @(#) GridMatriculaMensalidade.java 1.0 16/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.view.grid;

import java.util.ArrayList;

import br.com.bodysportacademia.entity.EntityMatriculaMensalidade;
import br.com.bodysportacademia.util.UtilDate;
import br.com.bodysportacademia.util.Utilities;
import br.com.bodysportacademia.util.ui.UIGrid;

/**
 * @version 1.0 16/02/2021
 * @author Pietro do Nascimento
 */
public class GridMatriculaMensalidadeDetalhes extends UIGrid<EntityMatriculaMensalidade> {
	private static final long serialVersionUID = -9189738345907299995L;
	
	public GridMatriculaMensalidadeDetalhes() {
		super.setItems(new ArrayList<EntityMatriculaMensalidade>());
		super.addColumn(m -> m.getPaga() ? "SIM" : "NÃO")
			.setCaption("Paga")
			.setWidth(100);
		super.addColumn(m -> UtilDate.format(m.getDataVencimento()))
			.setCaption("Data vencimento")
			.setExpandRatio(1);
		super.addColumn(m -> Utilities.formatNumber(m.getPlano().getValor()))
			.setCaption("Valor")
			.setWidth(100);
	}
}
