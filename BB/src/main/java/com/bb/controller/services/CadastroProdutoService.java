package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Produtos;
import com.bb.models.Produto;

public class CadastroProdutoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private Produtos produtos;
	
	
	public Produto salvar (Produto produto){
		
		Produto produtoExistente = produtos.porSku(produto.getSku());
		
		if(produtoExistente != null && !produtoExistente.equals(produto)){
			throw new NegocioException("Já existe um produto com o sku informado");
		}
		
		return  produtos.guardar(produto);
	}

}
