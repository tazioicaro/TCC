package com.bb.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


/**
 * @author Tazio
 *Cabeçalho nota Fiscal
 */

@Entity(name="cnf")
public class CNF implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long numero;
	
	@ManyToOne(fetch=FetchType.LAZY) //vários cabeçalhos para uma operação
	@JoinColumn(nullable=false, name="cfop_codigo")
	private CFOp codFiscalOp;
	

	@ManyToOne(fetch=FetchType.LAZY) //varios cabeçalhos para um fornecedor
	@JoinColumn(nullable=false, name="fornecedor_codigo")
	private Fornecedor fornecedor;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date emissao; // Sql o video util
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada;
	
	@Column(nullable=false, precision=10, scale=2, name="total")
	private BigDecimal total;
	
	@Column (columnDefinition = "text") 
	private String auditoria;
	
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cnf") 
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
	//@JoinColumn(name="cnf_numero", insertable=true, updatable=true)
	private Set<DNF> detalheNF; 
	
	

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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	

}
