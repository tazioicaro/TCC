package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity (name="descricao_servico")
public class DescricaoServico implements Serializable {
	
		private static final long serialVersionUID = 1L;

	@Id	
	private Long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="servico_codigo")	
	private Servicos servicos;
	
	@NotBlank
	@Column( columnDefinition = "text")
	private String descricao;
	
	
	@Column(nullable=false, precision=10, scale=2, name="valor_total")
	private BigDecimal valorTotal;
	
	@Column(name="duracao_unitaria")
	@Temporal(TemporalType.TIME)
	private Date tempoPorServico;
	
	
	@Column(name="duracao_total")
	@Temporal(TemporalType.TIME)
	private Date tempoTotalServivo;
	
	
	
	
	
	
	public Date getTempoPorServico() {
		return tempoPorServico;
	}
	public void setTempoPorServico(Date tempoPorServico) {
		this.tempoPorServico = tempoPorServico;
	}
	public Date getTempoTotalServivo() {
		return tempoTotalServivo;
	}
	public void setTempoTotalServivo(Date tempoTotalServivo) {
		this.tempoTotalServivo = tempoTotalServivo;
	}
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
