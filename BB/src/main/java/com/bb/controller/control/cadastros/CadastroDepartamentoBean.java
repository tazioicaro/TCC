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

	private Departamento departamento = new Departamento();
	 private DualListModel<Departamento> gerentes;


	public void inicializar() {		
		
		List<Departamento> departamentosSource = repositorioDepartamentos.todosGerentes();
		 List<Departamento> departamentosTarget = new ArrayList<Departamento>();	         
	      setGerentes(new DualListModel<Departamento>(departamentosSource, departamentosTarget));

	}

	public CadastroDepartamentoBean() {
	
			limpar();
		

	}

	public void cadastrar() {

		try {
			this.departamento = repositorioDepartamentos.guardar(this.departamento);

			FacesUtil.addInforMessage("Departamento " + departamento.getNome() + " cadastrado com sucesso");
			limpar();

		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());

		}

	}

	public void limpar() {	

		departamento = new Departamento();		
		

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
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

	// G&S

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	

	public DualListModel<Departamento> getGerentes() {
		return gerentes;
	}

	public void setGerentes(DualListModel<Departamento> gerentes) {
		this.gerentes = gerentes;
	}

	
	

}
