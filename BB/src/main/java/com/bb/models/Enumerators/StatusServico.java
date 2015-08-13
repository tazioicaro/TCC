package com.bb.models.Enumerators;

public enum StatusServico {

	EM_ANDAMENTO("Em Andamento"), 
	FINALIZADO("Finalizado"),
	NOVA_SUGESTÃO("Nova Sugestão"), 
	CANCELADO("Cancelado"), 
	AGUARDANDO_APROVACAO("Aguardando Aprovação");

	private String label;

	private StatusServico(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
