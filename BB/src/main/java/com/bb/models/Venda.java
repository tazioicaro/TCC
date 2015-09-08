package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(name="data_venda")
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	

	@ManyToOne	
	private Pedido pedido;	


	@Column(name="valor_unitario", nullable=false, precision=10, scale=2)
	private BigDecimal vlrUnitario;
	
	
	@Column(name="valor_total", nullable=false, precision=10, scale=2)
	private BigDecimal vlrtotal;
	
	@ManyToOne
	@JoinColumn(name="cfop_codigo")
	private CFOp cfOp;
	
	@ManyToOne
	@JoinColumn(name="tipo_pagamento")
	private TipoPagamento tipoPagamento;
	
	@ManyToOne
	@JoinColumn(name="funcionario_codigo")
	private Funcionario funcionario;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_codigo")
	private Cliente cliente;
	
	@Embedded
	private EnderecoEntrega enderecoEntrega;
	
	
	
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public CFOp getCfOp() {
		return cfOp;
	}

	public void setCfOp(CFOp cfOp) {
		this.cfOp = cfOp;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public BigDecimal getVlrtotal() {
		return vlrtotal;
	}

	public void setVlrtotal(BigDecimal vlrtotal) {
		this.vlrtotal = vlrtotal;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		Venda other = (Venda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
