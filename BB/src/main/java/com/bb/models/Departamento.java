package com.bb.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
//	@NotNull @Size(max=30)
//	@Column(length=30)
//	private String gerente;
	
	@NotNull @Size(max=45)
	@Column(length=45)
	private String nome; //Descrição	
	
	@ManyToOne
	@JoinColumn(name = "departamento_pai_codigo")
	private Departamento departamentoPai;
	
	@OneToMany(mappedBy = "departamentoPai")
	private List<Departamento> gerentes = new ArrayList<>();//subcategorias
	
	@Column(nullable = true, length=254)
	private String descricao;	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
//	public String getGerente() {
//		return gerente;
//	}
//	public void setGerente(String gerente) {
//		this.gerente = gerente;
//	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}
	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;
	}
	public List<Departamento> getGerentes() {
		return gerentes;
	}
	public void setGerentes(List<Departamento> gerentes) {
		this.gerentes = gerentes;
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
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	

}
