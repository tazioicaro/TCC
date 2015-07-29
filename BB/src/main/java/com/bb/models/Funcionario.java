package com.bb.models;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Named
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_f")
	private Integer codigo;
	
	private String nome;
	
	private String cpf;
	private Boolean sexo;
	private String ctps;
	
	@Column(name="data_admissao")
	private Date dataAdmissao;
	private String telefone;
	private String celular;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	private String funcao;
	private String rg;
	private String orgaorg;
	private String  cargo;

	@JoinColumn(name="endereco_codigo_en")
	@OneToOne
	private Endereco endereco;	
	
	
	@JoinColumn(name="departamento_codigo_dep")
	@ManyToOne
	private Departamento departamento_codigo;	
	
		
	private String email;	
	private Integer login;
	private String senha;
	
	private String auditoria;
	private String actotal;
	
			
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Departamento getDepartamento_codigo() {
		return departamento_codigo;
	}
	public void setDepartamento_codigo(Departamento departamento_codigo) {
		this.departamento_codigo = departamento_codigo;
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
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String fone) {
		this.telefone = fone;
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
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	public Integer getLogin() {
		return login;
	}
	public void setLogin(Integer login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	public String getActotal() {
		return actotal;
	}
	public void setActotal(String actotal) {
		this.actotal = actotal;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date data_admissao) {
		this.dataAdmissao = data_admissao;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
