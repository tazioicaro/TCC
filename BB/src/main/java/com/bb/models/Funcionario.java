package com.bb.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;

import com.bb.models.Enumerators.Sexo;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Size(max = 100)
	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotBlank
	@Column(nullable = false, length = 14)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Sexo sexo;

	@Column(length = 10)
	private String ctps;

	@Column(name = "data_admissao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao;

	@Column(length = 12)
	private String telefone;

	@Column(nullable = true, length = 12)
	private String celular;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(nullable = true, length = 12)
	private String funcao;

	@Column(nullable = true, length = 14)
	private String rg;

	@Column(nullable = true, length = 10)
	private String orgaorg;

	@Column(nullable = true, length = 16)
	private String cargo;

	
	
	@JoinColumn(nullable = true, name = "endereco_codigo") 
	@ManyToOne(optional=true, fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REFRESH})
	@Cascade({org.hibernate.annotations.CascadeType.MERGE})
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(nullable = true, name = "departamento_codigo")
	private Departamento departamento_codigo;

	@Column(length = 40)
	private String email;

	@Column(length = 20)
	private String login;

	@Column(length = 255)
	private String senha;

	@Column(columnDefinition = "text")
	private String auditoria;

	@Column(length = 10)
	private String actotal;
		

	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name = "funcionario_grupo", joinColumns = @JoinColumn(name = "funcionario_id"), 
	inverseJoinColumns = @JoinColumn(name = "grupo_codigo"))
	private List<Grupo> grupos = new ArrayList<Grupo>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
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

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

}