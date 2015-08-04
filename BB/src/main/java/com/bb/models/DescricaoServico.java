package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity (name="descricao_servico")
public class DescricaoServico implements Serializable {
	
		private static final long serialVersionUID = 1L;

	@Id	
	private Long codigo;
	
	
	@ManyToOne
	@JoinColumn(name="servico_codigo")	
	private Servicos servicos;
	
	@Column( columnDefinition = "text")
	private String descricao;
	
	@Column(nullable=false, precision=10, scale=2, name="valor_total")
	private BigDecimal valorTotal;
	
	
	
	
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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
	public Servicos getServicos() {
		return servicos;
	}
	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	
	
	
	
	
	

}
