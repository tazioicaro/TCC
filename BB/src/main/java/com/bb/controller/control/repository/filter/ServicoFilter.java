package com.bb.controller.control.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.bb.models.Enumerators.StatusServico;


public class ServicoFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String nomeVendedor;
	private String nomeCliente;
	private StatusServico[] statuses;
	
	
	
	
	//G&S
	public Long getNumeroDe() {
		return numeroDe;
	}
	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}
	public Long getNumeroAte() {
		return numeroAte;
	}
	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}
	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}
	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}
	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}
	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public StatusServico[] getStatuses() {
		return statuses;
	}
	public void setStatuses(StatusServico[] statuses) {
		this.statuses = statuses;
	}

	
}