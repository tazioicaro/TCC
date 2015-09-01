package com.bb.controller.control.pesquisas;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Produtos;
import com.bb.controller.control.repository.filter.ProdutosFilter;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Produto;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	private Produto produtoSelecionado;
	
	private ProdutosFilter filtro;
	
	private List<Produto> produtosFiltrados;
	
	
	

	public PesquisaProdutoBean() {
		filtro = new ProdutosFilter();
	}

	
	
	public void pesquisar(){
		
		produtosFiltrados = produtos.filtrados(filtro);
		
	}
	
	public void excluir(){
		produtos.excluirproduto(produtoSelecionado);
		
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInforMessage("Produto" + produtoSelecionado.getSku() + "excluído com sucesso");
	}
	
	
	//G&T

	public ProdutosFilter getFiltro() {
		return filtro;
	}



	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}



	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}



	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	
	
	

}
