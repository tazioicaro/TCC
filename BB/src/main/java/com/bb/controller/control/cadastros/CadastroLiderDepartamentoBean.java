package com.bb.controller.control.cadastros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;

@Named
@ViewScoped
public class CadastroLiderDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Departamentos repositorioDepartamentos;
	private Departamento lider = new Departamento();
	
	

	public void inicializar() {

		if(lider == null)		
		limpar();

	}

	public CadastroLiderDepartamentoBean() {

		limpar();

	}

	

	public void cadastrar() {

		try {
			
			repositorioDepartamentos.guardar(this.lider);
			
			FacesUtil.addInforMessage("Líder "+ lider.getNome()+ " alterado com sucesso!");
			
			limpar();

		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());

		}
	}

	
	public void limpar() {

	 lider = new Departamento();

	}

	// G&S

	public Departamento getLider() {
		return lider;
	}

	public void setLider(Departamento lider) {
		this.lider = lider;

	}	

}
