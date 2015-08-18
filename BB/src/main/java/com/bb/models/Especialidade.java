package com.bb.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;

	@Column(nullable = false, length = 60)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_pai")
	private Especialidade especialidadePai;
	
	@OneToMany(mappedBy = "especialidadePai", cascade = CascadeType.ALL)
	private List<Especialidade> subEspecialidades = new ArrayList<Especialidade>();
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Especialidade getEspecialidadePpai() {
		return especialidadePai;
	}
	public void setEspecialidadePai(Especialidade especialidadePai) {
		this.especialidadePai = especialidadePai;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	public List<Especialidade> getSubEspecialidades() {
		return subEspecialidades;
	}
	public void setSubEspecialidades(List<Especialidade> subEspecialidades) {
		this.subEspecialidades = subEspecialidades;
	}
	public Especialidade getEspecialidadePai() {
		return especialidadePai;
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
		Especialidade other = (Especialidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
