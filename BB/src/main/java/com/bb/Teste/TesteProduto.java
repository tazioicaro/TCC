package com.bb.Teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bb.models.Endereco;
import com.bb.models.Fornecedor;
import com.bb.models.Produto;
import com.bb.models.TipoProduto;
import com.bb.models.Unidade;


	public class TesteProduto {
		
		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("BB");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction trx = manager.getTransaction();
			trx.begin();
			
			//TipoProduto tipoProduto = manager.find(TipoProduto.class, 1L);
			
			Unidade unidade = manager.find(Unidade.class,1L);
			
			//Produto produto = new Produto();
			Fornecedor fornecedor = new Fornecedor();
			
		//	produto.setCritico(10);
		//	produto.setDescricao("Descricao Produto");
		//	produto.setEstoque(200);
		//	produto.setFornecedor(fornecedor);
		//	produto.setNome("Nome Produto");
		//	produto.setServicos(null);
		//	produto.setTipoProduto(tipoProduto);
		//	produto.setUnidade(unidade);
		//	produto.setVlrcompra(new BigDecimal(3.12));
		//	produto.setVlrvenda(new BigDecimal(8.85));
			
		//	manager.persist(produto);	
		
			
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



