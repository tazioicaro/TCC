package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Funcionarios;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Funcionario;

public class CadastroFuncionarioServices implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios repositorioFuncionarios;
	
	
	@Transactional
	public Funcionario salvar  (Funcionario funcionario) throws NegocioException{
		
		if(repositorioFuncionarios.porNome(funcionario.getNome())!=null){
			
			throw new NegocioException("Já existe um Funcionário com este mesmo nome: " + funcionario.getNome());
			
		}
		

		if(repositorioFuncionarios.porLogin(funcionario.getLogin())!=null){
			
			throw new NegocioException("Já existe um Funcionário com este mesmo Login: " + funcionario.getLogin());
			
		}
		
		if (repositorioFuncionarios.porCPF(funcionario.getCpf())!= null){
			throw new NegocioException("O CPF "+ funcionario.getCpf() + " é utilizado por outro Funcionário.");
		}
		
		funcionario = repositorioFuncionarios.guardar(funcionario);
		
		return funcionario;
	}

}
