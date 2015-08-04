package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DescricaoVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="venda_codigo")	
	private Venda venda;
	
	
	@ManyToOne	
	@JoinColumn(name="produto_idprodutos")	
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="servico_codigo")	
	private Servicos servicos;
	
	@Column(name="valor_unitario", nullable=false, precision=10, scale=2)
	private BigDecimal vlrUnitario;
	
	

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

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	
	
	

}
