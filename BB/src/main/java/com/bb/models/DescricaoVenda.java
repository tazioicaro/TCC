package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Named
public class DescricaoVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	private Integer codigo;
	
	@Column(name="venda_codigo")
	@OneToMany
	private Venda venda;
	
	@Column(name="produtos_idprodutos")
	@OneToMany
	private Produto produto;
	
	@Column(name="serviços_codigo_s")
	@OneToMany
	private Servicos servicos;
	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servicos getServicos() {
		return servicos;
	}

	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	
	
	

}
