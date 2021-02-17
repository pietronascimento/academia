package br.com.bodysportacademia.util;

public enum UtilEstado {

	ES("ES"),
	RJ("RJ");
	
	UtilEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	private String estado;
}
