package com.bb.controller.control.cadastros;

import java.io.Serializable;

import com.bb.controller.control.repository.Departamentos;
import com.bb.models.Departamento;

public class CadastroDepartamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Departamento departamento;
	
	private Departamentos repositorioDepartamentos;
	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	

}
