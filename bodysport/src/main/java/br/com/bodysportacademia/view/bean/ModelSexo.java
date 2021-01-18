/**
 * @(#) ModelSexo.java 1.0 12/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.bean;

/**
 * @version 1.0 12/01/2021
 * @author Pietro do Nascimento
 */
public enum ModelSexo {
	Masculino(1),
	Feminino(2);
	
	ModelSexo(int value) {
		this.value = value;
	}
	
	public int getSelected() {
		return value;
	}
	
	private int value;
}
