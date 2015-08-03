package com.bb.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bb.models.Enumerators.Sexo;

@Entity
public class Cliente implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="codigo_cli")
	@GeneratedValue
	private Integer codigo;
	
	@Column (nullable=false, length=14)
	private String cpf;
	
	@Column(nullable= false, length = 100) //Not null de tamanho 100
	private String nome;
	
	@Column(name="data_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column (nullable=false, length=12)
	private String telefone;
	
	@Column (nullable=false, length=12)
	private String celular;
	
	@Column (length=40)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column( length=10)
	private Sexo sexo;
	
	
	@OneToMany(mappedBy="cliente", cascade= CascadeType.ALL)	
	private List<Endereco> enderecos;
	
	@Column( length=150)
	private String obs;
	
	@Column( length=11)
	private Integer login;
	
	@Column( length=20)
	private String senha;
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public List<Endereco> getEndereco() {
		return enderecos;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.enderecos = endereco;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

}
