package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

import com.bb.controller.control.repository.Grupos;
import com.bb.controller.security.GeradorSenha;
import com.bb.controller.services.CadastroFuncionarioServices;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
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
	private GeradorSenha geradorSenha;
	
	
	public CadastroFuncionarioBean(){	
			limpar();	
		
	}
	
	public void inicializar(){
		if ( usuario == null){
			limpar();
		}
		
		obterGrupos();
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
		listaGrupos = new ArrayList<>();
		geradorSenha = new GeradorSenha();
	}
	
	public boolean isEditando(){
		
		return this.usuario.getCodigo()!= null;
	}
	
	//Para funcioanr as mensagens do  painel
	
//	public void onClose(CloseEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//     
//    public void onToggle(ToggleEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
	
	
	
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
