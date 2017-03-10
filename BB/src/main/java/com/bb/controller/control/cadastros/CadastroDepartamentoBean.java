package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

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
	
	//teste
	private Departamento getente;
	
	
	
	private boolean exibirPikeList = false;	
	private DualListModel<String> gerentes;


	public void inicializar() {	
		
		if (this.departamentoPosSave == null) {	
			
			limpar();
			
		}		
		
		
		
		
		List<String> departamentosSource = repositorioDepartamentos.todosGerentesString();
		List<String> departamentosTarget = new ArrayList<String>();
		gerentes = new DualListModel<String>(departamentosSource, departamentosTarget);
	    
	}

	public CadastroDepartamentoBean() {
	
			limpar();		

	}
	
	
	public void cadastrar(){
		
		try {
			this.departamentoPai = repositorioDepartamentos.guardar(this.departamentoPosSave);
			FacesUtil.addInforMessage("Departamento " + departamentoPosSave.getNome() + " cadastrado com sucesso");
			limpar();
			
			
		}catch(NegocioException ne){
			FacesUtil.addErrorMessage(ne.getMessage());
			
		}		
	}
	
	public void cadastrarGerentes(){
		
		gerentesSelecionados = gerentes.getTarget();
		
		Departamento dep;
		
		if (!gerentesSelecionados.isEmpty()){
			for (String depo : gerentesSelecionados){
				
				dep = new Departamento();
				
				dep.setDepartamentoPai(departamentoPai);
				dep.setNome(depo);
				
			
				repositorioDepartamentos.guardar(dep);
			}			
			
			FacesUtil.addInforMessage("Líder(es) cadastrado(s) com sucesso");			
		
		}	
	
	}	
	

//	public void cadastrar() {
//
//		try {
//			this.departamentoPai = repositorioDepartamentos.guardar(this.departamentoPosSave);
//
//			FacesUtil.addInforMessage("Departamento " + departamentoPosSave.getNome() + " cadastrado com sucesso");
//			alterarExibirPikeList();
//			limpar();
//
//		} catch (NegocioException ne) {
//			FacesUtil.addErrorMessage(ne.getMessage());
//
//		}
//
//	}
//	
//	
//	public void cadastrarGerentes(){
//		
//		gerentesSelecionados = gerentes.getTarget();
//		
//		
//		if (!gerentesSelecionados.isEmpty()){
//		for (Departamento dep : gerentesSelecionados){
//			
//			dep.setDepartamentoPai(departamentoPai);
//			
//			repositorioDepartamentos.guardar(dep);
//		}
//		
//		}
//		
//	}

	public void limpar() {	

		departamentoPosSave = new Departamento();		

	}
	
	public void alterarExibirPikeList(){
		exibirPikeList = true;
		
	}	
	

	public void onTransfer(TransferEvent event) {
//        StringBuilder builder = new StringBuilder();
//        for(Object item : event.getItems()) {
//            builder.append(((Departamento) item).getNome()).append("<br />");
//        }
//         
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Itens Transferidos");
//        msg.setDetail(builder.toString());
//         
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
//    	FacesUtil.addInforMessage("Item " + event.getObject().toString()+ " Selecionado" );
    }
     
    public void onUnselect(UnselectEvent event) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item desselecionado", event.getObject().toString()));
    }
     
    public void onReorder() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Lista Reorganizada", null));
    } 

	// G&S

	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;
	}

	

	public DualListModel<String> getGerentes() {
		return gerentes;
	}

	public void setGerentes(DualListModel<String> gerentes) {
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

	public Departamento getGetente() {
		return getente;
	}

	public void setGetente(Departamento getente) {
		this.getente = getente;
	}

	
	
	

}
