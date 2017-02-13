package com.bb.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="grupo")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	private Long codigo;
	
	@Column(nullable=false, length=40)
	private String nome;
	
	@Column(nullable=false, length=80)
	private String descricao;
	
	
	public Long getId() {
		return codigo;
	}
	public void setId(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Grupo other = (Grupo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	

	




	
	
	
//	
//
//	@Id
//	@GeneratedValue	
//	private Long id;
//	
//	private String nome;
//	private String descricao;
//	
////	@ManyToOne	
////	@JoinTable(name="usuario_grupo", joinColumns={@JoinColumn(name="usuario_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="grupos_id", referencedColumnName="id")})
//	//private Usuario usuario;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//    private UsuarioGrupo usuarioGrupo;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//	
//	
//	
//
//	public UsuarioGrupo getUsuarioGrupo() {
//		return usuarioGrupo;
//	}
//
//	public void setUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
//		this.usuarioGrupo = usuarioGrupo;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Grupo other = (Grupo) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//
////	public Usuario getUsuario() {
////		return usuario;
////	}
////
////	public void setUsuario(Usuario usuario) {
////		this.usuario = usuario;
////	}
//
//	

}
