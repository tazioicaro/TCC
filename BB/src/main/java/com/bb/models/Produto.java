package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.bb.controller.services.validation.SKU;


@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank @SKU
	@Column(nullable = false, length = 20, unique = true)
	private String sku;
	
	@Column(length=30)
	private String nome;
	
	@Column(length=30)
	private String descricao;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_compra")
	private BigDecimal vlrcompra;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_venda")
	private BigDecimal vlrvenda;
	

	@Column(length=10)
	@NotNull @Min(0) @Max(9999)
	private Integer estoque;
	
	
	@Column(length=10)
	private Integer critico;
	
	@Column (columnDefinition = "text") 
	private String auditoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false,name="unidade_codigo")
	private Unidade unidade;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="fornecedor_codigo")
	private Fornecedor fornecedor;
			
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="tipo_produto_codigo")
	private TipoProduto tipoProduto;
	
	@ManyToMany(mappedBy="produto")	
	private List<Servicos> servicos;

	
	
	
	
	public List<Servicos> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
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
	public BigDecimal getVlrcompra() {
		return vlrcompra;
	}
	public void setVlrcompra(BigDecimal vlrcompra) {
		this.vlrcompra = vlrcompra;
	}
	public BigDecimal getVlrvenda() {
		return vlrvenda;
	}
	public void setVlrvenda(BigDecimal vlrvenda) {
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
	
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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
	
	@Transient
	public boolean isValido(){
		if(descricao != null && descricao.length()> 3 && unidade !=null && fornecedor !=null)
			return true;
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
