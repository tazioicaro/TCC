package com.bb.models.Enumerators;

public enum Sexo {
	
	MASCULINO("Masculino"), FEMININO ("Feminino");

	
	private String label;
	
	private Sexo(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
	

}
