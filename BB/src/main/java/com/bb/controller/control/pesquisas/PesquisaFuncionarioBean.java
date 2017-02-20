package com.bb.controller.control.pesquisas;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.control.repository.Funcionarios;
import com.bb.controller.control.repository.Grupos;

public class PesquisaFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios repositorioFuncionario;
	
	@Inject
	private Grupos repositorioGrupos;
	
	@Inject
	private Departamentos repositorioDepartamento;
	
	

}
