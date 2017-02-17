package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.control.repository.Grupos;
import com.bb.controller.security.GeradorSenha;
import com.bb.controller.services.CadastroFuncionarioServices;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;
import com.bb.models.Endereco;
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
	@Inject
	private Departamentos repositorioDepartamos;	
	
	
	
	private Funcionario usuario; //SelecOne 2°
	private Departamento departamento; //SelectOne 1°
	private List<Departamento> deps; //SelectItens 1°
	private List<Departamento> gerentes; //SelectItens2°	
	
	
	private List<Grupo> listaGrupos;
	private GeradorSenha geradorSenha;
	
	public CadastroFuncionarioBean(){	
			limpar();	
		
	}
	
	public void inicializar(){
		if (FacesUtil.notIsPostBack()) {	
			
		deps = repositorioDepartamos.porDepartamento();
		
		if (this.departamento !=null){
			
	      	  obterGerente();
	      	  }		
		}
		
	}
	
	public void obterGerente(){
		gerentes = repositorioDepartamos.porGerente(departamento.getGerente());	
		
	}
	
	public void cadastrar(){
		
		try{
			this.usuario.setSenha(geradorSenha.geradorHash(this.usuario.getSenha()));
			this.usuario = cadastroFuncionacioServices.salvar(this.usuario);
			
			FacesUtil.addInforMessage("Funcionário " + usuario.getNome() + " cadastrado com sucesso!");
			limpar();
			
		}catch(NegocioException | NoSuchAlgorithmException | UnsupportedEncodingException ne){
			
			FacesUtil.addErrorMessage(ne.getMessage());			
		}		
	}
	
	
	List<Grupo> obterGrupos(){		
		return this.listaGrupos = repositorioGrupos.porGrupos();		
	}
	
  	
	public void limpar(){
		usuario = new Funcionario();			
		departamento = null;
		gerentes = new ArrayList<>();
		
		
		listaGrupos = new ArrayList<>();
		geradorSenha = new GeradorSenha();
			
		
	}

	
	
	//G&S
	public Funcionario getUsuario() {
		return usuario;
	}
	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
		
		
		if (this.usuario != null) {
			this.departamento = this.usuario.getDepartamento_codigo();
		}
		
	}
	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<Departamento> getDeps() {
		return deps;
	}

	public void setDeps(List<Departamento> deps) {
		this.deps = deps;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

		

	public List<Departamento> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Departamento> gerentes) {
		this.gerentes = gerentes;
	}

	
	
}
