/**
 * @(#) ModelEstado.java 1.0 13/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.bean;

/**
 * @version 1.0 13/01/2021
 * @author Pietro do Nascimento
 */
public enum ModelEstado {
	
	ES("ES");
	
	ModelEstado(String value) {
		this.value = value;
	}

	public String getSelected() {
		return value;
	}	
	
	private String value;
}
