package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Funcionarios;
import com.bb.models.Funcionario;

public class CadastroFuncionarioServices implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios repositorioFuncionarios;
	
	
	public Funcionario salvar  (Funcionario funcionario) throws NegocioException{
		
		if(repositorioFuncionarios.porNome(funcionario.getNome())!=null){
			
			throw new NegocioException("Já existe um Funcionário com este mesmo nome: " + funcionario.getNome());
			
		}
		
		if (repositorioFuncionarios.porCPF(funcionario.getCpf())!= null){
			throw new NegocioException("O CPF "+ funcionario.getCpf() + " é utilizado por outro Funcionário.");
		}
		
		funcionario = repositorioFuncionarios.guardar(funcionario);
		
		return funcionario;
	}

}
