package com.bb.models.Enumerators;

public enum TipoNFE {

	ENTRADA("Entrada"), SAÍDA("Saída");
	
	
private String label;
	
	private TipoNFE(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
