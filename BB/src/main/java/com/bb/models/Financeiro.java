package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Financeiro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valorCaixa;
	
	@OneToMany
	@JoinColumn(name="total_venda", nullable=false)
	private List<Venda> totalVenda;
	
	@OneToMany
	@JoinColumn(name="total_comissao")
	private List<Comissao> totalComissao;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal totalCusto;
	
	@OneToMany
	@JoinColumn(name="total_adiantamento")
	private List<Adiantamento> totalAdiantamento;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValorCaixa() {
		return valorCaixa;
	}
	public void setValorCaixa(BigDecimal valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
	public List<Venda> getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(List<Venda> totalVenda) {
		this.totalVenda = totalVenda;
	}
	public List<Comissao> getTotalComissao() {
		return totalComissao;
	}
	public void setTotalComissao(List<Comissao> totalComissao) {
		this.totalComissao = totalComissao;
	}
	public BigDecimal getTotalCusto() {
		return totalCusto;
	}
	public void setTotalCusto(BigDecimal totalCusto) {
		this.totalCusto = totalCusto;
	}
	public List<Adiantamento> getTotalAdiantamento() {
		return totalAdiantamento;
	}
	public void setTotalAdiantamento(List<Adiantamento> totalAdiantamento) {
		this.totalAdiantamento = totalAdiantamento;
	}
	
	
	

}
