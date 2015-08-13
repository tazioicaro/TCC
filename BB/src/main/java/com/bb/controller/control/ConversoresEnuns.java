package com.bb.controller.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.bb.models.Enumerators.Sexo;
import com.bb.models.Enumerators.StatusAgendamento;
import com.bb.models.Enumerators.StatusServico;

@Named
@ApplicationScoped
public class ConversoresEnuns  {	
	
	public Sexo[] getSexoes(){
		return Sexo.values();
		
	}
	
	public StatusAgendamento[] getStatuses(){
		return StatusAgendamento.values();
	}
	
	public StatusServico[] getStatusServicoses(){
		return StatusServico.values();
	}

}
