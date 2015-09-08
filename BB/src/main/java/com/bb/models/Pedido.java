package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {
	

	private static final long serialVersionUID = 1L;


	@Id	
	@GeneratedValue
	private Long codigo;
		

	@Column( columnDefinition = "text")
	private String descricao;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_total")
	private BigDecimal valorTotal;
	
	@OneToMany(mappedBy="pedido", cascade = CascadeType.ALL)
	private List<Venda> vendas = new ArrayList<Venda>();
	
	

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
