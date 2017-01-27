package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@GeneratedValue
	private Long codigo;
	
	@NotBlank @SKU
	@Column(nullable = false, length = 20, unique = true)
	private String sku;
	
	@Column(length=30)
	private String nome;
	
	@Column(length=30)
	private String descricao;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_compra")
	private BigDecimal vlrcompra;
	
	@Column(nullable=true, precision=10, scale=2, name="valor_venda")
	private BigDecimal vlrvenda;
	

	@Column(length=10)
	@NotNull @Min(0) @Max(9999)
	private Integer estoque;
	
	
	@Column(length=10)
	private Integer critico;
	
	@Column (columnDefinition = "text") 
	private String auditoria;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false,name="unidade_codigo")
	private Unidade unidade;
	
	
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(nullable=false, name="fornecedor_codigo")
	private Fornecedor fornecedor;
			
	
	@Column(name="volume_conteudo", precision=10, scale=2)
	@NotNull @Min(0)
	private double volumeConteudo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=true, name="tipo_produto_codigo")
	private TipoProduto tipoProduto;
	
	@OneToMany(mappedBy="produto")
	private List<ServicosProdutos> servicosProdutosList;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name="especialidade_codigo", nullable=false )
	private Especialidade especialidade;
	
	@Column(name="data_inclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	
	
	//G&S
	
	
	public List<ServicosProdutos> getServicosProdutosList() {
		return servicosProdutosList;
	}
	public void setServicos(List<ServicosProdutos> servicosProdutosList) {
		this.servicosProdutosList = servicosProdutosList;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public double getVolumeConteudo() {
		return volumeConteudo;
	}
	public void setVolumeConteudo(double volumeConteudo) {
		this.volumeConteudo = volumeConteudo;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
