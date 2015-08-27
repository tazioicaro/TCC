package com.bb.controller.control.repository.filter;

import java.io.Serializable;

import com.bb.controller.services.validation.SKU;

public class ProdutosFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	@SKU
	private String sku;	
	private String nome;
	
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase() ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
