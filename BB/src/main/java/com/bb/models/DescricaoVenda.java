package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="descricao_venda")
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
	private Servico servicos;
	
	@Column(name="valor_unitario", nullable=false, precision=10, scale=2)
	private BigDecimal vlrUnitario;
	
	@Column(name="valor_total", nullable=false, precision=10, scale=2)
	private BigDecimal vlrTotal;
	
	
	

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

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

	public Servico getServicos() {
		return servicos;
	}

	public void setServicos(Servico servicos) {
		this.servicos = servicos;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	
	
	

}
