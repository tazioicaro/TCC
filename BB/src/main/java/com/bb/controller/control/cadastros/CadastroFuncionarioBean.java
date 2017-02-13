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



@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	//Preencher 
	@Inject
	private CadastroFuncionarioServices cadastroFuncionacioServices;
	
	//Preencher
	@Inject
	private Grupos repositorioGrupos;
	
	
	private Funcionario usuario;
	private List<Funcionario> listaGrupos;	
	//Fazer depois
	//private GeradorSenha geradorSenha;
	
	
	public CadastroFuncionarioBean(){	
			limpar();	
		
	}
	
	public void inicializar(){
		if ( usuario == null){
			limpar();
		}
		//Fazer
		//obterGrupos();
	}
	
	
	
	
	
	public void limpar(){
		usuario = new Funcionario();
		listaGrupos = new ArrayList<>();
	}
	
	
	
	//G&S
	public Funcionario getUsuario() {
		return usuario;
	}
	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
	}
	public List<Funcionario> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(List<Funcionario> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	
	
	
	
	
	
	
	
	
	
	
}
