package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.ui.context.Theme;

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
	private List<Departamento> gerentesSelecionados;
	
	//teste
	private Departamento getente;
	
	
	
	private boolean exibirPikeList = false;
	
	private DualListModel<Departamento> gerentes;


	public void inicializar() {	
		
		if (this.departamentoPosSave == null) {	
			
			limpar();
			
		}		
		
		List<Departamento> departamentosSource = repositorioDepartamentos.todosGerentes();
		List<Departamento> departamentosTarget = new ArrayList<Departamento>();	         
	    setGerentes(new DualListModel<Departamento>(departamentosSource, departamentosTarget));
	    
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
		if (!gerentesSelecionados.isEmpty()){
			for (Departamento dep : gerentesSelecionados){
				
				dep.setDepartamentoPai(departamentoPai);
				
				repositorioDepartamentos.guardar(dep);
				FacesUtil.addInforMessage("Líder " + dep.getNome() + " cadastrado com sucesso");
			}
		
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
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Departamento) item).getNome()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selecionado", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item desselecionado", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

	// G&S

	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;
	}

	

	public DualListModel<Departamento> getGerentes() {
		return gerentes;
	}

	public void setGerentes(DualListModel<Departamento> gerentes) {
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

	public List<Departamento> getGerentesSelecionados() {
		return gerentesSelecionados;
	}

	public void setGerentesSelecionados(List<Departamento> gerentesSelecionados) {
		this.gerentesSelecionados = gerentesSelecionados;
	}

	public Departamento getGetente() {
		return getente;
	}

	public void setGetente(Departamento getente) {
		this.getente = getente;
	}

	
	
	

}
