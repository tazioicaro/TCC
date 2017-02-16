package com.bb.controller.services.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.bb.models.Enumerators.Sexo;
import com.bb.models.Enumerators.StatusAgendamento;
import com.bb.models.Enumerators.StatusPedido;
import com.bb.models.Enumerators.StatusServico;
import com.bb.models.Enumerators.TipoComissao;
import com.bb.models.Enumerators.TipoNFE;
import com.bb.models.Enumerators.TipoPessoa;

@Named
@ApplicationScoped
public class ConversoresEnuns  {	
	
	public Sexo[] getSexoes(){
		return Sexo.values();
		
	}	
	
	public StatusAgendamento[] getStatusAgendamento(){
		return StatusAgendamento.values();
	}		
	
	public StatusPedido[] getAtatusPedido(){
		return StatusPedido.values();
	}
	
	public StatusServico[] getStatusServicoses(){
		return StatusServico.values();
	}
	
	public TipoComissao[] getTipoComissaoes(){
		return TipoComissao.values();
	}
	

	public TipoNFE[] getTipoNFEes(){		
		return TipoNFE.values();
	}
	

	public TipoPessoa[] getTiposPessoas(){
		return TipoPessoa.values();
	}
	
	
	
	
	

}
