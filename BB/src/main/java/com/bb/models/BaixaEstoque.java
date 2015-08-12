package com.bb.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="baixa_estoque")
public class BaixaEstoque  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigo;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="produto_codigo")
	private Produto produto;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="funci_entrega_codigo")
	private Funcionario funciEntrega;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="autorizante_codigo")
	private Funcionario autorizante;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="solicitante_codigo")
	private Funcionario solicitante;
	
	@NotBlank @Size (max=10)
	@Column(length=10)
	private Integer qtde;
	
	@Size (max=10)
	@Column(length=10)
	private Integer autorizado;
	
	@NotNull
	@Column(name="data_solicitacao")
	private Date dataSolicitacao;
	
	@Column(name="data_entrega")
	private Date dataEntrega;
	
	@Column(name="data_autorizacao")
	private Date dataAutorizacao;	
	
	@NotBlank @Size (max=10)
	@Column(name="qtde_entregue", length=10)
	private Integer  qtdeEntreque;
	
	//Gets-Sets
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Funcionario getFunciEntrega() {
		return funciEntrega;
	}
	public void setFunciEntrega(Funcionario funciEntrega) {
		this.funciEntrega = funciEntrega;
	}
	public Funcionario getAutorizante() {
		return autorizante;
	}
	public void setAutorizante(Funcionario autorizante) {
		this.autorizante = autorizante;
	}
	public Funcionario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}
	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}
	public Integer getAutorizado() {
		return autorizado;
	}
	public void setAutorizado(Integer autorizado) {
		this.autorizado = autorizado;
	}
	public Integer getQtdeEntreque() {
		return qtdeEntreque;
	}
	public void setQtdeEntreque(Integer qtdeEntreque) {
		this.qtdeEntreque = qtdeEntreque;
	}
	

	
}


