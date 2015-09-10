package com.bb.models.Enumerators;

public enum TipoComissao {
	
	CLASSE_1 ("Classe_1"),
	CLASSE_2("Classe_2"),
	CLASSE_3("Classe_3"),
	CLASSE_4("Classe_4");

	
	private String label;
	
	
	

	private TipoComissao(String label) {
		
		this.label = label;
	
	}

	public String getLabel() {
		return label;
	}


	
}
