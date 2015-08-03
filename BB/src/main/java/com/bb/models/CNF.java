package com.bb.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;


/**
 * @author Tazio
 *Cabeçalho nota Fiscal
 */

//@Named("cabecalho_nfe")
public class CNF implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	private Long numero;
	
	@ManyToOne(fetch=FetchType.LAZY) //vários cabeçalhos para uma operação
	@JoinColumn(name="cfop_codigo")
	private CFOp codFiscalOp;
	

	@ManyToOne(fetch=FetchType.LAZY) //varios cabeçalhos para um fornecedor
	@JoinColumn(name="fornecedor_codigo_for")
	private Fornecedor fornecedor;
	
	private Date emissao; // Sql o video util
	private Date entrada;
	private Double total;
	private String auditoria;
	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cnf") //Existe o CNF na classe DNF
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) //Salva e atualiza no Set
	@JoinColumn(name="nfe_numero", insertable=true, updatable=true)
	private Set<DNF> detalheNF; //Mapeamento bidirecional /** devido ao Set necessita de um cascateamento*/
	
	

	public Set<DNF> getDetalheNF() {
		return detalheNF;
	}

	public void setDetalheNF(Set<DNF> detalheNF) {
		this.detalheNF = detalheNF;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public CFOp getCodFiscalOp() {
		return codFiscalOp;
	}

	public void setCodFiscalOp(CFOp codFiscalOp) {
		this.codFiscalOp = codFiscalOp;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	

}
