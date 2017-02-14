package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Grupos;
import com.bb.controller.services.CadastroFuncionarioServices;
import com.bb.models.Funcionario;
import com.bb.models.Grupo;



@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

 
	@Inject
	private CadastroFuncionarioServices cadastroFuncionacioServices;
	
	
	@Inject
	private Grupos repositorioGrupos;
	
	
	private Funcionario usuario;
	private List<Grupo> listaGrupos;	
	//Fazer depois
	//private GeradorSenha geradorSenha;
	
	
	public CadastroFuncionarioBean(){	
			limpar();	
		
	}
	
	public void inicializar(){
		if ( usuario == null){
			limpar();
		}
		
		obterGrupos();
	}
	
	
	List<Grupo> obterGrupos(){		
		return this.listaGrupos = repositorioGrupos.porGrupos();		
	}
	
	
	
	public void limpar(){
		usuario = new Funcionario();
		listaGrupos = new ArrayList<>();
	}
	
	public boolean isEditando(){
		
		return this.usuario.getCodigo()!= null;
	}
	
	
	
	//G&S
	public Funcionario getUsuario() {
		return usuario;
	}
	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
	}
	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	
	
	
	
	
	
	
	
	
	
	
}
