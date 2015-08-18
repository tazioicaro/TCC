package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.bb.controller.control.repository.Especialidades;
import com.bb.controller.control.repository.UnidadesMedidas;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Especialidade;
import com.bb.models.Fornecedor;
import com.bb.models.Produto;
import com.bb.models.Servicos;
import com.bb.models.TipoProduto;
import com.bb.models.Unidade;



@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Produto produto;
	private List<Unidade> listaUnidade;
	private Fornecedor fornecedor;
	private TipoProduto tipoProduto;
	private List<Servicos> servicos;
	
	@NotNull
	private Especialidade categoriaPai;
	
	private List<Especialidade> categoriaRaizes;	
	private List<Especialidade> subCategorias;
	
	
	@Inject
	private Especialidades categorias;
	
	@Inject
	private UnidadesMedidas unidades;
	
	
	
	public CadastroProdutoBean() {
	
		servicos = new ArrayList<Servicos>();
		fornecedor = new Fornecedor();	
		produto = new Produto();
		tipoProduto = new TipoProduto();
		
	}
	

	public void inicializar(){
		if(FacesUtil.notIsPostBack()){
			categoriaRaizes = categorias.raizes();
			listaUnidade = unidades.todas();
		}
	}
	
	
public void carregarCategoriasDe(){
		
	subCategorias = categorias.servicoDe(categoriaPai);
		
	}
	
	
	
	
	//G&S
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Unidade> getListaUnidade() {
		return listaUnidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public List<Servicos> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
	public Especialidade getCategoriaPai() {
		return categoriaPai;
	}
	public void setCategoriaPai(Especialidade categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
	public List<Especialidade> getCategoriaRaizes() {
		return categoriaRaizes;
	}
	public List<Especialidade> getSubCategorias() {
		return subCategorias;
	}



	public Especialidades getCategorias() {
		return categorias;
	}



	public void setCategorias(Especialidades categorias) {
		this.categorias = categorias;
	}
	
	
	
	
}
