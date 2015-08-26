package com.bb.controller.control.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Produto;

public class Produtos  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	@Transactional
	 public Produto guardar (Produto produto){
		 return manager.merge(produto);
	 }
	 
	 
	 public Produto porSku (String sku){
		 try {
				return manager.createQuery("From Produto where upper(sku)= :sku", Produto.class)
						.setParameter("sku", sku.toUpperCase()).getSingleResult();
			} catch (NoResultException e) {
				
				return null;
			}
	 }

}
