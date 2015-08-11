package com.bb.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bb.models.Endereco;
import com.bb.models.Fornecedor;


	public class TesteFornecedor {
		
		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("BB");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction trx = manager.getTransaction();
			trx.begin();
			
		
		
			Fornecedor fornecedor = new Fornecedor();
			

			
			   Endereco endereco = new Endereco();			
				endereco.setLogradouro("Ruas dos Fornecesdores");
				endereco.setNumero("335");
				endereco.setCidade("Forncea");
				endereco.setEstado("RJ");
				endereco.setCep("22502-222");
				endereco.setBairro("squisito");				
				manager.persist(endereco);	
			
				
			
						
			fornecedor.setCelular("6974");
			fornecedor.setContato("contato");
			fornecedor.setDocumentoReceitaFederal("251697-0110");
			fornecedor.setEmail("fornc@.com");
			fornecedor.setInsest("1237");
			fornecedor.setNome("Fornecedor Nome");
			fornecedor.setTelefone("1234576");
			fornecedor.setEndereco(endereco);
					
		
			
			manager.persist(fornecedor);
			
			trx.commit();
		}

	}



