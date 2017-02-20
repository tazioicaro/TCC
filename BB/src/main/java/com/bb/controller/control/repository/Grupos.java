package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.models.Grupo;

public class Grupos  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public List<Grupo> porGrupos(){		
		
		return this.manager.createQuery("from Grupo", Grupo.class).getResultList();
		
	}
	
	public Grupo porID (Long codigo){
		
		return this.manager.find(Grupo.class, codigo);
	}

	
	

}
