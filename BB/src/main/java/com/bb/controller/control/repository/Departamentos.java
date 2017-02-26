package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Departamento;



public class Departamentos implements Serializable {

 
private static final long serialVersionUID = 1L;
 
@Inject
private EntityManager manager;
 

 
public List<Departamento> porDepartamento(){
 
 
return this.manager.createQuery("from Departamento where departamentoPai is null", Departamento.class).getResultList();
}
 
 
public Departamento porNome(String nome){
 
return this.manager.createQuery("from Departamento where lower(nome) =:nome", Departamento.class)
.setParameter("nome", nome.toLowerCase()).getSingleResult();
}
 
 
 
public List<Departamento> porGerente(Departamento departamentoPai) {
return manager.createQuery("from Departamento where departamentoPai = :raiz", 
Departamento.class).setParameter("raiz", departamentoPai).getResultList();
}
 
 
 
@Transactional
public  Departamento guardar (Departamento departamento){
 
return this.manager.merge(departamento);
}


public Departamento porId(Long valor) {
 
return this.manager.find(Departamento.class, valor);
}
 
}