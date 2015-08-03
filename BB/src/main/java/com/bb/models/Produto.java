package com.bb.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


//@Named
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descricao;
	private Double vlrcompra;
	private Double vlrvenda;
	private Integer estoque;
	private Integer critico;
	private String auditoria;
	
	private Unidade unidade;
	private Fornecedor fornecedor;
	private TipoProduto tipoProduto;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pro")
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getVlrcompra() {
		return vlrcompra;
	}
	public void setVlrcompra(Double vlrcompra) {
		this.vlrcompra = vlrcompra;
	}
	public Double getVlrvenda() {
		return vlrvenda;
	}
	public void setVlrvenda(Double vlrvenda) {
		this.vlrvenda = vlrvenda;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Integer getCritico() {
		return critico;
	}
	public void setCritico(Integer critico) {
		this.critico = critico;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidade_codigo")
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor_codigo_for")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_produtos_codigo_tpr")
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}
	
	
	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	@Transient
	public boolean isValido(){
		if(descricao != null && descricao.length()> 3 && unidade !=null && fornecedor !=null)
			return true;
		return false;
	}
	
	

}
