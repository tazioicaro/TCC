package com.bb.models.Enumerators;

public enum StatusAgendamento {
	
	EM_ANDAMENTO("Em Andamento"), FINALIZADO("Finalizado"), CANCELADO("Cancelado"), AGUARDANDO_APROVACAO("Aguardando Aprovação"), APROVADO("Aprovado"),NOVA_SUGESTÃO("Nova Sugestão");  


private String label;
	
	private StatusAgendamento(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}


}
