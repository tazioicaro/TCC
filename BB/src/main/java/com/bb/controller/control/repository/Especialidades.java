package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.bb.models.Especialidade;

public class Especialidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Especialidade porCodigo(Long codigo){
		return manager.find(Especialidade.class, codigo);
	}
	
	
	
	public List<Especialidade> raizes(){
		
		return manager.createQuery("from Especialidade where especialidadePai is null", 
				Especialidade.class).getResultList();
		
	}
	
		
	public List<Especialidade> servicoDe (Especialidade especialidadePai){
		return manager.createQuery("from Especialidade where especialidadePai = :raiz", 
				Especialidade.class).setParameter("raiz", especialidadePai).getResultList();
		
	}
}
