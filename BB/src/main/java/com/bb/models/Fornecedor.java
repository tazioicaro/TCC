package com.bb.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Long codigo;
	
	@Column(nullable= false, length = 100) //Not null de tamanho 100
	private String nome;

	@Column(nullable= false, length=40)
	private String email;
	
	
	@Column (nullable=false, length=16)
	private String telefone;
	
	
	@Column (length=16)
	private String celular;
	
	@Column (length=18)
	private String fax;
	
	@Column(name="doc_receita_federal", nullable=false, length=14)
	private String documentoReceitaFederal;
	
	@Column(length=100)
	private String obs;

	
	@Column(name="inscricao_estadual", length=12)
	private String insest;
	
	@Column(length=40)
	private String contato;
	
	@Column( columnDefinition = "text")
	private String auditoria;
	
	@JoinColumn(name="banco_codigo")
	@ManyToOne
	private Banco banco;
	
	@JoinColumn(name="endereco_codigo")
	@OneToOne
	private Endereco endereco;
	
		
	//mappeBy informa que dentro da classe produto tem um Fornecedor Muitos para um
	@OneToMany(cascade = CascadeType.ALL, mappedBy="fornecedor",orphanRemoval=true)
	@Fetch(value=FetchMode.SELECT)
	private List<Produto> produtos;
	

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}	
	
	public String getInsest() {
		return insest;
	}
	public void setInsest(String insest) {
		this.insest = insest;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}	

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Transient
	public Integer getProdutosSize()
	{
		if(getProdutos() != null)
			return produtos.size();
		return 0;
	}
	
	@Transient
	public boolean isValido()
	{
		if(nome == null || nome.equals(""))
			return false;
		if(telefone == null || telefone.equals(""))
			return false;
		return true;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}
	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}
	
	

}
