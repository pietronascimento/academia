package br.com.bodysportacademia.util;

public enum UtilSexo {
	
	MASCULINO(1),
	FEMININO(2);

	UtilSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public int getSexo() {
		return sexo;
	}
	
	public String getValue() {
		if (sexo == 1) {
			return "Masculino";
		}
		if (sexo == 2) {
			return "Feminino";
		}
		return "";
	}
	
	private int sexo;
}
