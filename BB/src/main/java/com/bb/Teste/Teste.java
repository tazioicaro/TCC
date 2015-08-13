package com.bb.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bb.models.Cliente;
import com.bb.models.Endereco;
import com.bb.models.Enumerators.Sexo;
import com.bb.models.Enumerators.TipoPessoa;


	public class Teste {
		
		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("BB");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction trx = manager.getTransaction();
			trx.begin();
			
			/*
			Cliente cliente = new Cliente();
			
			cliente.setNome("João das Couves dois");
			cliente.setCelular("219804612");
			cliente.setTelefone("25178974");			
			cliente.setEmail("blablabla@");
			cliente.setDocumentoReceitaFederal("123.123.123-12");
			cliente.setTipo(TipoPessoa.FISICA);
			cliente.setLogin("10888378750");
			cliente.setSenha("12365");
			cliente.setSexo(Sexo.MASCULINO);
			cliente.setTipo(TipoPessoa.FISICA);
			
			Endereco endereco = new Endereco();
			
			endereco.setLogradouro("Ruas das Aboboras Vermelhas");
			endereco.setNumero("111");
			endereco.setCidade("Uberlandia");
			endereco.setEstado("MG");
			endereco.setCep("22502-222");
			endereco.setBairro("Das luzes");
			
			//Adicionando o cliente ao endereço
			endereco.setCliente(cliente);
			
			//Adicionando o endereço na lista de endereços do cliente (Graças ao Cascade)
			cliente.getEnderecos().add(endereco);
			
			manager.persist(cliente);*/
			
			trx.commit();
		}

	}



