package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {
	

	private static final long serialVersionUID = 1L;


	@Id	
	private Long codigo;
	
	
	@ManyToOne
	@JoinColumn(name="dservico_codigo")	
	private DescricaoServico servicos;
	
	@Column( columnDefinition = "text")
	private String descricao;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_total")
	private BigDecimal valorTotal;
	
	
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public DescricaoServico getServicos() {
		return servicos;
	}

	public void setServicos(DescricaoServico servicos) {
		this.servicos = servicos;
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
