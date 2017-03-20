package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class CadastroDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Departamentos repositorioDepartamentos;

	private Departamento departamentoPai = new Departamento();
	private Departamento departamentoPosSave;
	private List<String> gerentesSelecionados;
	
	private Departamento departamentoNovoGerente;
	
			
	private boolean exibirPikeList;	
	private boolean exibirNovoGerente;	
	
	private List<String> gerentes = new ArrayList<String>();
	private List<String> gerentesConvert = new ArrayList<String>();


	public void inicializar() {	
		
		if(this.departamentoPai == null){
		obterGerentes();
		exibirPikeList= false;
		exibirNovoGerente = false;
		}
		
		else if (this.departamentoPai.getCodigo()!= null) {
			edicaoGerentes();			
			exibirPikeList = true;
					}	
	    
	}

	public CadastroDepartamentoBean() {
	
			limpar();		

	}
	
	List<String> obterGerentes() {
		return this.gerentes = repositorioDepartamentos.todosGerentesString();
		
	}
	
	
	
	public void cadastrar(){
		
		try {
			this.departamentoPai = repositorioDepartamentos.guardar(this.departamentoPosSave);
			FacesUtil.addInforMessage("Departamento " + departamentoPosSave.getNome() + " cadastrado com sucesso");
			limpar();
			obterGerentes();
			exibirPikeList = true;
			
			
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
			
		}		
	}
	
	
	public void cadastrarGerentes(){	
		
		Departamento dep;
		
		try{
		
		if (!gerentesConvert.isEmpty()){
			for (String depo : gerentesConvert){
				
				dep = new Departamento();
				
				dep.setDepartamentoPai(departamentoPai);
				dep.setNome(depo);
				
			
				repositorioDepartamentos.guardar(dep);
			}			
			
			FacesUtil.addInforMessage("Líder(es) cadastrado(s) com sucesso");			
		
		}	
		
		departamentoPai= new Departamento();
		exibirPikeList = false;
		
		} catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
			
		}	
	
	}	
	


	public void limpar() {	

		departamentoPosSave = new Departamento();		

	}
	
	
	public void edicaoGerentes(){	
		    obterGerentes();
			
			for ( Departamento dep : departamentoPai.getGerentes()){	
				
				gerentesConvert.add(dep.getNome());
			
		}
		
	}	

	//Possibilita salvar paenas um líder por demartamento
	public void cadastrarNovoGerente(){
		
		try{
			departamentoNovoGerente.setDepartamentoPai(departamentoPai);
			repositorioDepartamentos.guardar(departamentoNovoGerente);
			
			FacesUtil.addInforMessage("Líder " + departamentoNovoGerente.getNome()+" criado com sucesso "+
					"e vinculado ao Departamento "+ departamentoPai.getNome()+" !");
		}catch(NegocioException ne) {
			
			FacesUtil.addErrorMessage(ne.getMessage());			
		}		
	}	

	public void liberarCadastroNovoGerente (){
		
		exibirNovoGerente = true;
		departamentoNovoGerente = new Departamento();		
		
	}
	
	public void alterarExibirPikeList(){
		exibirPikeList = true;
		
	}	
	

	public void onTransfer(TransferEvent event) {

    } 
 
    public void onSelect(SelectEvent event) {

    }
     
    public void onUnselect(UnselectEvent event) {

    }
     
    public void onReorder() {
    } 

	// G&S

	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;	
		
	}	

	public List<String> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<String> gerentes) {
		this.gerentes = gerentes;
	}

	public boolean isExibirPikeList() {
		return exibirPikeList;
	}

	public void setExibirPikeList(boolean exibirPikeList) {
		this.exibirPikeList = exibirPikeList;
	}

	public Departamento getDepartamentoPosSave() {
		return departamentoPosSave;
	}

	public void setDepartamentoPosSave(Departamento departamentoPosSave) {
		this.departamentoPosSave = departamentoPosSave;
	}

	public List<String> getGerentesSelecionados() {
		return gerentesSelecionados;
	}

	public void setGerentesSelecionados(List<String> gerentesSelecionados) {
		this.gerentesSelecionados = gerentesSelecionados;
	}



	public List<String> getGerentesConvert() {
		return gerentesConvert;
	}

	public void setGerentesConvert(List<String> gerentesConvert) {
		this.gerentesConvert = gerentesConvert;
	}

	public boolean isExibirNovoGerente() {
		return exibirNovoGerente;
	}

	public void setExibirNovoGerente(boolean exibirNovoGerente) {
		this.exibirNovoGerente = exibirNovoGerente;
	}

	public Departamento getDepartamentoNovoGerente() {
		return departamentoNovoGerente;
	}

	public void setDepartamentoNovoGerente(Departamento departamentoNovoGerente) {
		this.departamentoNovoGerente = departamentoNovoGerente;
	}

	
	
	
	

}
