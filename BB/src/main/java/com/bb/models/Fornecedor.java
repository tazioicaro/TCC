package com.bb.models;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	


	private Integer codigo;
	
	private String nome;

	private String email;
	
	private String telefone;
	private String celular;
	private String fax;
	private String cpf;
	private String cnpj;
	private String obs;
	private String rg;
	private String orgaorg;
	private Date desde;
	
	@Column(name="inscricao_estadual")
	private String insest;
	
	@Column(name="inscricao_municipal")
	private String insemn;

	private String contato;
	private String auditoria;
	
	@JoinColumn(name="banco_codigo")
	@OneToOne
	private Banco banco;
	
	@JoinColumn(name="endereco_codigo_en")
	@OneToOne
	private Endereco endereco;
	
	private List<Produto> produtos;
	
	@Id
	@GeneratedValue
	@Column(name="codigo_for")
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaorg() {
		return orgaorg;
	}
	public void setOrgaorg(String orgaorg) {
		this.orgaorg = orgaorg;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	
	
	public void setDesdeString(String desdeString) throws ParseException {
		if(desdeString != null && !desdeString.equals(""))
		{
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			setDesde(new Date(df.parse(desdeString).getTime()));
		}
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	//mappeBy informa que dentro da classe produto tem um Fornecedor Muitos para um
	@OneToMany(fetch= FetchType.LAZY, mappedBy="fornecedor")
	@Fetch(value=FetchMode.SELECT)
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
	public String getInsemn() {
		return insemn;
	}
	public void setInsemn(String insemn) {
		this.insemn = insemn;
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

}
