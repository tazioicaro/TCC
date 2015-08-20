package com.bb.Teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bb.models.Especialidade;
import com.bb.models.Fornecedor;
import com.bb.models.Produto;
import com.bb.models.TipoProduto;
import com.bb.models.Unidade;


	public class TesteProdutos {
		
		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("BB");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction trx = manager.getTransaction();
			trx.begin();
			
			TipoProduto tipoProduto = manager.find(TipoProduto.class, 1L);
			
			Unidade unidade = manager.find(Unidade.class,1L);
			
			Produto produto = new Produto();
			Fornecedor fornecedor = manager.find(Fornecedor.class,1L);
			
			Especialidade especialidade = manager.find(Especialidade.class, 9L);					
			
			produto.setSku("AN9874");
			produto.setCritico(10);
			produto.setDescricao("Descricao Produto");
			produto.setEstoque(200);
			produto.setFornecedor(fornecedor);
			produto.setNome("Nome Produto");
			produto.setServicos(null);
			produto.setTipoProduto(tipoProduto);
			produto.setUnidade(unidade);
			produto.setVlrcompra(new BigDecimal(3.12));
			produto.setVlrvenda(new BigDecimal(8.85));
			
			produto.setEspecialidade(especialidade);
			
			manager.persist(produto);	
		
		
			trx.commit();
		}

	}



