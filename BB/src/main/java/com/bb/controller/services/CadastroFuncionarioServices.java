package com.bb.controller.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bb.controller.control.repository.Funcionarios;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Funcionario;

public class CadastroFuncionarioServices implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios repositorioFuncionarios;

	@Transactional
	public Funcionario salvar(Funcionario funcionario) throws NegocioException {

		Funcionario funcionarioExistente = repositorioFuncionarios.porCPF(funcionario.getCpf());

	

			if (funcionarioExistente != null && funcionarioExistente.getNome().equals(funcionario.getNome()) &&
					!funcionarioExistente.getCodigo().equals(funcionario.getCodigo())) {

				throw new NegocioException("Já existe um Funcionário com este mesmo nome: " + funcionario.getNome());

			}

			if (funcionarioExistente != null && funcionarioExistente.getLogin().equals(funcionario.getLogin()) &&
					!funcionarioExistente.getCodigo().equals(funcionario.getCodigo())) {

				throw new NegocioException("Já existe um Funcionário com este mesmo Login: " + funcionario.getLogin());

			}

			if (funcionarioExistente != null && funcionarioExistente.getCpf().equals(funcionario.getCpf()) &&
					!funcionarioExistente.getCodigo().equals(funcionario.getCodigo())) {

				throw new NegocioException("Já existe um Funcionário com este mesmo CPF: " + funcionario.getCpf());

			}

			// if (repositorioFuncionarios.porCPF(funcionario.getCpf())!= null){
			// throw new NegocioException("O CPF "+ funcionario.getCpf() + " é
			// utilizado por outro Funcionário.");
			// }

		

		funcionario = repositorioFuncionarios.guardar(funcionario);

		return funcionario;
	}

}
