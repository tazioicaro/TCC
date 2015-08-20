package com.bb.Teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bb.models.Departamento;
import com.bb.models.Endereco;
import com.bb.models.Funcionario;
import com.bb.models.Enumerators.Sexo;


	public class TesteFuncionario {
		
		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("BB");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction trx = manager.getTransaction();
			trx.begin();
			
			
				Departamento departamento = new Departamento();
				
				departamento.setGerente("Tazio");
				departamento.setNome("TI");
				
				manager.persist(departamento);				
			
							
            Endereco endereco = new Endereco();			
			endereco.setLogradouro("Ruas dos Funcionários");
			endereco.setNumero("111");
			endereco.setCidade("Uberlandia");
			endereco.setEstado("RJ");
			endereco.setCep("22502-222");
			endereco.setBairro("Das luzes");
			
			manager.persist(endereco);				
		
			
	
			 
			
			Departamento departamentoB = manager.find(Departamento.class, 1L);
			
			Funcionario funcionario = new Funcionario();			
			funcionario.setNome("Nila Marina");
			funcionario.setCelular("219804612");
			funcionario.setTelefone("25178974");			
			funcionario.setEmail("blablabla@");
			funcionario.setCpf("123.123.123-12");			
			funcionario.setLogin("10888378750");
			funcionario.setSenha("12365");
			funcionario.setSexo(Sexo.MASCULINO);
			funcionario.setDepartamento_codigo(departamentoB);
			funcionario.setCargo("Manicure");
			funcionario.setFuncao("Funcao");
			funcionario.setOrgaorg("DETRAN");
			funcionario.setEndereco(endereco);
			funcionario.setRg("211116579");
			funcionario.setDataAdmissao(new Date());
			funcionario.setDataNascimento(new Date());
		
			
			manager.persist(funcionario);
			
			trx.commit();
		}

	}



